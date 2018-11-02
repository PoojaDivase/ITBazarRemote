package com.service;

import java.util.ArrayList;

import java.util.List;

import com.dao.HardwareDetailsDao;
import com.dao.HardwareDetailsDaoImpl;
import com.model.Hardware;
import com.model.HardwareDetails;

public class HardwareDetailsServiceImpl implements HardwareDetailsService{

	/**
	 * creating list of hardwareDetails and object creation
	 */
	private static List<HardwareDetails> allHardwareDetailsList = new ArrayList<HardwareDetails>();
	HardwareDetailsDao hardwareDetailsDaoImpl = new HardwareDetailsDaoImpl();
	
	/**
	 * Function to get details of a particular hardware
	 */
	@Override
	public HardwareDetails getHardwareDetails(int HardwareSrNo) {
		// TODO Auto-generated method stub
		return hardwareDetailsDaoImpl.getHardwareDetails(HardwareSrNo);
	}
	/**
	 * Function to update hardware details
	 */
	@Override
	public void updateHardwareDetails(HardwareDetails hardwareDetails) {
		// TODO Auto-generated method stub
		hardwareDetailsDaoImpl.updateHardwareDetails(hardwareDetails);
	}
	/**
	 * Function to get all the hardware details
	 */
	@Override
	public List<HardwareDetails> getAllHardwareDetails() {
		// TODO Auto-generated method stub
		return hardwareDetailsDaoImpl.getAllHardwareDetails();
	}
	/**
	 * Function to get all the hardware details of a particular type
	 */
	@Override
	public List<HardwareDetails> getAllHardwareDetailsForParticularType(int hid) {
		// TODO Auto-generated method stub
		return hardwareDetailsDaoImpl.getAllHardwareDetailsForParticularType(hid);
	}
	/**
	 * Function to add hardware details
	 */
	@Override
	public void addHardwareDetails(HardwareDetails hardwareDetails) {
		// TODO Auto-generated method stub
		hardwareDetailsDaoImpl.addHardwareDetails(hardwareDetails);
	}
	/**
	 * Function to delete hardware details
	 */
	@Override
	public void deleteHardwareDetails(HardwareDetails hardwareDetails) {
		// TODO Auto-generated method stub
		hardwareDetailsDaoImpl.deleteHardwareDetails(hardwareDetails);
	}
	/**
	 * Function to get hardware details of a particular type
	 */
	@Override
	public List<Hardware> getHardwareDetailsWithList(int hid) {
		// TODO Auto-generated method stub
		return hardwareDetailsDaoImpl.getHardwareDetailsWithList(hid);
	}
	public List<HardwareDetails> getListOfParticularHardwareType(int i) {
		// TODO Auto-generated method stub
		return null;
	}



}
