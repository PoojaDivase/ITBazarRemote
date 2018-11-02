package com.model;

/**
 * this class is used to use the software  details from the software  table
 * @author Administrator
 *
 */
public class Software {
	/**
	 * variable initialization
	 */
	int sid ;
	String scategory;
	
	/**
	 * simple constructor of super() type
	 */
	public Software() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * parameterized Constructor
	 * @param sid is used to get the primary id of the software type
	 * @param scategory is used to get the category of the software
	 */
	public Software(int sid, String scategory) {
		super();
		this.sid = sid;
		this.scategory = scategory;
	}
	
	/**
	 * getters and setters
	 * this function is used to get the id of the software type
	 * @return the software id
	 */
	public int getSid() {
		return sid;
	}
	
	/**
	 * this function is used to set the id of the software typr
	 * @param sid is the software id 
	 * @see Software#getSid()
	 */
	public void setSid(int sid) {
		this.sid = sid;
	}
	
	/**
	 * this function is used to get the category of the software 
	 * @return the category of the software
	 */
	public String getScategory() {
		return scategory;
	}
	/**
	 * this function is used to set the category of the software
	 * @param scategory is the category of the software
	 * @see Software#getScategory()
	 */
	public void setScategory(String scategory) {
		this.scategory = scategory;
	}
	/**
	 * toString function
	 */
	@Override
	public String toString() {
		return "Software [sid=" + sid + ", scategory=" + scategory + "]";
	}
	
	/**
	 *  this Function is used to check equality of the objects
	 */
	public boolean equals(Object ob)
	{
		try
		{
	Software softwaresObject=(Software)ob;
		if(this.sid==softwaresObject.sid)
			return true;
		return false;
		}
		catch(Exception ex)
		{
			return super.equals(ob);
		}
	}
	

}
