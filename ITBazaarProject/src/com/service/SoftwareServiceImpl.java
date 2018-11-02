package com.service;

import java.util.List;

import com.dao.SoftwareDaoImpl;
import com.dao.SoftwareExistsException;
import com.model.Software;

public class SoftwareServiceImpl implements SoftwareService{

	/**
	 * creating object
	 */
	SoftwareDaoImpl softwareDao=new SoftwareDaoImpl();
	
	/**
	 * Function to get particular software details
	 */
	@Override
	public Software getSoftware(int sid) {
		// TODO Auto-generated method stub
		Software software=softwareDao.getSoftware(sid);
		return software;
	}

	/**
	 * Function to get all software details
	 */
	@Override
	public List<Software> getAllSoftwares() {
		// TODO Auto-generated method stub
		return softwareDao.getAllSoftwares();
	}

	/**
	 * Function to add software
	 */
	@Override
	public void addSoftware(Software software) throws SoftwareExistsException {
		// TODO Auto-generated method stub
		softwareDao.addSoftware(software);
	}

	/**
	 * Function to update software
	 */
	@Override
	public void updateSoftware(Software software) {
		// TODO Auto-generated method stub
		softwareDao.updateSoftware(software);
	}

	/**
	 * Function to delete software
	 */
	@Override
	public void deleteSoftware(Software software) {
		// TODO Auto-generated method stub
		softwareDao.deleteSoftware(software);
	}

}
