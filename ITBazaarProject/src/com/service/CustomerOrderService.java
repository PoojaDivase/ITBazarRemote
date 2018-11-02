package com.service;

import com.model.HardwareDetails;
import com.model.Order;
import com.model.SoftwareDetails;

public interface CustomerOrderService {
	public Order PlaceHardwareOrder(HardwareDetails hardwareDetails,int customerId);
	public Order PlaceSoftwareOrder(SoftwareDetails softwareDetails,int customerId);
}
