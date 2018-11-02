package com.service;

import java.util.List;

import com.model.Hardware;
import com.model.HardwareDetails;

/**
 * interface to Hardware details service layer
 * @author Administrator
 *
 */
public interface HardwareDetailsService{

	public HardwareDetails getHardwareDetails(int HardwareSrNo);

	public void updateHardwareDetails(HardwareDetails hardwareDetails);
	public List<HardwareDetails> getAllHardwareDetails();
	public List<HardwareDetails> getAllHardwareDetailsForParticularType(int hid);
	public void addHardwareDetails(HardwareDetails hardwareDetails);
	public void deleteHardwareDetails(HardwareDetails hardwareDetails);

	List<Hardware> getHardwareDetailsWithList(int hid);
}
