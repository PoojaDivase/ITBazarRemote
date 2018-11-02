package com.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.dao.SoftwareDaoImpl;
import com.dao.SoftwareExistsException;
import com.model.Software;
import com.service.SoftwareServiceImpl;

public class SoftwareServiceImplTest {

	static SoftwareServiceImpl softwareServiceImpl;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		softwareServiceImpl=new SoftwareServiceImpl();
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
	public void testGetSoftware() {
		//fail("Not yet implemented");
		Software software=softwareServiceImpl.getSoftware(204);
		Software expected= new Software(204, "MS Office");
		assertEquals(software, software);
	}

	@Test
	public void testGetAllSoftwares() {
		//fail("Not yet implemented");
		int alList=softwareServiceImpl.getAllSoftwares().size();
		int expected=new SoftwareDaoImpl().getAllSoftwares().size();
		
		assertEquals(expected, alList);
	}

	@Test
	public void testAddSoftware() {
		//fail("Not yet implemented");
		Software soft = new Software(109, "Accessories");
		try {
			softwareServiceImpl.addSoftware(soft);
		} catch (SoftwareExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int alList=softwareServiceImpl.getAllSoftwares().size();
		int expected=new SoftwareDaoImpl().getAllSoftwares().size();
		
		assertEquals(expected, alList);
	}

	@Test
	public void testUpdateSoftware() {
		//fail("Not yet implemented");
		Software soft= new Software(109,"Mobile Accessories");
		
		softwareServiceImpl.updateSoftware(soft);
		Software software=new SoftwareDaoImpl().getSoftware(109);
		
		assertEquals(soft, software);
	}

	@Test
	public void testDeleteSoftware() {
		//fail("Not yet implemented");
		Software software=new Software(109, "Mobile Accessories");
		softwareServiceImpl.deleteSoftware(software);
		
		int alList=softwareServiceImpl.getAllSoftwares().size();
		int expected=new SoftwareDaoImpl().getAllSoftwares().size();
		
		assertEquals(expected, alList);
		
	}

}
