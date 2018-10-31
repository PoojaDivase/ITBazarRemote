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
	
	List<HardwareDetails> allHardwareDetailsList=new ArrayList<HardwareDetails>();
	String sqlQuery;
	PreparedStatement pst;
	ResultSet rs;
	Connection connection=DBConnection.getConnection();
	HardwareDetails hardwareDetails;
	
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
			sqlQuery="select * from "+TABLEHardwareDetails+" where "+COLHardwareSrNo+"="+"?";
			
			pst=connection.prepareStatement(sqlQuery);
			pst.setInt(1, HardwareSrNo);
			pst.executeQuery();
			rs=pst.getResultSet();
			
			if(rs.next()==false)
			{
				return null;
			}
			
			 int hid=rs.getInt(COLhid);
			HardwareSrNo=rs.getInt(COLHardwareSrNo);
			String HardwareName=rs.getString(COLHardwareName);
			String HardwareManufacture=rs.getString(COLHardwareManufacture);
			int HardwarePrice=rs.getInt(COLHardwarePrice);
			int HardwareQuantity=rs.getInt(COLHardwareQuantity);
			String color=rs.getString(COLColor);
			int HardwareDiscount=rs.getInt(COLHardwareDiscount);
			
			hardwareDetails=new HardwareDetails(HardwareSrNo, HardwarePrice, HardwareQuantity, HardwareDiscount, new HardwareDaoImpl().getHardware(hid), HardwareName, HardwareManufacture, color);
			
			allHardwareDetailsList.add(hardwareDetails);
			return hardwareDetails;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;


	}
	public List<HardwareDetails> getAllHardwareDetails() {
		// TODO Auto-generated method stub
		
		allHardwareDetailsList=new ArrayList<HardwareDetails>();
		try {
			sqlQuery="select * from "+TABLEHardwareDetails;
			
			pst=connection.prepareStatement(sqlQuery);
			
			pst.executeQuery();
			rs=pst.getResultSet();
			
			while(rs.next())
			{
				 int hid=rs.getInt(COLhid);
				int HardwareSrNo=rs.getInt(COLHardwareSrNo);
				String HardwareName=rs.getString(COLHardwareName);
				String HardwareManufacture=rs.getString(COLHardwareManufacture);
				int HardwarePrice=rs.getInt(COLHardwarePrice);
				int HardwareQuantity=rs.getInt(COLHardwareQuantity);
				String color=rs.getString(COLColor);
				int HardwareDiscount=rs.getInt(COLHardwareDiscount);

				hardwareDetails=new HardwareDetails(HardwareSrNo, HardwarePrice, HardwareQuantity, HardwareDiscount, new HardwareDaoImpl().getHardware(hid), HardwareName, HardwareManufacture, color);
				allHardwareDetailsList.add(hardwareDetails);	
			}
			return  allHardwareDetailsList;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	public List<HardwareDetails> getAllHardwareDetailsForParticularType(int hid)
	{
		allHardwareDetailsList=new ArrayList<HardwareDetails>();
		sqlQuery="select * from "+TABLEHardwareDetails+" where "+COLhid+"="+"?";
		try {
			pst = connection.prepareStatement(sqlQuery);
			pst.setInt(1, hid);
			pst.executeQuery();
			ResultSet rs=pst.getResultSet();

			while(rs.next())
			{
				hid=rs.getInt(COLhid);
				int HardwareSrNo=rs.getInt(COLHardwareSrNo);
				String HardwareName=rs.getString(COLHardwareName);
				String HardwareManufacture=rs.getString(COLHardwareManufacture);
				int HardwarePrice=rs.getInt(COLHardwarePrice);
				int HardwareQuantity=rs.getInt(COLHardwareQuantity);
				String color=rs.getString(COLColor);
				int HardwareDiscount=rs.getInt(COLHardwareDiscount);
				
				hardwareDetails=new HardwareDetails(HardwareSrNo, HardwarePrice, HardwareQuantity, HardwareDiscount, new HardwareDaoImpl().getHardware(hid), HardwareName, HardwareManufacture, color);
				
				allHardwareDetailsList.add(hardwareDetails);
			}
			
			return  allHardwareDetailsList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
//	@Override
//	public List<Enrollment> getEnrollmentforCourse(int cid) {
//		// TODO Auto-generated method stub
//		
//		allEnrollmentList=new ArrayList<Enrollment>();
//		Connection connection=DBConnection.getConnection();
//		String sqlQuery="select * from "+TABLEenroll+" where "+COLcid+"="+"?";
//		
//		PreparedStatement pst;
//		try {
//			pst = connection.prepareStatement(sqlQuery);
//			pst.setInt(1, cid);
//			pst.executeQuery();
//			ResultSet rs=pst.getResultSet();
//
//			
//			while(rs.next())
//			{
//				int sid=rs.getInt(COLsid);
//				 cid=rs.getInt(COLcid);
//				Date enrolldate=rs.getDate(COLenrolldate);
//				int feespaid=rs.getInt(COLfeespaid);
//				
//				Enrollment enroll=new Enrollment(new StudentDaoimpl().getStudent(sid),new CourseDaoimpl().getcourse(cid),enrolldate,feespaid);
//				allEnrollmentList.add(enroll);
//				
//			}
//			return  allEnrollmentList;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		
//
//		return null;
//	}
//
//
	public void addHardwareDetails(HardwareDetails hardwareDetails) {
		try {
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
	public void deleteHardwareDetails(HardwareDetails hardwareDetails) {
		try {
			Connection connection=DBConnection.getConnection();
			String sqlQuery="delete from "+TABLEHardwareDetails+" where "+COLHardwareSrNo+"=?";
			pst = connection.prepareStatement(sqlQuery);
			
			//pst.setInt(1,hardwareDetails.getHardware().getHid());
			pst.setInt(1,hardwareDetails.getHardwareSrNo());
			pst.executeUpdate();
			
			allHardwareDetailsList.remove(hardwareDetails);
			
//			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void updateHardwareDetails(HardwareDetails hardwareDetails)
	{
		
		try {
			Connection connection=DBConnection.getConnection();
			int hardwareSrNo = hardwareDetails.getHardwareSrNo();
			String sqlQuery="update "+ TABLEHardwareDetails +" set "+COLHardwareQuantity+" =? , "+ COLHardwarePrice + " =? , "+ COLHardwareDiscount + " =? " + " where "+COLHardwareSrNo+" = " +hardwareSrNo;
			pst = connection.prepareStatement(sqlQuery);
			
			pst.setInt(1, hardwareDetails.getHardwareQuantity());
			pst.setInt(2, hardwareDetails.getHardwarePrice());
			pst.setInt(3 ,hardwareDetails.getHardwareDiscount());
			pst.executeUpdate();
			
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
	@Override
	public List<Hardware> getHardwareDetailsWithList(int hid) {
		
		allHardwareDetailsList=new ArrayList<HardwareDetails>();
		List <Hardware> hardwareList=new ArrayList<Hardware>();
		sqlQuery="select * from "+TABLEHardwareDetails+" where "+COLhid+"="+"?";
		try {
			pst = connection.prepareStatement(sqlQuery);
			pst.setInt(1, hid);
			pst.executeQuery();
			ResultSet rs=pst.getResultSet();

			
			while(rs.next())
			{
				hid=rs.getInt(COLhid);
				int HardwareSrNo=rs.getInt(COLHardwareSrNo);
				String HardwareName=rs.getString(COLHardwareName);
				String HardwareManufacture=rs.getString(COLHardwareManufacture);
				int HardwarePrice=rs.getInt(COLHardwarePrice);
				int HardwareQuantity=rs.getInt(COLHardwareQuantity);
				String color=rs.getString(COLColor);
				int HardwareDiscount=rs.getInt(COLHardwareDiscount);

				hardwareDetails=new HardwareDetails(HardwareSrNo, HardwarePrice, HardwareQuantity, HardwareDiscount, new HardwareDaoImpl().getHardware(hid), HardwareName, HardwareManufacture, color);
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
