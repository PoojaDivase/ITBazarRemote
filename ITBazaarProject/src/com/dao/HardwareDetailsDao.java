package com.dao;

import java.util.List;

import com.model.Hardware;
import com.model.HardwareDetails;

/**
 * interface for HardwareDetails Table with all the DAO functionalities
 * @author Administrator
 *
 */
public interface HardwareDetailsDao {
	/**
	 * declaration of all variables 
	 */
	String TABLEHardwareDetails="hardwareDetails",COLhid="hid",
			COLHardwareSrNo="hardwareSrNo",
			COLHardwarePrice="hardwarePrice",
			COLHardwareQuantity="hardwareQuantity",
			COLHardwareManufacture="hardwareManufacture",
			COLColor="color",
			COLHardwareDiscount="hardwareDiscount",
			COLHardwareName="hardwareName";


	public HardwareDetails getHardwareDetails(int HardwareSrNo);

	public void updateHardwareDetails(HardwareDetails hardwareDetails);
	public List<HardwareDetails> getAllHardwareDetails();
	public List<HardwareDetails> getAllHardwareDetailsForParticularType(int hid);
	public void addHardwareDetails(HardwareDetails hardwareDetails);
	public void deleteHardwareDetails(HardwareDetails hardwareDetails);

	List<Hardware> getHardwareDetailsWithList(int hid);
}
