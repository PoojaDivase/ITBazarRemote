package com.dao;

import java.util.List;

import com.model.Software;
import com.model.SoftwareDetails;

/**
 * interface for software details table with all the dAo functionalities
 * @author Administrator
 *
 */
public interface SoftwareDetailsDao {
	/**
	 * declaration of the variables 
	 */
	String TABLESoftwareDetails="softwareDetails",COLsid="sid",
			COLSoftwareSrNo="softwareSrNo",
			COLSoftwarePrice="softwarePrice",
			COLSoftwareQuantity="softwareQuantity",
			COLSoftwareManufacture="softwareManufacture",
			COLSoftwareDiscount="softwareDiscount",
			COLSoftwareName="softwareName";


	public SoftwareDetails getSoftwareDetails(int SoftwareSrNo);

	public void updateSoftwareDetails(SoftwareDetails softwareDetails);
	public List<SoftwareDetails> getAllSoftware();
	public List<SoftwareDetails> getAllSoftwareDetailsForParticularType(int sid);
	public void addSoftwareDetails(SoftwareDetails softwareDetails);
	public void deleteSoftwareDetails(SoftwareDetails softwareDetails);

	List<Software> getSoftwareDetailsWithList(int sid);

	
}
