package com.service;

import java.util.List;

import com.model.Software;
import com.model.SoftwareDetails;

public interface SoftwareDetailsService {

	public SoftwareDetails getSoftwareDetails(int SoftwareSrNo);

	public void updateSoftwareDetails(SoftwareDetails softwareDetails);
	public List<SoftwareDetails> getAllSoftware();
	public List<SoftwareDetails> getAllSoftwareDetailsForParticularType(int sid);
	public void addSoftwareDetails(SoftwareDetails softwareDetails);
	public void deleteSoftwareDetails(SoftwareDetails softwareDetails);
	List<Software> getSoftwareDetailsWithList(int sid);

}
