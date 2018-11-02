package com.dao;

import java.util.List;

import com.model.Customer;
/**
 * 
 * @author Administrator
 *CustomerDao Interface is created here
 */
public interface CustomerDao {
	/**
	 * variable are declared using String format
	 * 
	 */
	String TABLECustomer="customer",COLCid="cid",COLCName="cname",
			COLAddress="caddress",COLMobileNo="mobileNo",COLEmail="email",COLUserId="userID",COLPassword="password";
/**
 * these are the functions declared
 * @return
 */
	List<Customer> getAllCustomers();
	public Customer getCustomer(int cid);
	void addCustomer(Customer cust)throws CustomerExistsException;
	void updateCustomer(Customer cust);
	void deleteCustomer(Customer cust);
}
