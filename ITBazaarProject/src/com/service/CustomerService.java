package com.service;

import java.util.List;

import com.dao.CustomerExistsException;
import com.model.Customer;

public interface CustomerService {

	List<Customer> getAllCustomers();
	public Customer getCustomer(int cid);
	void addCustomer(Customer cust) throws CustomerExistsException;
	void updateCustomer(Customer cust);
	void deleteCustomer(Customer cust);

}
