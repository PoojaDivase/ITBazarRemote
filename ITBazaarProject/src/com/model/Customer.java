package com.model;

public class Customer {
	int cid;
	String cname,caddress,email,userId,password,mobileNo;
	public Customer() {
		super();
	}
	
	public Customer(int cid,String mobileNo, String cname, String caddress, String email, String userId,
			String password) {
		super();
		this.cid = cid;
		this.mobileNo = mobileNo;
		this.cname = cname;
		this.caddress = caddress;
		this.email = email;
		this.userId = userId;
		this.password = password;
	}

	public Customer(String mobileNo, String cname, String caddress, String email, String userId, String password) {
		super();
		this.mobileNo = mobileNo;
		this.cname = cname;
		this.caddress = caddress;
		this.email = email;
		this.userId = userId;
		this.password = password;
	}

	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", mobileNo=" + mobileNo + ", cname=" + cname + ", caddress=" + caddress
				+ ", email=" + email + ", userId=" + userId + ", password=" + password + "]";
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCaddress() {
		return caddress;
	}

	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}
