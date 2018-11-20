package edu.osu.cse5234.batch;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;



public class InventoryUpdater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Starting Inventory Update ...");
		try {
			Connection conn = createConnection();
			Collection<Integer> newOrderIds = getNewOrders(conn);
			Map<Integer, Integer> orderedItems = getOrderedLineItems(newOrderIds, conn);
			udpateInventory(orderedItems, conn);
			udpateOrderStatus(newOrderIds, conn);
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static Connection createConnection() throws SQLException, ClassNotFoundException {
		Class.forName("org.h2.Driver");
		Connection conn = DriverManager.getConnection("jdbc:h2:~/Mylaptop;AUTO_SERVER=TRUE", "sa", "");
		return conn;
	}

	private static Collection<Integer> getNewOrders(Connection conn) throws SQLException {
		Collection<Integer> orderIds = new ArrayList<Integer>();
		ResultSet rset = conn.createStatement().executeQuery("select ID from CUSTOMER_ORDER where STATUS = 'New'");
		while (rset.next()) {
			orderIds.add(new Integer(rset.getInt("ID")));
		}
		return orderIds;
	}

	private static Map<Integer, Integer> getOrderedLineItems(Collection<Integer> newOrderIds, Connection conn)
			throws SQLException {
		// This method returns a map of two integers. The first Integer is item ID, and
		// the second is cumulative requested quantity across all new orders
		Map<Integer, Integer> map = new HashMap<>();
		StringBuilder sb=new StringBuilder();
		Object[] array = newOrderIds.toArray();
		for(int i=0;i<array.length-1;i++) {
			sb.append(array[i]);
			sb.append(",");
		}
		if(array.length>0) sb.append(array[array.length-1]);
		
		PreparedStatement call = conn.prepareStatement("select * from CUSTOMER_ORDER_LINE_ITEM where CUSTOMER_ORDER_ID_FK IN ("+sb.toString()+")");
		ResultSet res = call.executeQuery();
	
		while(res.next()) {
			if(res.getInt("QUANTITY")>0){
				if(!map.containsKey(res.getInt("ITEM_NUMBER"))) {
					map.put(res.getInt("ITEM_NUMBER"), res.getInt("QUANTITY"));
				}else {
					map.put(res.getInt("ITEM_NUMBER"), map.get(res.getInt("ITEM_NUMBER")) + res.getInt("QUANTITY"));
				}
			}
		}
		return map;
	}

	private static void udpateInventory(Map<Integer, Integer> orderedItems, Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		for(Map.Entry<Integer, Integer> item: orderedItems.entrySet()) {
			ResultSet rset = conn.createStatement().executeQuery(
                    "select AVAILABLE_QUANTITY from ITEM where ID = " + item.getKey());
			rset.next();
			int curQuantity = rset.getInt("AVAILABLE_QUANTITY");
			conn.createStatement().executeUpdate(
                    "update ITEM set AVAILABLE_QUANTITY = " + (curQuantity - item.getValue()) + "where ID = " + item.getKey() );
		}
		
	}

	private static void udpateOrderStatus(Collection<Integer> newOrderIds, Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		StringBuilder sb=new StringBuilder();
		Object[] array = newOrderIds.toArray();
		for(int i=0;i<array.length-1;i++) {
			sb.append(array[i]);
			sb.append(",");
		}
		if(array.length>0) sb.append(array[array.length-1]);
		

		PreparedStatement call = conn.prepareStatement("update CUSTOMER_ORDER set STATUS = \'PROCESSED\' where ID in (" + sb.toString() + ")");
		call.executeUpdate();
	}

}
