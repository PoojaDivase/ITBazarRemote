package com.service;

import java.util.List;

import com.dao.SoftwareDaoImpl;
import com.dao.SoftwareExistsException;
import com.model.Software;

public class SoftwareServiceImpl implements SoftwareService{

	SoftwareDaoImpl softwareDao=new SoftwareDaoImpl();
	
	@Override
	public Software getSoftware(int sid) {
		// TODO Auto-generated method stub
		Software software=softwareDao.getSoftware(sid);
		return software;
	}

	@Override
	public List<Software> getAllSoftwares() {
		// TODO Auto-generated method stub
		return softwareDao.getAllSoftwares();
	}

	@Override
	public void addSoftware(Software software) throws SoftwareExistsException {
		// TODO Auto-generated method stub
		softwareDao.addSoftware(software);
	}

	@Override
	public void updateSoftware(Software software) {
		// TODO Auto-generated method stub
		softwareDao.updateSoftware(software);
	}

	@Override
	public void deleteSoftware(Software software) {
		// TODO Auto-generated method stub
		softwareDao.deleteSoftware(software);
	}

}
