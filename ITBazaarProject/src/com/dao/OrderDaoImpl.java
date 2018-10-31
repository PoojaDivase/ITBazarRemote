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

	List<Order> allOrderList=new ArrayList<Order>();
	String sqlQuery;
	PreparedStatement pst;
	ResultSet rs;
	Connection connection=DBConnection.getConnection();
	Order order;
	
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
			sqlQuery="select * from "+TABLEOrders+" where "+COLOrderID+"="+"?";
			
			pst=connection.prepareStatement(sqlQuery);
			pst.setInt(1, OrderID);
			pst.executeQuery();
			rs=pst.getResultSet();
			
			if(rs.next()==false)
			{
				return null;
			}
			
			 int cid=rs.getInt(COLCid);
			OrderID=rs.getInt(COLOrderID);
			String ProductName=rs.getString(COLProductName);
			int OrderedQuantity=rs.getInt(COLOrderedQuantity);
			int OrderedProductSrNo=rs.getInt(COLOrderedProductSrNo);
			String OrderStatus=rs.getString(COLOrderStatus);
			Date date=rs.getDate(COLOrderDate);
			
			order=new Order(OrderID, OrderedQuantity, OrderedProductSrNo, new CustomerDaoImpl().getCustomer(cid), ProductName, OrderStatus, date);
			
			allOrderList.add(order);
			return order;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;


	}
	public List<Order> getAllOrderDetails() {
		try {
			sqlQuery="select * from "+TABLEOrders;
			
			pst=connection.prepareStatement(sqlQuery);
			pst.executeQuery();
			rs=pst.getResultSet();
			
			while(rs.next())
			{
				 int cid=rs.getInt(COLCid);
				 int OrderID=rs.getInt(COLOrderID);
					String ProductName=rs.getString(COLProductName);
					int OrderedQuantity=rs.getInt(COLOrderedQuantity);
					int OrderedProductSrNo=rs.getInt(COLOrderedProductSrNo);
					String OrderStatus=rs.getString(COLOrderStatus);
					Date date=rs.getDate(COLOrderDate);
					
					order=new Order(OrderID, OrderedQuantity, OrderedProductSrNo, new CustomerDaoImpl().getCustomer(cid), ProductName, OrderStatus, date);
					
					allOrderList.add(order);
				}
			return  allOrderList;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	public List<Order> getAllOrderDetailsForParticularCustomer(int cid)
	{
		sqlQuery="select * from "+TABLEOrders+" where "+COLCid+"="+"?";
		try {
			pst = connection.prepareStatement(sqlQuery);
			pst.setInt(1, cid);
			pst.executeQuery();
			ResultSet rs=pst.getResultSet();

			while(rs.next())
			{
				 	int OrderID=rs.getInt(COLOrderID);
					String ProductName=rs.getString(COLProductName);
					int OrderedQuantity=rs.getInt(COLOrderedQuantity);
					int OrderedProductSrNo=rs.getInt(COLOrderedProductSrNo);
					String OrderStatus=rs.getString(COLOrderStatus);
					Date date=rs.getDate(COLOrderDate);
					
					order=new Order(OrderID, OrderedQuantity, OrderedProductSrNo, new CustomerDaoImpl().getCustomer(cid), ProductName, OrderStatus, date);
					
					allOrderList.add(order);
					return allOrderList;
					
			}
			
			return  allOrderList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	public void addOrderDetails(Order order) {
		try {
			sqlQuery="insert into "+TABLEOrders+"("+COLProductName+","+COLOrderedQuantity+","+COLOrderedProductSrNo+","+COLOrderStatus+","+COLCid+","+COLOrderDate+")"+" values(?,?,?,?,?,?)";
			pst = connection.prepareStatement(sqlQuery);
			//pst.setInt(1,order.getOrderID());
			pst.setString(1,order.getProductName());
			pst.setInt(2,order.getOrderedQuantity());
			pst.setInt(3,order.getOrderedProductSrNo());
			pst.setString(4, order.getOrderStatus());
			pst.setInt(5, order.getCustomer().getCid());
			pst.setDate(6, order.getOrderDate());
			pst.executeUpdate();
			allOrderList.add(order);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteOrderDetails(Order order) {
		try {
			Connection connection=DBConnection.getConnection();
			String sqlQuery="delete from "+TABLEOrders+" where "+COLOrderID+"=?"+" and "+COLCid+"=?";
			pst = connection.prepareStatement(sqlQuery);
			
			pst.setInt(2,order.getCustomer().getCid());
			pst.setInt(2,order.getOrderID());
			int executeUpdate = pst.executeUpdate();
			
			allOrderList.remove(order);
			
//			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void updateOrderDetails(Order order)
	{
		try {
			sqlQuery="update "+TABLEOrders+" set "+COLOrderedQuantity+"=? ,"+COLOrderDate+"=?"+" where "+COLOrderID+"=?";
			pst = connection.prepareStatement(sqlQuery);
			
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
