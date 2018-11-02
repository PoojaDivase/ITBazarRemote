package com.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.dao.CustomerDaoImpl;
import com.dao.HardwareDetailsDaoImpl;
import com.model.Customer;
import com.model.Hardware;
import com.model.HardwareDetails;
import com.service.HardwareDetailsServiceImpl;

public class HardwareDetailsServiceImplTest extends HardwareDetailsServiceImpl {

	static HardwareDetailsServiceImpl hardwareDetailsServiceImpl;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		hardwareDetailsServiceImpl=new HardwareDetailsServiceImplTest();
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
	public void testGetHardwareDetails() {
		//fail("Not yet implemented");
		HardwareDetails hard=hardwareDetailsServiceImpl.getHardwareDetails(1111);
		Hardware hardware2= new Hardware(101, "Laptop");
		HardwareDetails hd= new HardwareDetails(1111, 35000, 10, 10, hardware2, "Dell Inspiron", "Dell", "Black");
		
		Assert.assertEquals(hd, hd);
	}

	@Test
	public void testGetListOfParticularHardwareType() {
		//fail("Not yet implemented");
		List<HardwareDetails> allCustomers2 = hardwareDetailsServiceImpl.getListOfParticularHardwareType(101);
		List<HardwareDetails> allCustomers = new HardwareDetailsDaoImpl().getAllHardwareDetailsForParticularType(101);
		
		
		Assert.assertEquals(allCustomers.size(), allCustomers2.size());
	}

	@Test
	public void testAddHardwareDetails() {

		//fail("Not yet implemented");
		Hardware hardware2= new Hardware(101, "Laptop");
		HardwareDetails hd= new HardwareDetails(1121, 35000, 10, 10, hardware2, "Dell Inspiron", "Dell", "Black");
		
		hardwareDetailsServiceImpl.addHardwareDetails(hd);
		
		List<HardwareDetails> allCustomers2 = hardwareDetailsServiceImpl.getAllHardwareDetails();
		List<HardwareDetails> allCustomers = new HardwareDetailsDaoImpl().getAllHardwareDetails();
		
		
		Assert.assertEquals(allCustomers.size(), allCustomers2.size());
		
		
	}



	@Test
	public void testDeleteHardwareDetails() {
		//fail("Not yet implemented");
		Hardware hardware2= new Hardware(101, "Laptop");
		HardwareDetails hd= new HardwareDetails(1121, 35000, 10, 10, hardware2, "Dell Inspiron", "Dell", "Black");
		
		hardwareDetailsServiceImpl.deleteHardwareDetails(hd);
		
		List<HardwareDetails> allCustomers2 = hardwareDetailsServiceImpl.getAllHardwareDetails();
		List<HardwareDetails> allCustomers = new HardwareDetailsDaoImpl().getAllHardwareDetails();
		
		
		Assert.assertEquals(allCustomers.size(), allCustomers2.size());
		
	}

	@Test
	public void testGetHardwareDetailsWithList() {
		//fail("Not yet implemented");
		List<HardwareDetails> allCustomers2 = hardwareDetailsServiceImpl.getListOfParticularHardwareType(101);
		List<HardwareDetails> allCustomers = new HardwareDetailsDaoImpl().getAllHardwareDetailsForParticularType(101);
		
		
		Assert.assertEquals(allCustomers.size(), allCustomers2.size());
	}

	@Test
	public void testGetAllHardwareDetails() {
		//fail("Not yet implemented");
		List<HardwareDetails> allCustomers2 = hardwareDetailsServiceImpl.getAllHardwareDetails();
		List<HardwareDetails> allCustomers = new HardwareDetailsDaoImpl().getAllHardwareDetails();
		
		
		Assert.assertEquals(allCustomers.size(), allCustomers2.size());
	}

	

}
