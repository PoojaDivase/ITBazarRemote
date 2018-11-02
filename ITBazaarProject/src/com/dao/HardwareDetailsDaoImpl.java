package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.main.DBConnection;
import com.model.Hardware;
import com.model.HardwareDetails;

public class HardwareDetailsDaoImpl implements HardwareDetailsDao{
	/**
	 * creating a list of HardwareDetails
	 */
	List<HardwareDetails> allHardwareDetailsList=new ArrayList<HardwareDetails>();
	/**
	 * object of customer, preparedStatement, resultSet is created
	 * String variable declaration for sqlQuery is created
	 */

	String sqlQuery;
	PreparedStatement pst;
	ResultSet rs;
	Connection connection=DBConnection.getConnection();
	HardwareDetails hardwareDetails;
	
	/**
	 * get HardwareDetails with a particular HardwaresrNo
	 */
	public HardwareDetails getHardwareDetails(int HardwareSrNo)
	{
		
		try {
			HardwareDetails item=new HardwareDetails();
			item.setHardwareSrNo(HardwareSrNo);
			
			if(allHardwareDetailsList.contains(item))
			{
				
			int index=allHardwareDetailsList.indexOf(item);
			return allHardwareDetailsList.get(index);
			}
			/**
			 * Query to get a particular HardwareDetails 
			 */
			sqlQuery="select * from "+TABLEHardwareDetails+" where "+COLHardwareSrNo+"="+"?";
			
			pst=connection.prepareStatement(sqlQuery);
			pst.setInt(1, HardwareSrNo);
			pst.executeQuery();
			rs=pst.getResultSet();
			
			if(rs.next()==false)
			{
				return null;
			}
			
			/**
			 * get the data into variables
			 */
			 int hid=rs.getInt(COLhid);
			HardwareSrNo=rs.getInt(COLHardwareSrNo);
			String HardwareName=rs.getString(COLHardwareName);
			String HardwareManufacture=rs.getString(COLHardwareManufacture);
			int HardwarePrice=rs.getInt(COLHardwarePrice);
			int HardwareQuantity=rs.getInt(COLHardwareQuantity);
			String color=rs.getString(COLColor);
			int HardwareDiscount=rs.getInt(COLHardwareDiscount);
			
			hardwareDetails=new HardwareDetails(HardwareSrNo, HardwarePrice, HardwareQuantity, HardwareDiscount, new HardwareDaoImpl().getHardware(hid), HardwareName, HardwareManufacture, color);
			/**
			 * add it to the list
			 */
			allHardwareDetailsList.add(hardwareDetails);
			return hardwareDetails;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;


	}
	
	/**
	 * Function to get all the hardwareDetails
	 */
	public List<HardwareDetails> getAllHardwareDetails() {
		// TODO Auto-generated method stub
		
		allHardwareDetailsList=new ArrayList<HardwareDetails>();
		try {
			/**
			 * Query to get all the hardwareDetails
			 */
			sqlQuery="select * from "+TABLEHardwareDetails;
			
			pst=connection.prepareStatement(sqlQuery);
			
			pst.executeQuery();
			rs=pst.getResultSet();
			
			while(rs.next())
			{
				/**
				 * getting the data
				 */
				 int hid=rs.getInt(COLhid);
				int HardwareSrNo=rs.getInt(COLHardwareSrNo);
				String HardwareName=rs.getString(COLHardwareName);
				String HardwareManufacture=rs.getString(COLHardwareManufacture);
				int HardwarePrice=rs.getInt(COLHardwarePrice);
				int HardwareQuantity=rs.getInt(COLHardwareQuantity);
				String color=rs.getString(COLColor);
				int HardwareDiscount=rs.getInt(COLHardwareDiscount);

				hardwareDetails=new HardwareDetails(HardwareSrNo, HardwarePrice, HardwareQuantity, HardwareDiscount, new HardwareDaoImpl().getHardware(hid), HardwareName, HardwareManufacture, color);
				/**
				 * add it into the list
				 */
				allHardwareDetailsList.add(hardwareDetails);	
			}
			/**
			 * return the list
			 */
			return  allHardwareDetailsList;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * function to get all hardware details for a particular type
	 */
	public List<HardwareDetails> getAllHardwareDetailsForParticularType(int hid)
	{
		allHardwareDetailsList=new ArrayList<HardwareDetails>();
		/**
		 * Query to get all hardware details for a particular type
		 */
		sqlQuery="select * from "+TABLEHardwareDetails+" where "+COLhid+"="+"?";
		try {
			pst = connection.prepareStatement(sqlQuery);
			pst.setInt(1, hid);
			pst.executeQuery();
			ResultSet rs=pst.getResultSet();

			while(rs.next())
			{
				/**
				 * getting the data
				 */
				hid=rs.getInt(COLhid);
				int HardwareSrNo=rs.getInt(COLHardwareSrNo);
				String HardwareName=rs.getString(COLHardwareName);
				String HardwareManufacture=rs.getString(COLHardwareManufacture);
				int HardwarePrice=rs.getInt(COLHardwarePrice);
				int HardwareQuantity=rs.getInt(COLHardwareQuantity);
				String color=rs.getString(COLColor);
				int HardwareDiscount=rs.getInt(COLHardwareDiscount);
				
				hardwareDetails=new HardwareDetails(HardwareSrNo, HardwarePrice, HardwareQuantity, HardwareDiscount, new HardwareDaoImpl().getHardware(hid), HardwareName, HardwareManufacture, color);
				/**
				 * adding it to the list
				 */
				allHardwareDetailsList.add(hardwareDetails);
			}
			
			return  allHardwareDetailsList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	/**
	 * function to add Hardware product
	 */
	public void addHardwareDetails(HardwareDetails hardwareDetails) {
		try {
			/**
			 * Query to add a product in the table
			 */
			sqlQuery="insert into "+TABLEHardwareDetails+"("+COLHardwareSrNo+","+COLHardwareName+","+COLHardwarePrice+","+COLHardwareQuantity+","+COLHardwareManufacture+","+COLColor+","+COLHardwareDiscount+","+COLhid+")"+" values(?,?,?,?,?,?,?,?)";
			pst = connection.prepareStatement(sqlQuery);
			pst.setInt(1,hardwareDetails.getHardwareSrNo());
			pst.setString(2,hardwareDetails.getHardwareName());
			pst.setInt(3,hardwareDetails.getHardwarePrice());
			pst.setInt(4,hardwareDetails.getHardwareQuantity());
			pst.setString(5, hardwareDetails.getHardwareManufacture());
			pst.setString(6, hardwareDetails.getColor());
			pst.setInt(7, hardwareDetails.getHardwareDiscount());
			pst.setInt(8, hardwareDetails.getHardware().getHid());
			pst.executeUpdate();
			allHardwareDetailsList.add(hardwareDetails);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * function to delete a particular hardware product
	 */
	public void deleteHardwareDetails(HardwareDetails hardwareDetails) {
		try {
			Connection connection=DBConnection.getConnection();
			/** 
			 * Query to delete a hardware product
			 */
			String sqlQuery="delete from "+TABLEHardwareDetails+" where "+COLHardwareSrNo+"=?";
			pst = connection.prepareStatement(sqlQuery);
			
			//pst.setInt(1,hardwareDetails.getHardware().getHid());
			pst.setInt(1,hardwareDetails.getHardwareSrNo());
			pst.executeUpdate();
			
			/**
			 * remove it from the list
			 */
			allHardwareDetailsList.remove(hardwareDetails);
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * Function to update the hardwareDetails about the product
	 */
	public void updateHardwareDetails(HardwareDetails hardwareDetails)
	{
		
		try {
			Connection connection=DBConnection.getConnection();
			int hardwareSrNo = hardwareDetails.getHardwareSrNo();
			/**
			 * Query to  update details which can update only quantity, price, discount
			 */
			String sqlQuery="update "+ TABLEHardwareDetails +" set "+COLHardwareQuantity+" =? , "+ COLHardwarePrice + " =? , "+ COLHardwareDiscount + " =? " + " where "+COLHardwareSrNo+" = " +hardwareSrNo;
			pst = connection.prepareStatement(sqlQuery);
			
			/**
			 * setting the data
			 */
			pst.setInt(1, hardwareDetails.getHardwareQuantity());
			pst.setInt(2, hardwareDetails.getHardwarePrice());
			pst.setInt(3 ,hardwareDetails.getHardwareDiscount());
			pst.executeUpdate();
			
			/**
			 *  in all list and with a particular No.
			 */
			for(HardwareDetails allhardwareDetails:allHardwareDetailsList)
			{
				if(allhardwareDetails.getHardwareSrNo()==hardwareDetails.getHardwareSrNo())
				{
					allhardwareDetails.setHardwareQuantity(hardwareDetails.getHardwareQuantity());
					allhardwareDetails.setHardwarePrice(hardwareDetails.getHardwarePrice());
					allhardwareDetails.setHardwareDiscount(hardwareDetails.getHardwareDiscount());
				}
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * get the hardware details of a particular type 
	 */
	@Override
	public List<Hardware> getHardwareDetailsWithList(int hid) {
		
		allHardwareDetailsList=new ArrayList<HardwareDetails>();
		List <Hardware> hardwareList=new ArrayList<Hardware>();
		/**
		 * Query to get the hardware details of a particular type
		 */
		sqlQuery="select * from "+TABLEHardwareDetails+" where "+COLhid+"="+"?";
		try {
			pst = connection.prepareStatement(sqlQuery);
			pst.setInt(1, hid);
			pst.executeQuery();
			ResultSet rs=pst.getResultSet();

			
			while(rs.next())
			{
				/**
				 * getting the data
				 */
				hid=rs.getInt(COLhid);
				int HardwareSrNo=rs.getInt(COLHardwareSrNo);
				String HardwareName=rs.getString(COLHardwareName);
				String HardwareManufacture=rs.getString(COLHardwareManufacture);
				int HardwarePrice=rs.getInt(COLHardwarePrice);
				int HardwareQuantity=rs.getInt(COLHardwareQuantity);
				String color=rs.getString(COLColor);
				int HardwareDiscount=rs.getInt(COLHardwareDiscount);

				hardwareDetails=new HardwareDetails(HardwareSrNo, HardwarePrice, HardwareQuantity, HardwareDiscount, new HardwareDaoImpl().getHardware(hid), HardwareName, HardwareManufacture, color);
				/**
				 * adding it to the list
				 */
				allHardwareDetailsList.add(hardwareDetails);	
				
			}
			for(HardwareDetails hardwareDetails:allHardwareDetailsList)
			{
				hardwareList.add(hardwareDetails.getHardware());
			}
			
			return hardwareList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
