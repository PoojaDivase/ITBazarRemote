package com.model;

public class SoftwareDetails {
	

	int SoftwareSrNo,SoftwarePrice,SoftwareQuantity,SoftwareDiscount;
	Software software;
	String SoftwareName,SoftwareManufacture;
	public SoftwareDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public SoftwareDetails(int softwareSrNo, int softwarePrice, int softwareQuantity, int softwareDiscount,
			Software software, String softwareName, String softwareManufacture) {
		super();
		SoftwareSrNo = softwareSrNo;
		SoftwarePrice = softwarePrice;
		SoftwareQuantity = softwareQuantity;
		SoftwareDiscount = softwareDiscount;
		this.software = software;
		SoftwareName = softwareName;
		SoftwareManufacture = softwareManufacture;
	}
	@Override
	public String toString() {
		return "SoftwareDetails [SoftwareSrNo=" + SoftwareSrNo + ", SoftwarePrice=" + SoftwarePrice
				+ ", SoftwareQuantity=" + SoftwareQuantity + ", SoftwareDiscount=" + SoftwareDiscount + ", software="
				+ software + ", SoftwareName=" + SoftwareName + ", SoftwareManufacture=" + SoftwareManufacture + "]";
	}
	
	public int getSoftwareSrNo() {
		return SoftwareSrNo;
	}
	public void setSoftwareSrNo(int softwareSrNo) {
		SoftwareSrNo = softwareSrNo;
	}
	public int getSoftwarePrice() {
		return SoftwarePrice;
	}
	public void setSoftwarePrice(int softwarePrice) {
		SoftwarePrice = softwarePrice;
	}
	public int getSoftwareQuantity() {
		return SoftwareQuantity;
	}
	public void setSoftwareQuantity(int softwareQuantity) {
		SoftwareQuantity = softwareQuantity;
	}
	public int getSoftwareDiscount() {
		return SoftwareDiscount;
	}
	public void setSoftwareDiscount(int softwareDiscount) {
		SoftwareDiscount = softwareDiscount;
	}
	public Software getSoftware() {
		return software;
	}
	public void setSoftware(Software software) {
		this.software = software;
	}
	public String getSoftwareName() {
		return SoftwareName;
	}
	public void setSoftwareName(String softwareName) {
		SoftwareName = softwareName;
	}
	public String getSoftwareManufacture() {
		return SoftwareManufacture;
	}
	public void setSoftwareManufacture(String softwareManufacture) {
		SoftwareManufacture = softwareManufacture;
	}
	

}
