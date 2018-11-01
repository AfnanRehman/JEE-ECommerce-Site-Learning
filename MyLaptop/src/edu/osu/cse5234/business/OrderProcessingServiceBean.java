package edu.osu.cse5234.business;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.ws.WebServiceRef;

import com.chase.payment.*;
import com.ups.shipping.client.ShippingInitiationClient;

import edu.osu.cse5234.model.Order;
import edu.osu.cse5234.model.PaymentInfo;
import edu.osu.cse5234.util.ServiceLocator;

/**
 * Session Bean implementation class OrderProcessingServiceBean
 */
@Stateless
@LocalBean
public class OrderProcessingServiceBean {

	@WebServiceRef(wsdlLocation = "http://localhost:9080/ChaseBankApplication/PaymentProcessorService?wsdl")
	private PaymentProcessorService service;

	private static String shippingResourceURI = "http://localhost:9080/UPS/jaxrs";

	private int confirmationcode = 0;

	@PersistenceContext
	EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public OrderProcessingServiceBean() {
	}

	public String processOrder(Order order) {
		CreditCardPayment ccPayment = new CreditCardPayment();
		PaymentInfo pInfo = order.getPayment();
		ccPayment.setCcNumber(pInfo.getCcNumber());
		ccPayment.setCvvCode(pInfo.getCvvCode());
		ccPayment.setExpDate(pInfo.getExpDate());
		ccPayment.setHolderName(pInfo.getHolderName());
		double value = 0.0;
		for (int i = 0; i < order.getLineItems().size(); i++) {
			value += order.getLineItems().get(i).getPrice() * order.getLineItems().get(i).getQuantity();
		}
		ccPayment.setPaymentAmount(value);

		String res = service.getPaymentProcessorPort().processPayment(ccPayment);
		if (Integer.parseInt(res) < 0)
			return "";
		pInfo.setConfirmationNumber(res);

		if (validateItemAvailability(order)) {
			confirmationcode++;
			entityManager.persist(order);
			entityManager.flush();

		}

		ShippingInitiationClient shippingInitiationClient = new ShippingInitiationClient(shippingResourceURI);

		JsonObject responseJson = Json.createObjectBuilder().add("Accepted", true).add("ShippingReferenceNumber", 1005)
				.add("Zip", order.getShipping().getZip()).add("ItemsNumber", order.getLineItems().size())
				.add("Organization", "MyLaptop Inc").add("OrderRefId", order.getId()).build();

		shippingInitiationClient.invokeInitiateShipping(responseJson);

		return confirmationcode + "";

	}

	public boolean validateItemAvailability(Order order) {
		return ServiceLocator.getInventoryService().validateQuantity(order.getItems());
	}

}
