package com.model;

import java.sql.Date;

/**
 * this class is used to use the order details from the orders table
 * @author Administrator
 *
 */
public class Order {

	/**
	 * variable initialization
	 */
	int orderID,orderedQuantity,orderedProductSrNo;
	Customer customer;
	String productName,orderStatus;
	Date orderDate;
	int actualprice,discountedprice;
	
	/**
	 * simple constructor of super() type
	 */
	public Order() {
		super();
	}
	
	/**
	 * Parameterized Constructor
	 * @param orderedQuantity is the quantity of the product that the customer had ordered 
	 * @param orderedProductSrNo is the primary key serial no. of the ordered product
	 * @param customer is the object which will give the details of that customer who has ordered the product from the customer
	 * @param productName is the name of the product ordered
	 * @param orderStatus is the status of the ordered ie. complete or incomplete
	 * @param orderDate is the date of the order submitted
	 * @param actualprice is the actual price of the product 
	 * @param discountedprice is the discounted price of the product
	 */
	
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

/**
 * Parameterized Constructor
 * @param orderID
 * @param orderedQuantity is the quantity of the product that the customer had ordered
 * @param orderedProductSrNo is the primary key serial no. of the ordered product
 * @param customer is the object which will give the details of that customer who has ordered the product from the customer
 * @param productName is the name of the product ordered
 * @param orderStatus is the status of the ordered ie. complete or incomplete
 * @param orderDate is the date of the order submitted
 * @param actualprice is the actual price of the product
 * @param discountedprice is the discounted price of the product
 */
	
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

	/**
	 * getters and setters
	 * this function is used to get the order id of the placed order
	 * @return the order id of the placed order
	 */
	public int getOrderID() {
		return orderID;
	}
	/**
	 * this function is used to set the order id for further usage
	 * @param orderID gives the order id and sets it
	 * @see Order#getOrderID()
	 */
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	
	/**
	 * this function is used to get the ordered quantity
	 * @return the ordered quantity
	 */
	public int getOrderedQuantity() {
		return orderedQuantity;
	}
	
	/**
	 * this function is used to set the quantity of the placed order
	 * @param orderedQuantity gives the quantity of the order placed
	 * @see Order#getOrderedQuantity()
	 */
	public void setOrderedQuantity(int orderedQuantity) {
		this.orderedQuantity = orderedQuantity;
	}
	/**
	 * this function gets the serial no. of that placed order
	 * @return the serial no. of that placed order
	 */
	public int getOrderedProductSrNo() {
		return orderedProductSrNo;
	}
	/**
	 * this function is used to set the serial no. of that ordered product
	 * @param orderedProductSrNo gives the serial no. of that ordered product
	 * @see Order#getOrderedProductSrNo()
	 */
	public void setOrderedProductSrNo(int orderedProductSrNo) {
		this.orderedProductSrNo = orderedProductSrNo;
	}
	/**
	 * this function is used to get the customer details from the customer table
	 * @return gives the customer details as object
	 */
	public Customer getCustomer() {
		return customer;
	}
	/**
	 * this function is used to set the customer details from the customer table
	 * @param customer is the object of the customer which is used for ordering the product
	 * @see Order#getCustomer()
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	/**
	 * this function is used to get the name of the product ordered
	 * @return the name of the product ordered
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * this function is used to set the name of the product ordered
	 * @param productName is the name of the ordered product
	 * @see Order#getProductName()
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * this function is used to get the status of the order placed
	 * @return the status of the placed order
	 */
	public String getOrderStatus() {
		return orderStatus;
	}
	/**
	 * this function is used to set the status of the order placed 
	 * @param orderStatus is used to show status of the placed order
	 * @see Order#getOrderStatus()
	 */
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	/**
	 * this function is used to get the date of the order placed
	 * @return the date of the order placed
	 */
	public Date getOrderDate() {
		return orderDate;
	}
	/**
	 * this function is used to set the date of the placed order
	 * @param orderDate gives the date of the placed order
	 * @see Order#getOrderDate()
	 */
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
	/**
	 * this function is used to get the actual price of the product ordered
	 * @return gives the actual price of the product
	 */
	public int getActualprice() {
		return actualprice;
	}

/**
 * this function is used to set the actual price of the product ordered
 * @param actualprice is used to set the actual price of the product order
 * @see Order#getActualprice()
 */
	public void setActualprice(int actualprice) {
		this.actualprice = actualprice;
	}


	/**
	 * this function is used to get the discounted price of the particular product
	 * @return the discounted price of the particular product
	 */
	public int getDiscountedprice() {
		return discountedprice;
	}

	/**
	 * this function is used to set the discounted price of the product ordered
	 * @param actualprice is used to set the discounted price of the product order
	 * @see Order#getDiscountedprice()
	 */
	public void setDiscountedprice(int discountedprice) {
		this.discountedprice = discountedprice;
	}
	/**
	 * toString function
	 */

	@Override
	public String toString() {
		return "Order [orderID=" + orderID + ", orderedQuantity=" + orderedQuantity + ", orderedProductSrNo="
				+ orderedProductSrNo + ", customer=" + customer + ", productName=" + productName + ", orderStatus="
				+ orderStatus + ", orderDate=" + orderDate + ", actualprice=" + actualprice + ", discountedprice="
				+ discountedprice + "]";
	}


	
	}
