package com.service;

import java.util.List;

import com.model.HardwareDetails;
import com.model.SoftwareDetails;

public class main {

	public static void main(String args[])
	{
		AdminOperationsServiceImpl admin=new AdminOperationsServiceImpl();
		HardwareDetails details=admin.SearchHardwareByName("Sandisk 4gb");
		System.out.println("*******************************");
		System.out.println(details);
		System.out.println("*******************************");
		SoftwareDetails details1=admin.SearchSoftwareByName("NPAV Antivirus");
		System.out.println("*******************************");
		System.out.println(details1);
			
		System.out.println("************Sorting hardware list***********");

		 List<HardwareDetails> list=admin.SortByHardwareName(101);
		for(HardwareDetails sortedList:list)
		{
			System.out.println(sortedList);
		}
	
		System.out.println("************Sorting software list***********");
		// list=new ArrayList<HardwareDetails>();
		 List<SoftwareDetails> list1=admin.SortBySoftwareName(201);
		for(SoftwareDetails sortedList:list1)
		{
			System.out.println(sortedList);
		}
		
		
	}
}
