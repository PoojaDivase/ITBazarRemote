<%@page import="com.service.HardwareDetailsServiceImpl"%>
<%@page import="com.service.HardwareDetailsService"%>
<%@page import="com.model.HardwareDetails"%>

<%@page import="com.service.SoftwareDetailsServiceImpl"%>
<%@page import="com.service.SoftwareDetailsService"%>
<%@page import="com.model.SoftwareDetails"%>


<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Offers</title>
</head>
<body>
<center>

<form action="OfferDiscountServlet" method="post">
<table border="2">
<thead>
<tr>
	
	<th> Hardware_Sr.No</th>
		<th> Hardware_Name </th>
		<th> Hardware_Price </th>
		<th> Hardware_Quantity</th>
		<th> Hardware_Discount </th>
		<th> Hardware_Company </th>
		<th> Hardware_Color</th>
		<th> Select</th>
		
		
	</tr>
	</thead>
	
	
	<%
	HardwareDetailsService hardwareDetailsService= new HardwareDetailsServiceImpl();
	List<HardwareDetails> allhardwarelist=new ArrayList<HardwareDetails>();
	allhardwarelist=hardwareDetailsService.getAllHardwareDetails();
	//allhardwarelist=hardwareDetailsService.getAllHardwareDetailsForParticularType(101);
	
	
	for(int i=0;i<allhardwarelist.size();i++)
	{
	%>
	<tr>
		 <td><%=allhardwarelist.get(i).getHardwareSrNo() %></td> 
		<td><%=allhardwarelist.get(i).getHardwareName() %></td>
		 <td><%=allhardwarelist.get(i).getHardwarePrice() %></td>
		<td><%=allhardwarelist.get(i).getHardwareQuantity() %></td>
		<td><%=allhardwarelist.get(i).getHardwareDiscount() %></td>
		<td><%=allhardwarelist.get(i).getHardwareManufacture() %></td>
		<td><%=allhardwarelist.get(i).getColor()%></td> 
		<th><input type="checkbox" name="checkboxGroupForHardware" value="<%=allhardwarelist.get(i).getHardwareSrNo() %>"/></th>
		 
				
					
	</tr>
	<%
	}
	%>


	
	</table>
	
<br>
<br>	
<br>
<br>	
		
	
	<table border="2">
<thead>
<tr>
	
	<th> Software_Sr.No</th>
		<th> Software_Name </th>
		<th> Software_Price </th>
		<th> Software_Quantity</th>
		<th> Software_Discount </th>
		<th> Software_Company </th>
		<th> Select</th>
		
		
	</tr>
	</thead>
	
	
	<%
	SoftwareDetailsService softwareDetailsService= new SoftwareDetailsServiceImpl();
	List<SoftwareDetails> allsoftwarelist=new ArrayList<SoftwareDetails>();
	allsoftwarelist=softwareDetailsService.getAllSoftware();
	//allhardwarelist=hardwareDetailsService.getAllHardwareDetailsForParticularType(101);
	
	
	for(int i=0;i<allsoftwarelist.size();i++)
	{
	%>
	<tr>
		 <td><%=allsoftwarelist.get(i).getSoftwareSrNo() %></td> 
		<td><%=allsoftwarelist.get(i).getSoftwareName() %></td>
		 <td><%=allsoftwarelist.get(i).getSoftwarePrice() %></td>
		<td><%=allsoftwarelist.get(i).getSoftwareQuantity() %></td>
		<td><%=allsoftwarelist.get(i).getSoftwareDiscount() %></td>
		<td><%=allsoftwarelist.get(i).getSoftwareManufacture() %></td>
		 
		<th><input type="checkbox" name="checkboxGroupForSoftware" value="<%=allsoftwarelist.get(i).getSoftwareSrNo() %>"/></th>
		 
				
					
	</tr>
	<%
	}
	%>
		
	</table>

<br>
<input type="submit"  value="GiveOrders" />

</form>



</center>



</body>
</html>