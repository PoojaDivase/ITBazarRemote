package com.service;

import java.util.List;

import com.model.HardwareDetails;
import com.model.Order;
import com.model.SoftwareDetails;

/**
 * interface for combination of products
 * @author Administrator
 *
 */
public interface CombinationOrderService {
	//public HardwareDetails SearchHardwareByName(String search);
	//public SoftwareDetails SearchSoftwareByName(String search);
	public Order PlaceHardwareOrder(HardwareDetails hardwareDetails,int customerId);
	public Order PlaceSoftwareOrder(SoftwareDetails softwareDetails,int customerId);
	public int bulkDiscountHardware(int SrNo,int quantity);

}

