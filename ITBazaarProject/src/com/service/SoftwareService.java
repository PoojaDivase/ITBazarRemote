package com.service;

import java.util.List;

import com.dao.SoftwareExistsException;
import com.model.Software;

/**
 * interface gor software service layer
 * @author Administrator
 *
 */
public interface SoftwareService {

	public Software getSoftware(int sid);
	public List<Software> getAllSoftwares();

	void addSoftware(Software software) throws SoftwareExistsException;

	void updateSoftware(Software software);

	void deleteSoftware(Software software);
}
