package com.service;

import java.util.List;

import com.model.Order;

/**
 * interface for order 
 * @author Administrator
 *
 */
public interface OrderService {

	public void updateOrderDetails(Order order);
	public void deleteOrderDetails(Order order);
	public void addOrderDetails(Order order);
	public List<Order> getAllOrderDetailsForParticularCustomer(int cid);
	public Order getOrderDetails(int OrderID);
	public List<Order> getAllOrderDetails();
}
