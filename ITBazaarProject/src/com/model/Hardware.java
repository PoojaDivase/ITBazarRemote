package com.model;

import com.sun.xml.rpc.processor.modeler.j2ee.xml.homeType;

/**
 * this class is used to use the hardware details from the hardware table
 * @author Administrator
 *
 */
public class Hardware {

	/**
	 * variable initialization
	 */
	int hid;
	String hcategory;
	
	/**
	 * simple constructor of super() type
	 */
	public Hardware() {
		super();
	}
	/**
	 * Parameterized Constructor
	 * @param hid is the hardware id  
	 * @param hcategory is the category or the general types of the hardware
	 */
	public Hardware(int hid, String hcategory) {
		super();
		this.hid = hid;
		this.hcategory = hcategory;
	}
	/**
	 * toString Function
	 */
	@Override
	public String toString() {
		return "Hardware [hid=" + hid + ", hcategory=" + hcategory + "]";
	}
	
	/**
	 * getters and setters
	 * this function is used to get the hardware id 
	 * @return the hardware id
	 */
	public int getHid() {
		return hid;
	}
	/**
	 * this function is used to set the hardware id
	 * @param hid is used to get the hardware id and use it 
	 * @see Hardware#getHid()
	 */
	public void setHid(int hid) {
		this.hid = hid;
	}
	
	/**
	 * this function is used to get the type of hardware or the category of hardware
	 * @return the category of the hardware
	 */
	public String getHcategory() {
		return hcategory;
	}
	/**
	 * this function is used to set the hardware category
	 * @param hcategory is used to get and set the hardware category
	 * @see Hardware#getHcategory()
	 */
	public void setHcategory(String hcategory) {
		this.hcategory = hcategory;
	}
	
	/**
	 * this function is used to check the equality of the objects
	 * @param ob is used to get the object for checking the equality
	 * @return the boolean value
	 */
	public boolean equals(Object ob)
	{
		try
		{
		Hardware course=(Hardware)ob;
		if(this.hid==course.hid)
			return true;
		return false;
		}
		catch(Exception ex)
		{
			return super.equals(ob);
		}
	}
}
