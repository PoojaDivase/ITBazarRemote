package com.dao;

import java.util.List;

import com.model.Hardware;
/**
 * interface for hardwareDao and declaration for all functions 
 * @author Administrator
 *
 */
public interface HardwareDao {
/**
 * declaration of variables
 */
	String TABLEhardware="hardware",COLhid="hid",COLhcategory="hcategory";

	Hardware getHardware(int hid);

	List<Hardware> getAllHardwares();

	public void addHardware(Hardware hardware) throws HardwareExistsException;

	void updateHardware(Hardware hardware);

	void deleteHardware(Hardware hardware);
}
