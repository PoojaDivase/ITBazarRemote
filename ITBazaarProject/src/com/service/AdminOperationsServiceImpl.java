package com.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.model.Hardware;
import com.model.HardwareDetails;
import com.model.SoftwareDetails;

public class AdminOperationsServiceImpl implements AdminOperationsService{

	HardwareDetailsService hardwareDetailsService=new HardwareDetailsServiceImpl();
	SoftwareDetailsService softwareDetailsService=new SoftwareDetailsServiceImpl();
	
	/**
	 * Function to sort the hardware name
	 */
	@Override
	public List<HardwareDetails> SortByHardwareName(int hid) {
		List<HardwareDetails> allHardwareDetailsList1=hardwareDetailsService.getAllHardwareDetailsForParticularType(hid);
		HardwareSorting sortingByName=new HardwareSorting();
		Collections.sort(allHardwareDetailsList1, sortingByName); 
		return allHardwareDetailsList1;
	}
	
/**
 * list of hardware details
 */
	List<HardwareDetails> allHardwareDetailsList = new ArrayList<HardwareDetails>();
	
	/**
	 * Function search hardware by name
	 */
	@Override
	public HardwareDetails SearchHardwareByName(String search) {
		
		allHardwareDetailsList=hardwareDetailsService.getAllHardwareDetails();
		for(HardwareDetails hd1:allHardwareDetailsList)
		{
			if(hd1.getHardwareName().equalsIgnoreCase(search))
			{
				return hd1;
			}
		}
		return null;
	}
	
	/**
	 * Function sort software name by name
	 */
	@Override
	public List<SoftwareDetails> SortBySoftwareName(int sid) {
		List<SoftwareDetails> allSoftwareDetailsList1=softwareDetailsService.getAllSoftwareDetailsForParticularType(sid);
		SoftwareSorting sortingBySoftwareName=new SoftwareSorting();
		Collections.sort(allSoftwareDetailsList1, sortingBySoftwareName); 
		return allSoftwareDetailsList1;
		
	}
	/**
	 * Function search software name by name
	 */
	@Override
	public SoftwareDetails SearchSoftwareByName(String search) {
		List<SoftwareDetails> allSoftwareDetailsList=softwareDetailsService.getAllSoftware();
		for(SoftwareDetails soft:allSoftwareDetailsList)
		{
			if(soft.getSoftwareName().equalsIgnoreCase(search))
			{
				return soft;
			}
		}
		return null;
		
	}
}
