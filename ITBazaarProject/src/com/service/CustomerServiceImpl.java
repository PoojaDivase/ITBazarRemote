package com.service;

import java.util.List;

import com.dao.CustomerDao;
import com.dao.CustomerDaoImpl;
import com.dao.CustomerExistsException;
import com.model.Customer;

public class CustomerServiceImpl implements CustomerService{

	 CustomerDaoImpl  customerDao=new CustomerDaoImpl();
	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerDao.getAllCustomers();
	}

	@Override
	public Customer getCustomer(int cid) {
		// TODO Auto-generated method stub
		return customerDao.getCustomer(cid);
	}

	@Override
	public void addCustomer(Customer cust) throws CustomerExistsException {
		// TODO Auto-generated method stub
		
				customerDao.addCustomer(cust);
		
	}

	@Override
	public void updateCustomer(Customer cust) {
		// TODO Auto-generated method stub
		customerDao.updateCustomer(cust);
	}

	@Override
	public void deleteCustomer(Customer cust) {
		// TODO Auto-generated method stub
		customerDao.deleteCustomer(cust);
	}

}
