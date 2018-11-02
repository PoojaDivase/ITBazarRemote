<%@page import="com.model.Customer"%>
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
<center>
<h1>Place Hardware Order</h1>
<hr />
<%
Customer customer=(Customer) session.getAttribute("customer");
if(session.getAttribute("customer")==null)
{
	 //RequestDispatcher requestDispatcher=request.getRequestDispatcher("Login.jsp");
	 //requestDispatcher.include(request, response);
	response.sendRedirect("Login.jsp");
}
else
{
%>
<form method="get" action="CustomerPlacedOrder">
<table border="2">
<thead>
	<tr>
		<th> Hardware_Sr.No</th>
		<th> Hardware_Name </th>
		<th> Hardware_Price </th>
		<th> Hardware_Discount </th>
		<th> Hardware_Company </th>
		<th> Hardware_Color</th>
		<th> Select</th>
		<th> select quantity</th>
	</tr>
	</thead>
<% 
HardwareDetailsService hardwareDetailsService= new HardwareDetailsServiceImpl();
List<HardwareDetails> allhardwarelist=new ArrayList<HardwareDetails>();
allhardwarelist=hardwareDetailsService.getAllHardwareDetails();
for(int i=0;i<allhardwarelist.size();i++)
{
%>
<tr>
	<td><%=allhardwarelist.get(i).getHardwareSrNo() %></td>
	<td><%=allhardwarelist.get(i).getHardwareName() %></td>
	<td><%=allhardwarelist.get(i).getHardwarePrice() %></td>
	<td><%=allhardwarelist.get(i).getHardwareDiscount() %></td>
	<td><%=allhardwarelist.get(i).getHardwareManufacture() %></td>
	<td><%=allhardwarelist.get(i).getColor()%></td>
	<th><input type="checkbox" name="checkboxGroup" value="<%=allhardwarelist.get(i).getHardwareSrNo() %>"/></th>
	 <%
			String quantity="quantity";
			String value=Integer.toString(i);
			String quantity1;
			quantity1=quantity+value;%>
	<td><select name="quantity1" + onchange="">
	<option selected="true" disabled="disabled"> </option> 
	
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="10">10</option>
				<option value="20">20</option>
				<option value="50">50</option>
				</select>  <td>   
	
				
</tr>
<%
}
%>
</table>
<br>
<input type="submit"  value="GiveOrders" />
</form>
<form method="post" action="Customer.jsp">
<input type="submit" name="Back" value="Back" /> <br> <br></form>
<%
}
%>
</center>
</body>
</html>