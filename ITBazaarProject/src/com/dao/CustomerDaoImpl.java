package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.main.DBConnection;
import com.model.Customer;


public class CustomerDaoImpl implements CustomerDao{

	/**
	 * an list of customer is created using util.List
	 */
	private static List<Customer>allCustomersList=new ArrayList<Customer>();
/**
 * object of customer, preparedStatement, resultSet is created
 * String variable declaration for sqlQuery is created
 */
	Customer customer;
	PreparedStatement pst; //creating the object of PreparedStatement
	Connection connection=DBConnection.getConnection(); //establishing the connection
	ResultSet rs; //object of ResultSet
	String sqlQuery; //Declaration of the sqlQuery variable as String

	/**
	 * Function for getting a particular customer
	 */
	public Customer getCustomer(int cid)
	{
		
		try {
			Customer customerd=new Customer();
			customerd.setCid(cid);;
			
			if(allCustomersList.contains(customerd))
			{
				
			int index=allCustomersList.indexOf(customerd);
			return allCustomersList.get(index);
			}
			/**
			 * Query to get a particular customer function
			 */
			
			sqlQuery="select * from "+TABLECustomer+" where "+COLCid+"="+"?";
			
			pst=connection.prepareStatement(sqlQuery);
			pst.setInt(1, cid);
			pst.executeQuery();
			rs=pst.getResultSet();
			
			if(rs.next()==false)
			{
				return null;
			}
			/**
			 * fetching data in resultSet object
			 */
			String name=rs.getString(COLCName);
			String Address=rs.getString(COLAddress);
			String email=rs.getString(COLEmail);
			String mobileNo=rs.getString(COLMobileNo);
			String userId=rs.getString(COLUserId);
			String password=rs.getString(COLPassword);
			
			/**
			 * insert into customer object
			 */
			customer=new Customer(cid,mobileNo, name, Address, email,userId,password);
			allCustomersList.add(customer);
			return customer;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * Function to get all customers
	 */
	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		
		
		try {
			/**
			 * Query to get all the customers function
			 */
			
			sqlQuery="select * from "+TABLECustomer;
			
			pst=connection.prepareStatement(sqlQuery);
			pst.executeQuery();
			rs=pst.getResultSet();
			
			/**
			 * fetching data in resultSet object
			 */
			
			while(rs.next())
			{
				
				int cid=rs.getInt(COLCid);
				String name=rs.getString(COLCName);
				String Address=rs.getString(COLAddress);
				String email=rs.getString(COLEmail);
				String mobileNo=rs.getString(COLMobileNo);
				String userId=rs.getString(COLUserId);
				String password=rs.getString(COLPassword);
				
				/**
				 * insert into customer object
				 */
				customer=new Customer(cid,mobileNo, name, Address, email,userId,password);
				
				/**
				 * adding it to a list
				 */
				allCustomersList.add(customer);
					
			}
			return  allCustomersList;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * function to add a customer
	 */
	@Override
	public void addCustomer(Customer cust) {
		try {
			/**
			 * Query to insert a new customer
			 */
			sqlQuery="insert into "+TABLECustomer+" values(?,?,?,?,?,?)";
			pst = connection.prepareStatement(sqlQuery);
		//	pst.setInt(1,cust.getCid());
			/**
			 * setting of all data
			 */
			pst.setString(1, cust.getCname());
			pst.setString(2,cust.getCaddress());
			pst.setString(3,cust.getEmail());
			pst.setString(4, cust.getMobileNo());
			pst.setString(5, cust.getUserId());
			pst.setString(6, cust.getPassword());
			pst.executeUpdate();
			/**
			 * adding it to a list
			 */
			allCustomersList.add(cust);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateCustomer(Customer cust) {
		try {
			/**
			 * Query to update the customer details
			 */
			sqlQuery="update "+TABLECustomer+" set "+COLCName+"=?"+","+COLAddress+"=?"+","+COLMobileNo+"=?"+COLEmail+"=?"+" where "+COLCid+"=?";
			pst = connection.prepareStatement(sqlQuery);
			
			/**
			 * setting a data
			 */
			pst.setString(1,cust.getCname());
			pst.setString(2,cust.getCaddress());
			pst.setString(3,cust.getMobileNo());
			pst.setString(4,cust.getEmail());
			pst.setInt(5, cust.getCid());
			pst.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * function to delete a customer
	 */
	@Override
	public void deleteCustomer(Customer cust) {
		try {
			/**
			 * Query to delete a customer details
			 */
			sqlQuery="delete from "+TABLECustomer+" where "+COLCid+"=?";
			pst = connection.prepareStatement(sqlQuery);
			pst.setInt(1,cust.getCid());
			pst.executeUpdate();
			/**
			 * and remove it from the list
			 */
			allCustomersList.remove(cust);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
