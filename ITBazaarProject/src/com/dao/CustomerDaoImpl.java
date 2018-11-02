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

	private static List<Customer>allCustomersList=new ArrayList<Customer>();

	Customer customer;
	PreparedStatement pst; //creating the object of PreparedStatement
	Connection connection=DBConnection.getConnection(); //establishing the connection
	ResultSet rs; //object of ResultSet
	String sqlQuery; //Declaration of the sqlQuery variable as String
	
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
			sqlQuery="select * from "+TABLECustomer+" where "+COLCid+"="+"?";
			
			pst=connection.prepareStatement(sqlQuery);
			pst.setInt(1, cid);
			pst.executeQuery();
			rs=pst.getResultSet();
			
			if(rs.next()==false)
			{
				return null;
			}
			
			String name=rs.getString(COLCName);
			String Address=rs.getString(COLAddress);
			String email=rs.getString(COLEmail);
			String mobileNo=rs.getString(COLMobileNo);
			String userId=rs.getString(COLUserId);
			String password=rs.getString(COLPassword);
			
			customer=new Customer(cid,mobileNo, name, Address, email,userId,password);
			allCustomersList.add(customer);
			return customer;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		
		
		try {
			sqlQuery="select * from "+TABLECustomer;
			
			pst=connection.prepareStatement(sqlQuery);
			pst.executeQuery();
			rs=pst.getResultSet();
			
			while(rs.next())
			{
				int cid=rs.getInt(COLCid);
				String name=rs.getString(COLCName);
				String Address=rs.getString(COLAddress);
				String email=rs.getString(COLEmail);
				String mobileNo=rs.getString(COLMobileNo);
				String userId=rs.getString(COLUserId);
				String password=rs.getString(COLPassword);
				
				customer=new Customer(cid,mobileNo, name, Address, email,userId,password);
				
				allCustomersList.add(customer);
				
				
			}
			
			
			
			return  allCustomersList;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;

		
		
	}

	@Override
	public void addCustomer(Customer cust) {
		try {
			sqlQuery="insert into "+TABLECustomer+" values(?,?,?,?,?,?)";
			pst = connection.prepareStatement(sqlQuery);
		//	pst.setInt(1,cust.getCid());
			pst.setString(1, cust.getCname());
			pst.setString(2,cust.getCaddress());
			pst.setString(3,cust.getEmail());
			pst.setString(4, cust.getMobileNo());
			pst.setString(5, cust.getUserId());
			pst.setString(6, cust.getPassword());
			pst.executeUpdate();
			allCustomersList.add(cust);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateCustomer(Customer cust) {
		try {
			sqlQuery="update "+TABLECustomer+" set "+COLCName+"=?"+","+COLAddress+"=?"+","+COLMobileNo+"=?"+COLEmail+"=?"+" where "+COLCid+"=?";
			pst = connection.prepareStatement(sqlQuery);
			
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

	@Override
	public void deleteCustomer(Customer cust) {
		try {
			sqlQuery="delete from "+TABLECustomer+" where "+COLCid+"=?";
			pst = connection.prepareStatement(sqlQuery);
			pst.setInt(1,cust.getCid());
			pst.executeUpdate();
			allCustomersList.remove(cust);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
