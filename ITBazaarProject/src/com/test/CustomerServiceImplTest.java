package com.test;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.dao.CustomerDaoImpl;
import com.dao.CustomerExistsException;
import com.model.Customer;
import com.service.CustomerServiceImpl;

public class CustomerServiceImplTest {
      static CustomerServiceImpl customerServiceImpl;
      
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		customerServiceImpl = new CustomerServiceImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetAllCustomers() {
		//fail("Not yet implemented");
		List<Customer> allCustomers2 = customerServiceImpl.getAllCustomers();
		List<Customer> allCustomers = new CustomerDaoImpl().getAllCustomers();
		
		
		Assert.assertEquals(allCustomers.size(), allCustomers2.size());
	}

	
	@Test
	public void testAddCustomer2()
	{
		Customer customer=new Customer(4, "1234567890", null, "vadgaonsheri", "pooja@gmail.com", "pooja", "pooja");
		
		try {
			customerServiceImpl.addCustomer(customer);
		} catch (CustomerExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Customer> allCustomers2 = customerServiceImpl.getAllCustomers();
		List<Customer> allCustomers = new CustomerDaoImpl().getAllCustomers();
		
		
		Assert.assertEquals(allCustomers.size(), allCustomers2.size());

	}
	@Test
	public void testAddCustomer() {
		//fail("Not yet implemented");
		Customer customer=new Customer(4, "1234567890", "pooja", "vadgaonsheri", "pooja@gmail.com", "pooja", "pooja");
		
		try {
			customerServiceImpl.addCustomer(customer);
		} catch (CustomerExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Customer> allCustomers2 = customerServiceImpl.getAllCustomers();
		List<Customer> allCustomers = new CustomerDaoImpl().getAllCustomers();
		
		
		Assert.assertEquals(allCustomers.size(), allCustomers2.size());
	}

	

	@Test
	public void testDeleteCustomer() {
//		fail("Not yet implemented");
		Customer customer=new Customer(1, "1234567891", "pooja", "vadgaonsheri", "pooja@gmail.com", "pooja", "pooja");
		customerServiceImpl.deleteCustomer(customer);
		
		List<Customer> allCustomers2 = customerServiceImpl.getAllCustomers();
		List<Customer> allCustomers = new CustomerDaoImpl().getAllCustomers();
		
		
		Assert.assertEquals(allCustomers.size(), allCustomers2.size());
	}

}
