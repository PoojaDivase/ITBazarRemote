package com.model;

public class Software {
	int sid ;
	String scategory;
	
	public Software() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Software(int sid, String scategory) {
		super();
		this.sid = sid;
		this.scategory = scategory;
	}
	
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getScategory() {
		return scategory;
	}
	public void setScategory(String scategory) {
		this.scategory = scategory;
	}
	@Override
	public String toString() {
		return "Software [sid=" + sid + ", scategory=" + scategory + "]";
	}
	
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
