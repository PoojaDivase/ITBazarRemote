package com.service;

import java.util.ArrayList;
import java.util.List;

import com.dao.SoftwareDetailsDao;
import com.dao.SoftwareDetailsDaoImpl;
import com.model.Software;
import com.model.SoftwareDetails;

public class SoftwareDetailsServiceImpl implements SoftwareDetailsService {
	
	private static List<SoftwareDetails> allSoftwareDetailsList = new ArrayList<SoftwareDetails>();
	SoftwareDetailsDao softwareDetailsDaoImpl = new SoftwareDetailsDaoImpl();
	@Override
	public SoftwareDetails getSoftwareDetails(int SoftwareSrNo) {
		// TODO Auto-generated method stub
		return softwareDetailsDaoImpl.getSoftwareDetails(SoftwareSrNo);
	}
	@Override
	public void updateSoftwareDetails(SoftwareDetails softwareDetails) {
		softwareDetailsDaoImpl.updateSoftwareDetails(softwareDetails);
		
	}
	@Override
	public List<SoftwareDetails> getAllSoftware() {
		// TODO Auto-generated method stub
		return softwareDetailsDaoImpl.getAllSoftware();
	}
	@Override
	public List<SoftwareDetails> getAllSoftwareDetailsForParticularType(int sid) {
		// TODO Auto-generated method stub
		return softwareDetailsDaoImpl.getAllSoftwareDetailsForParticularType(sid);
	}
	@Override
	public void addSoftwareDetails(SoftwareDetails softwareDetails) {
		// TODO Auto-generated method stub
		softwareDetailsDaoImpl.addSoftwareDetails(softwareDetails);
	}
	@Override
	public void deleteSoftwareDetails(SoftwareDetails softwareDetails) {
		// TODO Auto-generated method stub
		softwareDetailsDaoImpl.deleteSoftwareDetails(softwareDetails);
		
	}
	@Override
	public List<Software> getSoftwareDetailsWithList(int sid) {
		// TODO Auto-generated method stub
		return softwareDetailsDaoImpl.getSoftwareDetailsWithList(sid);
	}

	


}
