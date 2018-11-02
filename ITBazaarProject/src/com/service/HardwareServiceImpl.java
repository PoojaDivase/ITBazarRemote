package com.service;

import java.util.ArrayList;
import java.util.List;

import com.dao.HardwareDao;
import com.dao.HardwareDaoImpl;
import com.dao.HardwareExistsException;
import com.model.Hardware;

public class HardwareServiceImpl implements HardwareService {

	/**
	 * creating list of hardware and object creation
	 */
	private static List<Hardware> allHardwareList = new ArrayList<Hardware>();
	HardwareDao hardwareDaoImpl = new HardwareDaoImpl();

	/**
	 * Function to get a particular hardware type
	 */
	public Hardware getHardware(int hid) {
		Hardware hardware = hardwareDaoImpl.getHardware(hid);
		return hardware;

	}

	/**
	 * Function to get the list of all hardware from the table
	 */
	public List<Hardware> getAllHardwares() {
		allHardwareList = new ArrayList<Hardware>();
		allHardwareList = hardwareDaoImpl.getAllHardwares();
		return allHardwareList;

	}

	/**
	 * Function to add a particular type 
	 */
	public void addHardware(Hardware hardware) throws HardwareExistsException {
		hardwareDaoImpl.addHardware(hardware);

	}

	/**
	 * Function to update details
	 */
	public void updateHardware(Hardware hardware) {
		hardwareDaoImpl.updateHardware(hardware);

	}

	/**
	 * Function to delete details
	 */
	public void deleteHardware(Hardware hardware) {
		hardwareDaoImpl.deleteHardware(hardware);
	}


}
