package com.service;

import java.util.List;

import com.dao.OrderDaoImpl;
import com.model.Order;

public class OrderServiceImpl implements OrderService{
	
	OrderDaoImpl orderdao=new OrderDaoImpl();

	/**
	 * Function to update order details
	 */
	@Override
	public void updateOrderDetails(Order order) {
		
		orderdao.updateOrderDetails(order);
	}

	/**
	 * Function to delete order
	 */
	@Override
	public void deleteOrderDetails(Order order) {
		orderdao.deleteOrderDetails(order);
		
	}

	/**
	 * Function to add order
	 */
	@Override
	public void addOrderDetails(Order order) {
		// TODO Auto-generated method stub
		orderdao.addOrderDetails(order);
	}

	/**
	 * Function to get all order details for particular customer
	 */
	@Override
	public List<Order> getAllOrderDetailsForParticularCustomer(int cid) {
		// TODO Auto-generated method stub
		return orderdao.getAllOrderDetailsForParticularCustomer(cid);
	}

	/**
	 * Function to get details of a particular order
	 */
	@Override
	public Order getOrderDetails(int OrderID) {
		// TODO Auto-generated method stub
		return orderdao.getOrderDetails(OrderID);
	}

	/**
	 * Function to get all orders
	 */
	@Override
	public List<Order> getAllOrderDetails() {
		// TODO Auto-generated method stub
		return orderdao.getAllOrderDetails();
	}
	

}
