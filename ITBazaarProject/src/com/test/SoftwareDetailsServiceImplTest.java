package com.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.dao.HardwareDetailsDaoImpl;
import com.dao.SoftwareDetailsDaoImpl;
import com.model.Hardware;
import com.model.HardwareDetails;
import com.model.Software;
import com.model.SoftwareDetails;
import com.service.SoftwareDetailsServiceImpl;

public class SoftwareDetailsServiceImplTest extends SoftwareDetailsServiceImpl {

	static SoftwareDetailsServiceImpl softwareDetailsServiceImpl;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		softwareDetailsServiceImpl=new SoftwareDetailsServiceImpl();
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
	public void testGetAllSoftwaresDetails() {
		//fail("Not yet implemented");
		List<SoftwareDetails> allCustomers2 = softwareDetailsServiceImpl.getAllSoftware();
		List<SoftwareDetails> allCustomers = new SoftwareDetailsDaoImpl().getAllSoftware();
		
		Assert.assertEquals(allCustomers.size(), allCustomers2.size());
	}

	@Test
	public void testAddSoftwareDetails() {
		//fail("Not yet implemented");
		Software hardware2= new Software(201, "Antivirus");
		SoftwareDetails hd= new SoftwareDetails(2221, 1000, 10, 10, hardware2, "QuickHeal Antivirus", "QuickHeal");
		
		softwareDetailsServiceImpl.addSoftwareDetails(hd);
		List<SoftwareDetails> allCustomers2 = softwareDetailsServiceImpl.getAllSoftware();
		List<SoftwareDetails> allCustomers = new SoftwareDetailsDaoImpl().getAllSoftware();
		
		Assert.assertEquals(allCustomers.size(), allCustomers2.size());
	}

	@Test
	public void testUpdateSoftware() {
		//fail("Not yet implemented");
		Software hardware2= new Software(201, "Antivirus");
		SoftwareDetails hd= new SoftwareDetails(2211, 1500, 10, 10, hardware2, "QuickHeal Antivirus", "QuickHeal");
		
		softwareDetailsServiceImpl.addSoftwareDetails(hd);
		List<SoftwareDetails> allCustomers2 = softwareDetailsServiceImpl.getAllSoftware();
		List<SoftwareDetails> allCustomers = new SoftwareDetailsDaoImpl().getAllSoftware();
		
		Assert.assertEquals(allCustomers.size(), allCustomers2.size());
	}

	@Test
	public void testDeleteSoftware() {
		//fail("Not yet implemented");
		Software hardware2= new Software(201, "Antivirus");
		SoftwareDetails hd= new SoftwareDetails(2221, 1000, 10, 10, hardware2, "QuickHeal Antivirus", "QuickHeal");
		
		softwareDetailsServiceImpl.deleteSoftwareDetails(hd);
		List<SoftwareDetails> allCustomers2 = softwareDetailsServiceImpl.getAllSoftware();
		List<SoftwareDetails> allCustomers = new SoftwareDetailsDaoImpl().getAllSoftware();
		
		Assert.assertEquals(allCustomers.size(), allCustomers2.size());
	}

}
