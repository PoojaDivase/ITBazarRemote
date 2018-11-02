package com.model;

import java.sql.Date;

public class Order {

	int orderID,orderedQuantity,orderedProductSrNo;
	Customer customer;
	String productName,orderStatus;
	Date orderDate;
	int actualprice,discountedprice;
	public Order() {
		super();
	}
	
	
	public Order(int orderedQuantity, int orderedProductSrNo, Customer customer, String productName, String orderStatus,
			Date orderDate, int actualprice, int discountedprice) {
		super();
		this.orderedQuantity = orderedQuantity;
		this.orderedProductSrNo = orderedProductSrNo;
		this.customer = customer;
		this.productName = productName;
		this.orderStatus = orderStatus;
		this.orderDate = orderDate;
		this.actualprice = actualprice;
		this.discountedprice = discountedprice;
	}


	
	public Order(int orderID, int orderedQuantity, int orderedProductSrNo, Customer customer, String productName,
			String orderStatus, Date orderDate, int actualprice, int discountedprice) {
		super();
		this.orderID = orderID;
		this.orderedQuantity = orderedQuantity;
		this.orderedProductSrNo = orderedProductSrNo;
		this.customer = customer;
		this.productName = productName;
		this.orderStatus = orderStatus;
		this.orderDate = orderDate;
		this.actualprice = actualprice;
		this.discountedprice = discountedprice;
	}


	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public int getOrderedQuantity() {
		return orderedQuantity;
	}
	public void setOrderedQuantity(int orderedQuantity) {
		this.orderedQuantity = orderedQuantity;
	}
	public int getOrderedProductSrNo() {
		return orderedProductSrNo;
	}
	public void setOrderedProductSrNo(int orderedProductSrNo) {
		this.orderedProductSrNo = orderedProductSrNo;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
	public int getActualprice() {
		return actualprice;
	}


	public void setActualprice(int actualprice) {
		this.actualprice = actualprice;
	}


	public int getDiscountedprice() {
		return discountedprice;
	}


	public void setDiscountedprice(int discountedprice) {
		this.discountedprice = discountedprice;
	}


	@Override
	public String toString() {
		return "Order [orderID=" + orderID + ", orderedQuantity=" + orderedQuantity + ", orderedProductSrNo="
				+ orderedProductSrNo + ", customer=" + customer + ", productName=" + productName + ", orderStatus="
				+ orderStatus + ", orderDate=" + orderDate + ", actualprice=" + actualprice + ", discountedprice="
				+ discountedprice + "]";
	}


	
	}
