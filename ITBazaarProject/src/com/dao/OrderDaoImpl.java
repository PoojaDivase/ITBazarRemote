package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.main.DBConnection;
import com.model.Customer;
import com.model.Order;

public class OrderDaoImpl implements OrderDao{
/**
 * list is created for all orders
 */
	List<Order> allOrderList=new ArrayList<Order>();
	/**
	 * object of customer, preparedStatement, resultSet is created
	 * String variable declaration for sqlQuery is created
	 */

	String sqlQuery;
	PreparedStatement pst;
	ResultSet rs;
	Connection connection=DBConnection.getConnection();
	Order order;
	
	/**
	 * function to get the details of a particular order
	 */
	public Order getOrderDetails(int OrderID)
	{
		
		try {
		
			Order item=new Order();
			item.setOrderID(OrderID);
			
			if(allOrderList.contains(item))
			{
				
			int index=allOrderList.indexOf(item);
			return allOrderList.get(index);
			}
			/**
			 * Query to get a particular order
			 */
			sqlQuery="select * from "+TABLEOrders+" where "+COLOrderID+"="+"?";
			
			pst=connection.prepareStatement(sqlQuery);
			pst.setInt(1, OrderID);
			pst.executeQuery();
			rs=pst.getResultSet();
			
			if(rs.next()==false)
			{
				return null;
			}
			/**
			 * getting the data
			 */
			 int cid=rs.getInt(COLCid);
			OrderID=rs.getInt(COLOrderID);
			String ProductName=rs.getString(COLProductName);
			int OrderedQuantity=rs.getInt(COLOrderedQuantity);
			int OrderedProductSrNo=rs.getInt(COLOrderedProductSrNo);
			String OrderStatus=rs.getString(COLOrderStatus);
			Date date=rs.getDate(COLOrderDate);
			int actualprice=rs.getInt(COLActualPrice);
			int discountedprice=rs.getInt(COLDiscountedPrice);
			
			order=new Order(OrderID, OrderedQuantity, OrderedProductSrNo, new CustomerDaoImpl().getCustomer(cid), ProductName, OrderStatus, date,actualprice,discountedprice);
			/**
			 * adding it to the list
			 */
			allOrderList.add(order);
			return order;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;


	}
	/**
	 * function to get all orders
	 */
	public List<Order> getAllOrderDetails() {
		try {
			/**
			 * Query to get all the orders
			 */
			sqlQuery="select * from "+TABLEOrders;
			
			pst=connection.prepareStatement(sqlQuery);
			pst.executeQuery();
			rs=pst.getResultSet();
			
			while(rs.next())
			{
				/**
				 * getting the data from result set
				 */
				 int cid=rs.getInt(COLCid);
				 int OrderID=rs.getInt(COLOrderID);
					String ProductName=rs.getString(COLProductName);
					int OrderedQuantity=rs.getInt(COLOrderedQuantity);
					int OrderedProductSrNo=rs.getInt(COLOrderedProductSrNo);
					String OrderStatus=rs.getString(COLOrderStatus);
					Date date=rs.getDate(COLOrderDate);
					int actualprice=rs.getInt(COLActualPrice);
					int discountedprice=rs.getInt(COLDiscountedPrice);
					
					order=new Order(OrderID, OrderedQuantity, OrderedProductSrNo, new CustomerDaoImpl().getCustomer(cid), ProductName, OrderStatus, date,actualprice,discountedprice);
					/**
					 * adding it to the list
					 */
					allOrderList.add(order);
				}
			/**
			 * returning list
			 */
			return  allOrderList;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * Function to get all orders for a particular customer
	 */
	public List<Order> getAllOrderDetailsForParticularCustomer(int cid)
	{
		/**
		 * Query to get all orders for a particular customer
		 */
		sqlQuery="select * from "+TABLEOrders+" where "+COLCid+"="+"?";
		try {
			pst = connection.prepareStatement(sqlQuery);
			pst.setInt(1, cid);
			pst.executeQuery();
			ResultSet rs=pst.getResultSet();

			while(rs.next())
			{
				/**
				 * getting the data from result set
				 */
				 	int OrderID=rs.getInt(COLOrderID);
					String ProductName=rs.getString(COLProductName);
					int OrderedQuantity=rs.getInt(COLOrderedQuantity);
					int OrderedProductSrNo=rs.getInt(COLOrderedProductSrNo);
					String OrderStatus=rs.getString(COLOrderStatus);
					Date date=rs.getDate(COLOrderDate);
					int actualprice=rs.getInt(COLActualPrice);
					int discountedprice=rs.getInt(COLDiscountedPrice);
					
					order=new Order(OrderID, OrderedQuantity, OrderedProductSrNo, new CustomerDaoImpl().getCustomer(cid), ProductName, OrderStatus, date,actualprice,discountedprice);
					
					/**
					 * adding it to the list
					 */
					allOrderList.add(order);
					
					
			}
			/**
			 * returning list
			 */
			return  allOrderList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	/**
	 * Function to add the order
	 */
	public void addOrderDetails(Order order) {
		try {
			/**
			 * Query to add an order
			 */
			sqlQuery="insert into "+TABLEOrders+"("+COLProductName+","+COLOrderedQuantity+","+COLOrderedProductSrNo+","+COLOrderStatus+","+COLCid+","+COLOrderDate+","+COLActualPrice+","+COLDiscountedPrice+")"+" values(?,?,?,?,?,?,?,?)";
			pst = connection.prepareStatement(sqlQuery);
			//pst.setInt(1,order.getOrderID());
			pst.setString(1,order.getProductName());
			pst.setInt(2,order.getOrderedQuantity());
			pst.setInt(3,order.getOrderedProductSrNo());
			pst.setString(4, order.getOrderStatus());
			pst.setInt(5, order.getCustomer().getCid());
			pst.setDate(6, order.getOrderDate());
			pst.setInt(7, order.getActualprice());
			pst.setInt(8, order.getDiscountedprice());
			pst.executeUpdate();
			/**
			 * adding in list
			 */
			allOrderList.add(order);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Function to delete order
	 */
	public void deleteOrderDetails(Order order) {
		try {
			/**
			 * Query to delete a order
			 */
			 sqlQuery="delete from "+TABLEOrders+" where "+COLOrderID+"=?"+" and "+COLCid+"=?";
			pst = connection.prepareStatement(sqlQuery);
			pst.setInt(1,order.getOrderID());
			pst.setInt(2,order.getCustomer().getCid());
			
			pst.executeUpdate();
			
			/**
			 * removing it from the list
			 */
			allOrderList.remove(order);
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * Function to update order with parameters as quantity, date
	 */
	public void updateOrderDetails(Order order)
	{
		try {
			/**
			 * Query to update order with parameters as quantity, date
			 */
			sqlQuery="update "+TABLEOrders+" set "+COLOrderedQuantity+"=? ,"+COLOrderDate+"=?"+" where "+COLOrderID+"=?";
			pst = connection.prepareStatement(sqlQuery);
			
			/**
			 * setting the data
			 */
			pst.setInt(1,order.getOrderedQuantity());
			pst.setDate(2,order.getOrderDate());
			pst.setInt(3,order.getOrderID());
			pst.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
}
