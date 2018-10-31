package com.service;

import java.util.Comparator;

import com.model.SoftwareDetails;

public class SoftwareSorting implements Comparator<SoftwareDetails>{

	@Override
	public int compare(SoftwareDetails o1, SoftwareDetails o2) {
		
		return o1.getSoftwareName().compareToIgnoreCase(o2.getSoftwareName());
	}

}
