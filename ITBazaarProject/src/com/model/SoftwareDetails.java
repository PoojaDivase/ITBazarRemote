package com.model;

/**
 * this class is used to use the software product details from the software details table
 * @author Administrator
 *
 */
public class SoftwareDetails {
	
	/**
	 * variable initialization
	 */
	int SoftwareSrNo,SoftwarePrice,SoftwareQuantity,SoftwareDiscount;
	Software software;
	String SoftwareName,SoftwareManufacture;
	/**
	 * Creation of super constructor
	 */
	public SoftwareDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Parameterized Constructor
	 * @param softwareSrNo is the primary key of the software serial no.
	 * @param softwarePrice is the price of the software product
	 * @param softwareQuantity is the quantity of the product available
	 * @param softwareDiscount is the discount given to the software
	 * @param software is the object of the type of the software
	 * @param softwareName is the name of the software product
	 * @param softwareManufacture is the name of the company which has manufactured the product
	 */
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
	/**
	 * toString function
	 */
	@Override
	public String toString() {
		return "SoftwareDetails [SoftwareSrNo=" + SoftwareSrNo + ", SoftwarePrice=" + SoftwarePrice
				+ ", SoftwareQuantity=" + SoftwareQuantity + ", SoftwareDiscount=" + SoftwareDiscount + ", software="
				+ software + ", SoftwareName=" + SoftwareName + ", SoftwareManufacture=" + SoftwareManufacture + "]";
	}
	
	/**
	 * getters and setters
	 * this function is used to get the software serial no. of all the software products
	 * @return the software serial no. of all the software products
	 */
	public int getSoftwareSrNo() {
		return SoftwareSrNo;
	}
	/**
	 * this function is used to set the software serial no. of the product
	 * @param softwareSrNo the software serial no. of the product
	 * @see SoftwareDetails#getSoftwareSrNo()
	 */
	public void setSoftwareSrNo(int softwareSrNo) {
		SoftwareSrNo = softwareSrNo;
	}
	
	/**
	 * this function is used to get the price of the particular software
	 * @return the software product price
	 */
	public int getSoftwarePrice() {
		return SoftwarePrice;
	}
	
	/**
	 * this function is used to set the software price of the particular product
	 * @param softwarePrice gives the software price and sets it for further using in other files
	 * @see SoftwareDetails#getSoftwarePrice()
	 */
	public void setSoftwarePrice(int softwarePrice) {
		SoftwarePrice = softwarePrice;
	}
	
	/**
	 * this function is used to get the software quantity 
	 * @return the software quantity of the particular product
	 */
	public int getSoftwareQuantity() {
		return SoftwareQuantity;
	}
	/**
	 * this function is used to set the software quantity of the particular product
	 * @param softwareQuantity is used to get and set the quantity of the software product
	 * @see SoftwareDetails#getSoftwareQuantity()
	 */
	public void setSoftwareQuantity(int softwareQuantity) {
		SoftwareQuantity = softwareQuantity;
	}
	/**
	 * this function is used to get the software discount
	 * @return the discount of the particular product
	 */
	public int getSoftwareDiscount() {
		return SoftwareDiscount;
	}
	/**
	 * this function is used to set the discount provided in the particular software product
	 * @param softwareDiscount is used to get the discount on the particular software product
	 * @see SoftwareDetails#getSoftwareDiscount()
	 */
	public void setSoftwareDiscount(int softwareDiscount) {
		SoftwareDiscount = softwareDiscount;
	}
	/**
	 * this function is used to get the details of the type of software from software table using its object
	 * @return the object with the type of the software
	 */
	public Software getSoftware() {
		return software;
	}
	/**
	 * this function is used to set the software id and category by using the object of the software table
	 * @param software is the object which is used to get the sid and category of the software
	 * @see SoftwareDetails#getSoftware()
	 */
	public void setSoftware(Software software) {
		this.software = software;
	}
	/**
	 * this function is used to get the name of the software product
	 * @return the name of the software product
	 */
	public String getSoftwareName() {
		return SoftwareName;
	}
	/**
	 * this function is used to set the name of the software product
	 * @param softwareName gives the name of the software product
	 * @see SoftwareDetails#getSoftwareName()
	 */
	public void setSoftwareName(String softwareName) {
		SoftwareName = softwareName;
	}
	/**
	 * this function is used to get the name of the company of that software product
	 * @return the company of that software product
	 */
	public String getSoftwareManufacture() {
		return SoftwareManufacture;
	}
	
	/**
	 * this function is used to set the name of the company that has manufactured that product
	 * @param softwareManufacture give the name of that company that has manufactured that product
	 * @see SoftwareDetails#getSoftwareManufacture()
	 */
	public void setSoftwareManufacture(String softwareManufacture) {
		SoftwareManufacture = softwareManufacture;
	}
	

}
