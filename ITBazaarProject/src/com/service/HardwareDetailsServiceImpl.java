package com.service;

import java.util.ArrayList;

import java.util.List;

import com.dao.HardwareDetailsDao;
import com.dao.HardwareDetailsDaoImpl;
import com.model.Hardware;
import com.model.HardwareDetails;

public class HardwareDetailsServiceImpl implements HardwareDetailsService{

	private static List<HardwareDetails> allHardwareDetailsList = new ArrayList<HardwareDetails>();
	HardwareDetailsDao hardwareDetailsDaoImpl = new HardwareDetailsDaoImpl();
	@Override
	public HardwareDetails getHardwareDetails(int HardwareSrNo) {
		// TODO Auto-generated method stub
		return hardwareDetailsDaoImpl.getHardwareDetails(HardwareSrNo);
	}
	@Override
	public void updateHardwareDetails(HardwareDetails hardwareDetails) {
		// TODO Auto-generated method stub
		hardwareDetailsDaoImpl.updateHardwareDetails(hardwareDetails);
	}
	@Override
	public List<HardwareDetails> getAllHardwareDetails() {
		// TODO Auto-generated method stub
		return hardwareDetailsDaoImpl.getAllHardwareDetails();
	}
	@Override
	public List<HardwareDetails> getAllHardwareDetailsForParticularType(int hid) {
		// TODO Auto-generated method stub
		return hardwareDetailsDaoImpl.getAllHardwareDetailsForParticularType(hid);
	}
	@Override
	public void addHardwareDetails(HardwareDetails hardwareDetails) {
		// TODO Auto-generated method stub
		hardwareDetailsDaoImpl.addHardwareDetails(hardwareDetails);
	}
	@Override
	public void deleteHardwareDetails(HardwareDetails hardwareDetails) {
		// TODO Auto-generated method stub
		hardwareDetailsDaoImpl.deleteHardwareDetails(hardwareDetails);
	}
	@Override
	public List<Hardware> getHardwareDetailsWithList(int hid) {
		// TODO Auto-generated method stub
		return hardwareDetailsDaoImpl.getHardwareDetailsWithList(hid);
	}



}
