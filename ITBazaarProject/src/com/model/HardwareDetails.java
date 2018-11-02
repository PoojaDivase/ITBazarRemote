package com.model;

/**
 * this class is used to use the hardware product details from the hardware details table
 * @author Administrator
 *
 */
public class HardwareDetails {

	/**
	 * variable initialization
	 */
	int HardwareSrNo,HardwarePrice,HardwareQuantity,HardwareDiscount;
	Hardware hardware2;
	String HardwareName,HardwareManufacture,Color;
	
	/**
	 * simple constructor of super() type
	 */
	public HardwareDetails() {
		super();
	}

	/**
	 * Parameterized Constructor
	 * @param hardwareSrNo is the primary serial no. given to all the hardware products
	 * @param hardwarePrice is used to give the hardware price
	 * @param hardwareQuantity is used to give the hardware quantity
	 * @param hardwareDiscount is used to give the hardware discount
	 * @param hardware is the object of the hardware type table which is used to get the hardware id and its category
	 * @param hardwareName is used to get the hardware name
	 * @param hardwareManufacture is used to get the hardware manufacturing company
	 * @param color is used to give the color of the product
	 */
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
	
	/**
	 * toString function
	 */
	@Override
	public String toString() {
		return "HardwareDetails [HardwareSrNo=" + HardwareSrNo + ", HardwarePrice=" + HardwarePrice
				+ ", HardwareQuantity=" + HardwareQuantity + ", HardwareDiscount=" + HardwareDiscount + ", hardware="
				+ hardware2 + ", HardwareName=" + HardwareName + ", HardwareManufacture=" + HardwareManufacture
				+ ", Color=" + Color + "]";
	}

	/**
	 * getters and setters
	 * this function is used to get the hardware serial no. of all the hardware products
	 * @return the hardware serial no
	 */
	public int getHardwareSrNo() {
		return HardwareSrNo;
	}
	
	/**
	 * this function is used to set the hardware serial no. of the product
	 * @param hardwareSrNo is used to get the hardware Sr.no
	 * @see HardwareDetails#getHardwareSrNo()
	 */
	public void setHardwareSrNo(int hardwareSrNo) {
		HardwareSrNo = hardwareSrNo;
	}
	/**
	 * this function is used to get the price of the particular hardware
	 * @return the hardware product price
	 */
	public int getHardwarePrice() {
		return HardwarePrice;
	}
	/**
	 * this function is used to set the hardware price of the particular product
	 * @param hardwarePrice gives the hardware price and sets it for further using in other files
	 * @see HardwareDetails#getHardwarePrice()
	 */
	public void setHardwarePrice(int hardwarePrice) {
		HardwarePrice = hardwarePrice;
	}
	/**
	 * this function is used to get the hardware quantity 
	 * @return the hardware quantity of the particular product
	 */
	public int getHardwareQuantity() {
		return HardwareQuantity;
	}
	/**
	 * this function is used to set the hardware quantity of the particular product
	 * @param hardwareQuantity is used to get and set the quantity of the hardware product
	 * @see HardwareDetails#getHardwareQuantity()
	 */
	public void setHardwareQuantity(int hardwareQuantity) {
		HardwareQuantity = hardwareQuantity;
	}
	/**
	 * this function is used to get the hardware discount
	 * @return the discount of the particular product
	 */
	public int getHardwareDiscount() {
		return HardwareDiscount;
	}
	/**
	 * this function is used to set the discount provided in the particular hardware product
	 * @param hardwareDiscount is used to get the discount on the particular hardware product
	 * @see HardwareDetails#getHardwareDiscount()
	 */
	public void setHardwareDiscount(int hardwareDiscount) {
		HardwareDiscount = hardwareDiscount;
	}
	
	/**
	 * this function is used to get the details of the type of hardware from hardware table using its object
	 * @return the object with the type of the hardware
	 */
	public Hardware getHardware() {
		return hardware2;
	}
	/**
	 * this function is used to set the hardware id and category by using the object of the hardware table
	 * @param hardware is the object which is used to get the hid and category of the hardware
	 * @see HardwareDetails#getHardware()
	 */
	public void setHardware(Hardware hardware) {
		this.hardware2 = hardware;
	}
	/**
	 * this function is used to get the name of the hardware product
	 * @return the name of the hardware product
	 */
	public String getHardwareName() {
		return HardwareName;
	}
	/**
	 * this function is used to set the name of the hardware product
	 * @param hardwareName gives the name of the hardware product
	 * @see HardwareDetails#getHardwareName()
	 */
	public void setHardwareName(String hardwareName) {
		HardwareName = hardwareName;
	} 
	/**
	 * this function is used to get the name of the company of that hardware product
	 * @return the company of that hardware product
	 */
	public String getHardwareManufacture() {
		return HardwareManufacture;
	}
	/**
	 * this function is used to set the name of the company that has manufactured that product
	 * @param hardwareManufacture give the name of that company that has manufactured that product
	 * @see HardwareDetails#getHardwareManufacture()
	 */
	public void setHardwareManufacture(String hardwareManufacture) {
		HardwareManufacture = hardwareManufacture;
	} 
	/**
	 * this function is used get the color of that particular hardware product
	 * @return the color of that particular product
	 */
	public String getColor() {
		return Color;
	}
	/**
	 * this function is used to set the color of the particular hardware product
	 * @param color give the colour of the particular hardware product
	 * @see HardwareDetails#getColor()
	 */
	public void setColor(String color) {
		Color = color;
	}
}
