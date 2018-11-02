package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.main.DBConnection;

import com.model.Software;

public class SoftwareDaoImpl implements SoftwareDao{
	
	/**
	 * creating a list of Software table
	 */
	private static List<Software>allSoftwareList=new ArrayList<Software>();
	/**
	 * object of customer, preparedStatement, resultSet is created
	 * String variable declaration for sqlQuery is created
	 */

	Software software; //creating the object of Hardware
	PreparedStatement pst; //creating the object of PreparedStatement
	Connection connection=DBConnection.getConnection(); //establishing the connection
	ResultSet rs; //object of ResultSet
	String sqlQuery; //Declaration of the sqlQuery variable as String

	
	/**
	 * this function is to get the type of particular hardware using its id
	 */
	@Override
	public Software getSoftware(int sid) {
		// TODO Auto-generated method stub
		try {
			Software item=new Software();
			item.setSid(sid);
			if(allSoftwareList.contains(item))
			{
				
			int index=allSoftwareList.indexOf(item);
			return allSoftwareList.get(index);
			}
			/**
			 * Query to get the type of particular hardware using its id
			 */
			sqlQuery="select * from "+TABLEsoftware+" where "+COLsid+"="+"?";
			
			pst=connection.prepareStatement(sqlQuery);
			pst.setInt(1, sid);
			pst.executeQuery();
			rs=pst.getResultSet();
			
			if(rs.next()==false)
			{
				return null;
			}
			
			String scategory=rs.getString(COLscategory);
			software=new Software(sid, scategory);
			/**
			 * add it in the list
			 */
			allSoftwareList.add(software);
			return software;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		return null;
	}

	/**
	 * this function is used for getting all the elements from the hardware table
	 */
	@Override
	public List<Software> getAllSoftwares() {
		// TODO Auto-generated method stub
		allSoftwareList=new ArrayList<Software>();
		try {
			/**
			 * Query to fetch all data from software table
			 */
			sqlQuery="select * from "+TABLEsoftware;
			
			pst=connection.prepareStatement(sqlQuery);
			
			pst.executeQuery();
			rs=pst.getResultSet();
			
			while(rs.next())
			{
				/**
				 * getting the data
				 */
				int sid=rs.getInt(COLsid);
				String scategory=rs.getString(COLscategory);
				software=new Software(sid,scategory);
				allSoftwareList.add(software);
				
			}
			/**
			 * returning list
			 */
			return  allSoftwareList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * this function is used to add any category
	 */
	@Override
	public void addSoftware(Software software) throws SoftwareExistsException {
		try {
			/**
			 * Query to insert software
			 */
			sqlQuery="insert into "+TABLEsoftware+" values(?,?)";
			pst = connection.prepareStatement(sqlQuery);
			pst.setInt(1,software.getSid());
			pst.setString(2,software.getScategory());
			pst.executeUpdate();
			/**
			 * add it into the list
			 */
			allSoftwareList.add(software);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * this function is used to update the category of the hardware by using its hid
	 */
	@Override
	public void updateSoftware(Software software) {
		// TODO Auto-generated method stub
		try {
			/**
			 * Query to update category of software
			 */
			sqlQuery="update "+TABLEsoftware+" set "+COLscategory+"=?"+" where "+COLsid+"=?";
			pst = connection.prepareStatement(sqlQuery);
			
			/**
			 * setting the data
			 */
			pst.setString(1, software.getScategory());
			pst.setInt(2,software.getSid());
		
			pst.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	/**
	 * this function is used to delete the category of the hardware by using its hid
	 */
	@Override
	public void deleteSoftware(Software software) {
		try {
			/**
			 * Query to delete the category of the hardware by using its hid
			 */
			sqlQuery="delete from "+TABLEsoftware+" where "+COLsid+"=?";
			pst = connection.prepareStatement(sqlQuery);
			
			pst.setInt(1,software.getSid());
			 
			pst.executeUpdate();
			/**
			 * removing it from the list
			 */
			allSoftwareList.remove(software);
			
//			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
