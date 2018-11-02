package com.service;

import java.util.ArrayList;
import java.util.List;

import com.dao.SoftwareDetailsDao;
import com.dao.SoftwareDetailsDaoImpl;
import com.model.Software;
import com.model.SoftwareDetails;

public class SoftwareDetailsServiceImpl implements SoftwareDetailsService {
	
	/**
	 * creating list of softwareDetails and object creation
	 */
	private static List<SoftwareDetails> allSoftwareDetailsList = new ArrayList<SoftwareDetails>();
	SoftwareDetailsDao softwareDetailsDaoImpl = new SoftwareDetailsDaoImpl();
	
	/**
	 * Function to get details of particular software
	 */
	@Override
	public SoftwareDetails getSoftwareDetails(int SoftwareSrNo) {
		// TODO Auto-generated method stub
		return softwareDetailsDaoImpl.getSoftwareDetails(SoftwareSrNo);
	}
	
	/**
	 * Function to update software details
	 */
	@Override
	public void updateSoftwareDetails(SoftwareDetails softwareDetails) {
		softwareDetailsDaoImpl.updateSoftwareDetails(softwareDetails);
		
	}
	/**
	 * Function to get all softwares
	 */
	@Override
	public List<SoftwareDetails> getAllSoftware() {
		// TODO Auto-generated method stub
		return softwareDetailsDaoImpl.getAllSoftware();
	}
	/**
	 * Function to get all products for a particular type
	 */
	@Override
	public List<SoftwareDetails> getAllSoftwareDetailsForParticularType(int sid) {
		// TODO Auto-generated method stub
		return softwareDetailsDaoImpl.getAllSoftwareDetailsForParticularType(sid);
	}
	/**
	 * Function to add software product
	 */
	@Override
	public void addSoftwareDetails(SoftwareDetails softwareDetails) {
		// TODO Auto-generated method stub
		softwareDetailsDaoImpl.addSoftwareDetails(softwareDetails);
	}
	/**
	 * Function to delete software product
	 */
	@Override
	public void deleteSoftwareDetails(SoftwareDetails softwareDetails) {
		// TODO Auto-generated method stub
		softwareDetailsDaoImpl.deleteSoftwareDetails(softwareDetails);
		
	}
	/**
	 * Function to get details of a particular type
	 */
	@Override
	public List<Software> getSoftwareDetailsWithList(int sid) {
		// TODO Auto-generated method stub
		return softwareDetailsDaoImpl.getSoftwareDetailsWithList(sid);
	}

	


}
