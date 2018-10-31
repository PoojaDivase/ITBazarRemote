package com.dao;

import java.util.List;

import com.model.Software;

public interface SoftwareDao {
	
	String TABLEsoftware="software",COLsid="sid",COLscategory="scategory";

	public Software getSoftware(int sid);
	public List<Software> getAllSoftwares();

	void addSoftware(Software software) throws SoftwareExistsException;

	void updateSoftware(Software software);

	void deleteSoftware(Software software);

}
