<%@page import="com.model.HardwareDetails"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.service.HardwareDetailsServiceImpl"%>
<%@page import="com.service.HardwareDetailsService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Place Order</title>
</head>
<body>

<form method="get" action="CustomerPlacedOrder">
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
	</tr>
	</thead>
<% 
HardwareDetailsService hardwareDetailsService= new HardwareDetailsServiceImpl();
List<HardwareDetails> allhardwarelist=new ArrayList<HardwareDetails>();
allhardwarelist=hardwareDetailsService.getAllHardwareDetails();
for(HardwareDetails hardware:allhardwarelist)
{
%>
<tr>
	<td><%=hardware.getHardwareSrNo() %></td>
	<td><%=hardware.getHardwareName() %></td>
	<td><%=hardware.getHardwarePrice() %></td>
	<td><%=hardware.getHardwareQuantity() %></td>
	<td><%=hardware.getHardwareDiscount() %></td>
	<td><%=hardware.getHardwareManufacture() %></td>
	<td><%=hardware.getColor()%></td>
	<th><input type="checkbox" name="checkboxGroup" value="<%=hardware.getHardwareSrNo() %>"/></th>
	<th><input type="dropdown" name="dropdownGroup" <select name="type">
				  <option value="1">1</option>
				  <option value="2">2</option>
				  <option value="3">3</option>
				  <option value="4">4</option>
				  <option value="5">5</option>
				</select> /></th>
</tr>
<%
}
%>
</table>
<input type="submit"  value="GiveOrders " />

</form>
</body>
</html>