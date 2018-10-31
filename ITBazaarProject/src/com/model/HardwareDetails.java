package com.model;

public class HardwareDetails {

	int HardwareSrNo,HardwarePrice,HardwareQuantity,HardwareDiscount;
	Hardware hardware2;
	String HardwareName,HardwareManufacture,Color;
	
	public HardwareDetails() {
		super();
	}

	public HardwareDetails(int hardwareSrNo, int hardwarePrice, int hardwareQuantity, int hardwareDiscount,
			Hardware hardware, String hardwareName, String hardwareManufacture, String color) {
		super();
		HardwareSrNo = hardwareSrNo;
		HardwarePrice = hardwarePrice;
		HardwareQuantity = hardwareQuantity;
		HardwareDiscount = hardwareDiscount;
		this.hardware2 = hardware;
		HardwareName = hardwareName;
		HardwareManufacture = hardwareManufacture;
		Color = color;
	}
	
	@Override
	public String toString() {
		return "HardwareDetails [HardwareSrNo=" + HardwareSrNo + ", HardwarePrice=" + HardwarePrice
				+ ", HardwareQuantity=" + HardwareQuantity + ", HardwareDiscount=" + HardwareDiscount + ", hardware="
				+ hardware2 + ", HardwareName=" + HardwareName + ", HardwareManufacture=" + HardwareManufacture
				+ ", Color=" + Color + "]";
	}
	public int getHardwareSrNo() {
		return HardwareSrNo;
	}
	public void setHardwareSrNo(int hardwareSrNo) {
		HardwareSrNo = hardwareSrNo;
	}
	public int getHardwarePrice() {
		return HardwarePrice;
	}
	public void setHardwarePrice(int hardwarePrice) {
		HardwarePrice = hardwarePrice;
	}
	public int getHardwareQuantity() {
		return HardwareQuantity;
	}
	public void setHardwareQuantity(int hardwareQuantity) {
		HardwareQuantity = hardwareQuantity;
	}
	public int getHardwareDiscount() {
		return HardwareDiscount;
	}
	public void setHardwareDiscount(int hardwareDiscount) {
		HardwareDiscount = hardwareDiscount;
	}
	public Hardware getHardware() {
		return hardware2;
	}
	public void setHardware(Hardware hardware) {
		this.hardware2 = hardware;
	}
	public String getHardwareName() {
		return HardwareName;
	}
	public void setHardwareName(String hardwareName) {
		HardwareName = hardwareName;
	}
	public String getHardwareManufacture() {
		return HardwareManufacture;
	}
	public void setHardwareManufacture(String hardwareManufacture) {
		HardwareManufacture = hardwareManufacture;
	}
	public String getColor() {
		return Color;
	}
	public void setColor(String color) {
		Color = color;
	}
}
