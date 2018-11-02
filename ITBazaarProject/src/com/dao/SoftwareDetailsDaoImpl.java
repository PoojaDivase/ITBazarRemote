package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.main.DBConnection;
import com.model.Software;
import com.model.SoftwareDetails;

public class SoftwareDetailsDaoImpl  implements SoftwareDetailsDao{
	/**
	 * declaring the list of Software details table
	 */
	List<SoftwareDetails> allSoftwareDetailsList=new ArrayList<SoftwareDetails>();
	/**
	 * object of customer, preparedStatement, resultSet is created
	 * String variable declaration for sqlQuery is created
	 */

	String sqlQuery;
	PreparedStatement pst;
	ResultSet rs;
	Connection connection=DBConnection.getConnection();
	SoftwareDetails softwareDetails;
	
	/**
	 * Function to get a software detail for a particular sr.No
	 */
	public SoftwareDetails getSoftwareDetails(int SoftwareSrNo)
	{
		
		try {
			
			SoftwareDetails item=new SoftwareDetails();
			item.setSoftwareSrNo(SoftwareSrNo);
			
			if(allSoftwareDetailsList.contains(item))
			{
				
			int index=allSoftwareDetailsList.indexOf(item);
			return allSoftwareDetailsList.get(index);
			}
			/**
			 * Query to get a software detail for a particular sr.No
			 */
			sqlQuery="select * from "+TABLESoftwareDetails+" where "+COLSoftwareSrNo+"="+"?";
			
			pst=connection.prepareStatement(sqlQuery);
			pst.setInt(1, SoftwareSrNo);
			pst.executeQuery();
			rs=pst.getResultSet();
			
			if(rs.next()==false)
			{
				return null;
			}
			
			/**
			 * getting the data
			 */
			 int sid=rs.getInt(COLsid);
			SoftwareSrNo=rs.getInt(COLSoftwareSrNo);
			String SoftwareName=rs.getString(COLSoftwareName);
			String SoftwareManufacture=rs.getString(COLSoftwareManufacture);
			int SoftwarePrice=rs.getInt(COLSoftwarePrice);
			int SoftwareQuantity=rs.getInt(COLSoftwareQuantity);
		
			int SoftwareDiscount=rs.getInt(COLSoftwareDiscount);
			
			softwareDetails=new SoftwareDetails(SoftwareSrNo, SoftwarePrice, SoftwareQuantity, SoftwareDiscount, new SoftwareDaoImpl().getSoftware(sid), SoftwareName, SoftwareManufacture);
			
			/**
			 * add in the list and return
			 */
			
			allSoftwareDetailsList.add(softwareDetails);
			return softwareDetails;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;


	}
	/**
	 * function to get all the Software details product
	 */
	public List<SoftwareDetails> getAllSoftware() {
		// TODO Auto-generated method stub
		
		allSoftwareDetailsList=new ArrayList<SoftwareDetails>();
		try {
			/**
			 * Query to get all the Software details product
			 */
			sqlQuery="select * from "+TABLESoftwareDetails;
			
			pst=connection.prepareStatement(sqlQuery);
			
			pst.executeQuery();
			rs=pst.getResultSet();
			
			while(rs.next())
			{
				/**
				 * getting the data
				 */
				 int sid=rs.getInt(COLsid);
				int SoftwareSrNo=rs.getInt(COLSoftwareSrNo);
				String SoftwareName=rs.getString(COLSoftwareName);
				String SoftwareManufacture=rs.getString(COLSoftwareManufacture);
				int SoftwarePrice=rs.getInt(COLSoftwarePrice);
				int SoftwareQuantity=rs.getInt(COLSoftwareQuantity);
				int SoftwareDiscount=rs.getInt(COLSoftwareDiscount);

				softwareDetails=new SoftwareDetails(SoftwareSrNo, SoftwarePrice, SoftwareQuantity, SoftwareDiscount, new SoftwareDaoImpl().getSoftware(sid), SoftwareName, SoftwareManufacture);
				/**
				 * adding it to the list and returning the list
				 */
				allSoftwareDetailsList.add(softwareDetails);	
			}
			return  allSoftwareDetailsList;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * Function to get all software details for a particular type of software
	 */
	public List<SoftwareDetails> getAllSoftwareDetailsForParticularType(int sid)
	{
		allSoftwareDetailsList=new ArrayList<SoftwareDetails>();
		/**
		 * Query to get all software details for a particular type of software
		 */
		sqlQuery="select * from "+TABLESoftwareDetails+" where "+COLsid+"="+"?";
		try {
			pst = connection.prepareStatement(sqlQuery);
			pst.setInt(1, sid);
			pst.executeQuery();
			ResultSet rs=pst.getResultSet();

			while(rs.next())
			{
				/**
				 * getting the data
				 */
				sid=rs.getInt(COLsid);
				int SoftwareSrNo=rs.getInt(COLSoftwareSrNo);
				String SoftwareName=rs.getString(COLSoftwareName);
				String SoftwareManufacture=rs.getString(COLSoftwareManufacture);
				int SoftwarePrice=rs.getInt(COLSoftwarePrice);
				int SoftwareQuantity=rs.getInt(COLSoftwareQuantity);
				
				int SoftwareDiscount=rs.getInt(COLSoftwareDiscount);
				
				softwareDetails=new SoftwareDetails(SoftwareSrNo, SoftwarePrice, SoftwareQuantity, SoftwareDiscount, new SoftwareDaoImpl().getSoftware(sid), SoftwareName, SoftwareManufacture);
				/**
				 * adding it to the list and return
				 */
				allSoftwareDetailsList.add(softwareDetails);
			}
			
			return  allSoftwareDetailsList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	/**
	 * Function to add Software product
	 */
	public void addSoftwareDetails(SoftwareDetails softwareDetails) {
		try {
			/**
			 * Query to add Software product
			 */
			sqlQuery="insert into "+TABLESoftwareDetails+"("+COLSoftwareSrNo+","+COLSoftwareName+","+COLSoftwarePrice+","+COLSoftwareQuantity+","+COLSoftwareManufacture+","+COLSoftwareDiscount+","+COLsid+")"+" values(?,?,?,?,?,?,?)";
			pst = connection.prepareStatement(sqlQuery);
			pst.setInt(1,softwareDetails.getSoftwareSrNo());
			pst.setString(2,softwareDetails.getSoftwareName());
			pst.setInt(3,softwareDetails.getSoftwarePrice());
			pst.setInt(4,softwareDetails.getSoftwareQuantity());
			pst.setString(5, softwareDetails.getSoftwareManufacture());
			
			pst.setInt(6, softwareDetails.getSoftwareDiscount());
			pst.setInt(7, softwareDetails.getSoftware().getSid());
			pst.executeUpdate();
			/**
			 * add it to the list
			 */
			allSoftwareDetailsList.add(softwareDetails);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Function to delete a particular product
	 */
	public void deleteSoftwareDetails(SoftwareDetails softwareDetails) {
		try {
			/**
			 * Query to delete a particular product
			 */
			sqlQuery="delete from "+TABLESoftwareDetails+" where "+COLSoftwareSrNo+"=?";
			pst = connection.prepareStatement(sqlQuery);
			
			//pst.setInt(1,softwareDetails.getSoftware().getSid());
			pst.setInt(1,softwareDetails.getSoftwareSrNo());
			pst.executeUpdate();
			
			/**
			 * remove from the list
			 */
			allSoftwareDetailsList.remove(softwareDetails);
			
//			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * Function to update any product details with quantity, discount, price
	 */
	public void updateSoftwareDetails(SoftwareDetails softwareDetails)
	{
		try {
			int software_SRNo=softwareDetails.getSoftwareSrNo();
			/**
			 * Query to update any product details with quantity, discount, price
			 */
			 sqlQuery="update "+TABLESoftwareDetails+" set "+COLSoftwareQuantity+" =? ,"+COLSoftwarePrice+" =? , "+COLSoftwareDiscount+" =? "+" where "+COLSoftwareSrNo+"= "+software_SRNo;
			pst = connection.prepareStatement(sqlQuery);
			
			pst.setInt(1,softwareDetails.getSoftwareQuantity());
			pst.setInt(2,softwareDetails.getSoftwarePrice());
			pst.setInt(3,softwareDetails.getSoftwareDiscount());
			pst.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * Function to get software details of a particular type
	 */
	@Override
	public List<Software> getSoftwareDetailsWithList(int sid) {
		
		allSoftwareDetailsList=new ArrayList<SoftwareDetails>();
		List <Software> softwareList=new ArrayList<Software>();
		/**
		 * Query to get software details of a particular type
		 */
		sqlQuery="select * from "+TABLESoftwareDetails+" where "+COLsid+"="+"?";
		try {
			pst = connection.prepareStatement(sqlQuery);
			pst.setInt(1, sid);
			pst.executeQuery();
			ResultSet rs=pst.getResultSet();

			
			while(rs.next())
			{
				/**
				 * getting the data
				 */
				sid=rs.getInt(COLsid);
				int SoftwareSrNo=rs.getInt(COLSoftwareSrNo);
				String SoftwareName=rs.getString(COLSoftwareName);
				String SoftwareManufacture=rs.getString(COLSoftwareManufacture);
				int SoftwarePrice=rs.getInt(COLSoftwarePrice);
				int SoftwareQuantity=rs.getInt(COLSoftwareQuantity);
				int SoftwareDiscount=rs.getInt(COLSoftwareDiscount);

				softwareDetails=new SoftwareDetails(SoftwareSrNo, SoftwarePrice, SoftwareQuantity, SoftwareDiscount, new SoftwareDaoImpl().getSoftware(sid), SoftwareName, SoftwareManufacture);
				
				/**
				 * add it into the list
				 */
				allSoftwareDetailsList.add(softwareDetails);	
				
			}
			for(SoftwareDetails softwareDetails:allSoftwareDetailsList)
			{
				softwareList.add(softwareDetails.getSoftware());
			}
			return softwareList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
