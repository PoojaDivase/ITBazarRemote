package com.dao;

import java.util.List;

import com.model.Hardware;

public interface HardwareDao {

	String TABLEhardware="hardware",COLhid="hid",COLhcategory="hcategory";

	Hardware getHardware(int hid);

	List<Hardware> getAllHardwares();

	public void addHardware(Hardware hardware) throws HardwareExistsException;

	void updateHardware(Hardware hardware);

	void deleteHardware(Hardware hardware);
}
