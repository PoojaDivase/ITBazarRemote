package com.service;

import java.util.List;

import com.model.Hardware;
import com.model.HardwareDetails;
import com.model.SoftwareDetails;

public interface AdminOperationsService {

	public List<HardwareDetails> SortByHardwareName(int hid);
	public HardwareDetails SearchHardwareByName(String search);
	
	public List<SoftwareDetails> SortBySoftwareName(int sid);
	public SoftwareDetails SearchSoftwareByName(String search);
}
