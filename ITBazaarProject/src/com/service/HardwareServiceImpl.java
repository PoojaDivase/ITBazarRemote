package com.service;

import java.util.ArrayList;
import java.util.List;

import com.dao.HardwareDao;
import com.dao.HardwareDaoImpl;
import com.dao.HardwareExistsException;
import com.model.Hardware;

public class HardwareServiceImpl implements HardwareService {

	private static List<Hardware> allHardwareList = new ArrayList<Hardware>();
	HardwareDao hardwareDaoImpl = new HardwareDaoImpl();

	public Hardware getHardware(int hid) {
		Hardware hardware = hardwareDaoImpl.getHardware(hid);
		return hardware;

	}

	public List<Hardware> getAllHardwares() {
		allHardwareList = new ArrayList<Hardware>();
		allHardwareList = hardwareDaoImpl.getAllHardwares();
		return allHardwareList;

	}

	public void addHardware(Hardware hardware) throws HardwareExistsException {
		hardwareDaoImpl.addHardware(hardware);

	}

	public void updateHardware(Hardware hardware) {
		hardwareDaoImpl.updateHardware(hardware);

	}

	public void deleteHardware(Hardware hardware) {
		hardwareDaoImpl.deleteHardware(hardware);
	}


}
