package com.model;

public class Hardware {

	int hid;
	String hcategory;
	public Hardware() {
		super();
	}
	public Hardware(int hid, String hcategory) {
		super();
		this.hid = hid;
		this.hcategory = hcategory;
	}
	@Override
	public String toString() {
		return "Hardware [hid=" + hid + ", hcategory=" + hcategory + "]";
	}
	public int getHid() {
		return hid;
	}
	public void setHid(int hid) {
		this.hid = hid;
	}
	public String getHcategory() {
		return hcategory;
	}
	public void setHcategory(String hcategory) {
		this.hcategory = hcategory;
	}
	
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
