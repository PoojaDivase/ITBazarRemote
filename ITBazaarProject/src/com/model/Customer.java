package com.model;

/**
 * this class is created to get the customer details from table and use it in the rest of the files
 */
public class Customer {
	/**
	 * Variable declaration 
	 */
	int cid;
	String cname,caddress,email,userId,password,mobileNo;
	
	/**
	 * Simple Constructor
	 */
	public Customer() {
		super();
	}
	
	/**
	 * Parameterized Constructor
	 * @param cid 	represents customer id which is in the table
	 * @param mobileNo	represents customer mobile No
	 * @param cname	represents customer name
	 * @param caddress	represents customer address
	 * @param email	represents customer email 
	 * @param userId represents user ID
	 * @param password represents user password
	 */
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

	/**
	 * Parameterized Constructor
	 * @param mobileNo represents customer mobile No
	 * @param cname represents customer name
	 * @param caddress represents address of the customer
	 * @param email represents email of the customer
	 * @param userId represents user Id of the customer used for login 
	 * @param password represents password of the customer used for login
	 */
	public Customer(String mobileNo, String cname, String caddress, String email, String userId, String password) {
		super();
		this.mobileNo = mobileNo;
		this.cname = cname;
		this.caddress = caddress;
		this.email = email;
		this.userId = userId;
		this.password = password;
	}

	/**
	 * toString Function
	 * 
	 */
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", mobileNo=" + mobileNo + ", cname=" + cname + ", caddress=" + caddress
				+ ", email=" + email + ", userId=" + userId + ", password=" + password + "]";
	}

	/**
	 * getter and setters
	 * Function gets the customer Id
	 * @return returns customer id
	 */
	public int getCid() {
		return cid;
	}

	/**
	 * Function sets the customer ID
	 * @param cid sets the customer id
	 * @see com.model.Customer#getCid()
	 */
	public void setCid(int cid) {
		this.cid = cid;
	}

	
	/**
	 * Function gets the mobile No
	 * @return returns the mobile No
	 */
	public String getMobileNo() {
		return mobileNo;
	}

	/**
	 * Function sets the mobile No
	 * @param mobileNo sets the customer mobileNo
	 * @see com.model.Customer#getMobileNo()
	 */
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	/**
	 * Function gets the customer name
	 * @return customer name 
	 */
	public String getCname() {
		return cname;
	}

	/**
	 * Function sets the customer name
	 * @param cname sets the customer name
	 * @see com.model.Customer#getCname()
	 */
	public void setCname(String cname) {
		this.cname = cname;
	}

	/**
	 * Function gets the customer address
	 * @return the customer address
	 */
	public String getCaddress() {
		return caddress;
	}

	/**
	 * Function sets the customer address
	 * @param caddress is used to set the customer address
	 * @see com.model.Customer#getCaddress()
	 */
	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}

	/**
	 * Function gets the email id of the customer from the table
	 * @return the email id of the customer
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Function sets the email id of the customer from the table
	 * @param email is used to set the email id
	 * @see com.model.Customer#getEmail()
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Function is the used to get the user id of the customer
	 * @return the user id
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * Function is used to set the user id of the customer 
	 * @param userId is used to set  the user id of the customer
	 * @see Customer#getUserId()
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * Function is the used to get the password of the customer
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Function is used to set the user id of the customer
	 * @param password is used to set the password of the customer
	 * @see Customer#getPassword()
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	
}
