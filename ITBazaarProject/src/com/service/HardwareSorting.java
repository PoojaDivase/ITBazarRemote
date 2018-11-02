package com.service;

import java.util.Comparator;

import com.model.HardwareDetails;

public class HardwareSorting implements Comparator<HardwareDetails>{

	/**
	 * Function to compare names and sort
	 */
	@Override
	public int compare(HardwareDetails o1, HardwareDetails o2) {
		// TODO Auto-generated method stub
		 return o1.getHardwareName().compareToIgnoreCase(o2.getHardwareName());
	}

}
