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

public class HardwareDaoImpl implements HardwareDao {

	private static List<Hardware>allHardwareList=new ArrayList<Hardware>();
	Hardware hardware; //creating the object of Hardware
	PreparedStatement pst; //creating the object of PreparedStatement
	Connection connection=DBConnection.getConnection(); //establishing the connection
	ResultSet rs; //object of ResultSet
	String sqlQuery; //Declaration of the sqlQuery variable as String

	
	//this function is to get the type of particular hardware using its id
	@Override
	public Hardware getHardware(int hid) {
		// TODO Auto-generated method stub
		try {
			Hardware item=new Hardware();
			item.setHid(hid);
			
			if(allHardwareList.contains(item))
			{
				
			int index=allHardwareList.indexOf(item);
			return allHardwareList.get(index);
			}
			sqlQuery="select * from "+TABLEhardware+" where "+COLhid+"="+"?";
			
			pst=connection.prepareStatement(sqlQuery);
			pst.setInt(1, hid);
			pst.executeQuery();
			rs=pst.getResultSet();
			
			if(rs.next()==false)
			{
				return null;
			}
			
			String hcategory=rs.getString(COLhcategory);
			hardware=new Hardware(hid, hcategory);
			allHardwareList.add(hardware);
			return hardware;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		return null;
	}

	//this function is used for getting all the elements from the hardware table
	@Override
	public List<Hardware> getAllHardwares() {
		// TODO Auto-generated method stub
		allHardwareList=new ArrayList<Hardware>();
		try {
			sqlQuery="select * from "+TABLEhardware;
			
			pst=connection.prepareStatement(sqlQuery);
			
			pst.executeQuery();
			rs=pst.getResultSet();
			
			while(rs.next())
			{
				int hid=rs.getInt(COLhid);
				String hcategory=rs.getString(COLhcategory);
				hardware=new Hardware(hid,hcategory);
				allHardwareList.add(hardware);
				
			}
			return  allHardwareList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	//this function is used to add any category
	@Override
	public void addHardware(Hardware hardware) throws HardwareExistsException {
		try {
			sqlQuery="insert into "+TABLEhardware+" values(?,?)";
			pst = connection.prepareStatement(sqlQuery);
			pst.setInt(1,hardware.getHid());
			pst.setString(2,hardware.getHcategory());
			pst.executeUpdate();
			allHardwareList.add(hardware);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	//this function is used to update the category of the hardware by using its hid
	@Override
	public void updateHardware(Hardware hardware) {
		// TODO Auto-generated method stub
		try {
			sqlQuery="update "+TABLEhardware+" set "+COLhcategory+"=?"+" where "+COLhid+"=?";
			pst = connection.prepareStatement(sqlQuery);
			
			pst.setString(1, hardware.getHcategory());
			pst.setInt(2,hardware.getHid());
			pst.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	//this function is used to delete the category of the hardware by using its hid
	@Override
	public void deleteHardware(Hardware hardware) {
		try {
			sqlQuery="delete from "+TABLEhardware+" where "+COLhid+"=?";
			pst = connection.prepareStatement(sqlQuery);
			
			pst.setInt(1,hardware.getHid());
			 
			pst.executeUpdate();
			
			allHardwareList.remove(hardware);
			
//			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	}
