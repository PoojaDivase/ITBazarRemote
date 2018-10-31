package com.service;

import java.util.List;

import com.dao.OrderDaoImpl;
import com.model.Order;

public class OrderServiceImpl implements OrderService{
	
	OrderDaoImpl orderdao=new OrderDaoImpl();

	@Override
	public void updateOrderDetails(Order order) {
		
		orderdao.updateOrderDetails(order);
	}

	@Override
	public void deleteOrderDetails(Order order) {
		orderdao.deleteOrderDetails(order);
		
	}

	@Override
	public void addOrderDetails(Order order) {
		// TODO Auto-generated method stub
		orderdao.addOrderDetails(order);
	}

	@Override
	public List<Order> getAllOrderDetailsForParticularCustomer(int cid) {
		// TODO Auto-generated method stub
		return orderdao.getAllOrderDetailsForParticularCustomer(cid);
	}

	@Override
	public Order getOrderDetails(int OrderID) {
		// TODO Auto-generated method stub
		return orderdao.getOrderDetails(OrderID);
	}

	@Override
	public List<Order> getAllOrderDetails() {
		// TODO Auto-generated method stub
		return orderdao.getAllOrderDetails();
	}
	

}
