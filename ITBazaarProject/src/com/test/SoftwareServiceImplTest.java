package com.test;

import static org.junit.Assert.*;

import javax.swing.plaf.ActionMapUIResource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.model.Software;
import com.service.SoftwareService;
import com.service.SoftwareServiceImpl;

public class SoftwareServiceImplTest {

	static SoftwareServiceImpl softwareService;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		softwareService=new SoftwareServiceImpl();
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
		Software soft=softwareService.getSoftware(201);
		Software expected  =new Software(201, "Antivirus");
		assertEquals(expected, soft);
	}

	@Test
	public void testGetAllSoftwares() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddSoftware() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateSoftware() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteSoftware() {
		fail("Not yet implemented");
	}

}
