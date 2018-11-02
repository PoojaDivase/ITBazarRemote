package com.service;

import java.util.List;

import com.dao.CustomerDao;
import com.dao.CustomerDaoImpl;
import com.dao.CustomerExistsException;
import com.model.Customer;

public class CustomerServiceImpl implements CustomerService{

	/**
	 * object creation
	 */
	 CustomerDaoImpl  customerDao=new CustomerDaoImpl();
	 
	 /**
	  * function for getting all the customers
	  */
	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerDao.getAllCustomers();
	}

	/**
	 * function to get a particular customer
	 */
	@Override
	public Customer getCustomer(int cid) {
		// TODO Auto-generated method stub
		return customerDao.getCustomer(cid);
	}

	/**
	 * function to add a customer
	 */
	@Override
	public void addCustomer(Customer cust) throws CustomerExistsException {
		// TODO Auto-generated method stub
		
				customerDao.addCustomer(cust);
		
	}

	/**
	 * function to update customer details
	 */
	@Override
	public void updateCustomer(Customer cust) {
		// TODO Auto-generated method stub
		customerDao.updateCustomer(cust);
	}

	/**
	 * function to delete customer details
	 */
	@Override
	public void deleteCustomer(Customer cust) {
		// TODO Auto-generated method stub
		customerDao.deleteCustomer(cust);
	}

}
