package com.dao;

import java.util.List;

import com.model.Customer;

public interface CustomerDao {
	String TABLECustomer="customer",COLCid="cid",COLCName="cname",
			COLAddress="caddress",COLMobileNo="mobileNo",COLEmail="email",COLUserId="userID",COLPassword="password";

	List<Customer> getAllCustomers();
	public Customer getCustomer(int cid);
	void addCustomer(Customer cust)throws CustomerExistsException;
	void updateCustomer(Customer cust);
	void deleteCustomer(Customer cust);
}
