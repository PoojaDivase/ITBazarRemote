package com.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.dao.HardwareDaoImpl;
import com.dao.HardwareExistsException;

import com.model.Hardware;
import com.service.HardwareServiceImpl;

public class HardwareServiceImplTest {

	static HardwareServiceImpl hardwareServiceImpl;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		hardwareServiceImpl=new HardwareServiceImpl();
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
	public void testGetHardware() {
		//fail("Not yet implemented");
		Hardware hard=hardwareServiceImpl.getHardware(101);
		Hardware hardware=new Hardware(101,"Laptop");
		assertEquals(hard, hardware);
	}

	@Test
	public void testGetAllHardwares() {
		//fail("Not yet implemented");
		int alList=hardwareServiceImpl.getAllHardwares().size();
		int expected=new HardwareDaoImpl().getAllHardwares().size();
		
		assertEquals(expected, alList);
	}

	@Test
	public void testAddHardware() {
		//fail("Not yet implemented");
		Hardware hard = new Hardware(109, "Accessories");
		try {
			hardwareServiceImpl.addHardware(hard);
		} catch (HardwareExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int alList=hardwareServiceImpl.getAllHardwares().size();
		int expected=new HardwareDaoImpl().getAllHardwares().size();
		
		assertEquals(expected, alList);
		
	}

	@Test
	public void testUpdateHardware() {
		//fail("Not yet implemented");
		Hardware hard= new Hardware(109,"Mobile Accessories");
		
		hardwareServiceImpl.updateHardware(hard);
		Hardware hardware=new HardwareDaoImpl().getHardware(109);
		
		assertEquals(hard, hardware);
	}

	@Test
	public void testDeleteHardware() {
		//fail("Not yet implemented");
		Hardware hardware=new Hardware(109, "Mobile Accessories");
		hardwareServiceImpl.deleteHardware(hardware);
		
		int alList=hardwareServiceImpl.getAllHardwares().size();
		int expected=new HardwareDaoImpl().getAllHardwares().size();
		
		assertEquals(expected, alList);
	
	}

}
