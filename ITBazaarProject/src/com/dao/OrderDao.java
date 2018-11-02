package com.dao;

import java.util.List;

import com.model.Order;

/**
 * interface for order with all the function declaration
 * @author Administrator
 *
 */
public interface OrderDao {

	/**
	 * declaration of table name and table headers for using it in DAO
	 */
	String TABLEOrders="orders",COLOrderID="orderID",COLProductName="productName",
			COLOrderedQuantity="orderedQuantity",COLOrderedProductSrNo="orderedProductSrNo",
			COLOrderStatus="orderStatus",COLCid="cid",COLOrderDate="orderDate",COLActualPrice="actualPrice",COLDiscountedPrice="discountedPrice";

	public void updateOrderDetails(Order order);
	public void deleteOrderDetails(Order order);
	public void addOrderDetails(Order order);
	public List<Order> getAllOrderDetailsForParticularCustomer(int cid);
	public Order getOrderDetails(int OrderID);
	public List<Order> getAllOrderDetails();
	
}
