package com.service;

import java.util.List;

import com.dao.HardwareExistsException;
import com.model.Hardware;

/**
 * interface for hardware service layer
 * @author Administrator
 *
 */
public interface HardwareService {

	public Hardware getHardware(int hid);
	public List<Hardware> getAllHardwares();
	public void addHardware(Hardware hardware) throws HardwareExistsException;
	public void updateHardware(Hardware hardware);
	public void deleteHardware(Hardware hardware);
}
