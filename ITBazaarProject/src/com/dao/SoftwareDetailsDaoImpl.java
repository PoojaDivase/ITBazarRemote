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
	
	List<SoftwareDetails> allSoftwareDetailsList=new ArrayList<SoftwareDetails>();
	String sqlQuery;
	PreparedStatement pst;
	ResultSet rs;
	Connection connection=DBConnection.getConnection();
	SoftwareDetails softwareDetails;
	
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
			sqlQuery="select * from "+TABLESoftwareDetails+" where "+COLSoftwareSrNo+"="+"?";
			
			pst=connection.prepareStatement(sqlQuery);
			pst.setInt(1, SoftwareSrNo);
			pst.executeQuery();
			rs=pst.getResultSet();
			
			if(rs.next()==false)
			{
				return null;
			}
			
			 int sid=rs.getInt(COLsid);
			SoftwareSrNo=rs.getInt(COLSoftwareSrNo);
			String SoftwareName=rs.getString(COLSoftwareName);
			String SoftwareManufacture=rs.getString(COLSoftwareManufacture);
			int SoftwarePrice=rs.getInt(COLSoftwarePrice);
			int SoftwareQuantity=rs.getInt(COLSoftwareQuantity);
		
			int SoftwareDiscount=rs.getInt(COLSoftwareDiscount);
			
			softwareDetails=new SoftwareDetails(SoftwareSrNo, SoftwarePrice, SoftwareQuantity, SoftwareDiscount, new SoftwareDaoImpl().getSoftware(sid), SoftwareName, SoftwareManufacture);
			
			
			allSoftwareDetailsList.add(softwareDetails);
			return softwareDetails;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;


	}
	public List<SoftwareDetails> getAllSoftware() {
		// TODO Auto-generated method stub
		
		allSoftwareDetailsList=new ArrayList<SoftwareDetails>();
		try {
			sqlQuery="select * from "+TABLESoftwareDetails;
			
			pst=connection.prepareStatement(sqlQuery);
			
			pst.executeQuery();
			rs=pst.getResultSet();
			
			while(rs.next())
			{
				 int sid=rs.getInt(COLsid);
				int SoftwareSrNo=rs.getInt(COLSoftwareSrNo);
				String SoftwareName=rs.getString(COLSoftwareName);
				String SoftwareManufacture=rs.getString(COLSoftwareManufacture);
				int SoftwarePrice=rs.getInt(COLSoftwarePrice);
				int SoftwareQuantity=rs.getInt(COLSoftwareQuantity);
				int SoftwareDiscount=rs.getInt(COLSoftwareDiscount);

				softwareDetails=new SoftwareDetails(SoftwareSrNo, SoftwarePrice, SoftwareQuantity, SoftwareDiscount, new SoftwareDaoImpl().getSoftware(sid), SoftwareName, SoftwareManufacture);
				allSoftwareDetailsList.add(softwareDetails);	
			}
			return  allSoftwareDetailsList;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	public List<SoftwareDetails> getAllSoftwareDetailsForParticularType(int sid)
	{
		allSoftwareDetailsList=new ArrayList<SoftwareDetails>();
		sqlQuery="select * from "+TABLESoftwareDetails+" where "+COLsid+"="+"?";
		try {
			pst = connection.prepareStatement(sqlQuery);
			pst.setInt(1, sid);
			pst.executeQuery();
			ResultSet rs=pst.getResultSet();

			while(rs.next())
			{
				sid=rs.getInt(COLsid);
				int SoftwareSrNo=rs.getInt(COLSoftwareSrNo);
				String SoftwareName=rs.getString(COLSoftwareName);
				String SoftwareManufacture=rs.getString(COLSoftwareManufacture);
				int SoftwarePrice=rs.getInt(COLSoftwarePrice);
				int SoftwareQuantity=rs.getInt(COLSoftwareQuantity);
				
				int SoftwareDiscount=rs.getInt(COLSoftwareDiscount);
				
				softwareDetails=new SoftwareDetails(SoftwareSrNo, SoftwarePrice, SoftwareQuantity, SoftwareDiscount, new SoftwareDaoImpl().getSoftware(sid), SoftwareName, SoftwareManufacture);
				
				allSoftwareDetailsList.add(softwareDetails);
			}
			
			return  allSoftwareDetailsList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	public void addSoftwareDetails(SoftwareDetails softwareDetails) {
		try {
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
			allSoftwareDetailsList.add(softwareDetails);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteSoftwareDetails(SoftwareDetails softwareDetails) {
		try {
			Connection connection=DBConnection.getConnection();
			String sqlQuery="delete from "+TABLESoftwareDetails+" where "+COLSoftwareSrNo+"=?";
			pst = connection.prepareStatement(sqlQuery);
			
			//pst.setInt(1,softwareDetails.getSoftware().getSid());
			pst.setInt(1,softwareDetails.getSoftwareSrNo());
			pst.executeUpdate();
			
			allSoftwareDetailsList.remove(softwareDetails);
			
//			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void updateSoftwareDetails(SoftwareDetails softwareDetails)
	{
		try {
			int software_SRNo=softwareDetails.getSoftwareSrNo();
			Connection connection=DBConnection.getConnection();
			String sqlQuery="update "+TABLESoftwareDetails+" set "+COLSoftwareQuantity+" =? ,"+COLSoftwarePrice+" =? , "+COLSoftwareDiscount+" =? "+" where "+COLSoftwareSrNo+"= "+software_SRNo;
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
	@Override
	public List<Software> getSoftwareDetailsWithList(int sid) {
		
		allSoftwareDetailsList=new ArrayList<SoftwareDetails>();
		List <Software> softwareList=new ArrayList<Software>();
		sqlQuery="select * from "+TABLESoftwareDetails+" where "+COLsid+"="+"?";
		try {
			pst = connection.prepareStatement(sqlQuery);
			pst.setInt(1, sid);
			pst.executeQuery();
			ResultSet rs=pst.getResultSet();

			
			while(rs.next())
			{
				sid=rs.getInt(COLsid);
				int SoftwareSrNo=rs.getInt(COLSoftwareSrNo);
				String SoftwareName=rs.getString(COLSoftwareName);
				String SoftwareManufacture=rs.getString(COLSoftwareManufacture);
				int SoftwarePrice=rs.getInt(COLSoftwarePrice);
				int SoftwareQuantity=rs.getInt(COLSoftwareQuantity);
				int SoftwareDiscount=rs.getInt(COLSoftwareDiscount);

				softwareDetails=new SoftwareDetails(SoftwareSrNo, SoftwarePrice, SoftwareQuantity, SoftwareDiscount, new SoftwareDaoImpl().getSoftware(sid), SoftwareName, SoftwareManufacture);
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
