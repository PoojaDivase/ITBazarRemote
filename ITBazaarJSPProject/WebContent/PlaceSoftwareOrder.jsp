<%@page import="java.util.ArrayList"%>
<%@page import="com.model.SoftwareDetails"%>
<%@page import="java.util.List"%>
<%@page import="com.service.SoftwareDetailsServiceImpl"%>
<%@page import="com.service.SoftwareDetailsService"%>
<%@page import="com.model.Customer"%>
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
<h1>Place Software Order</h1>
<hr />
<%
Customer customer=(Customer) session.getAttribute("customer");
if(session.getAttribute("customer")==null)
{
	 /* RequestDispatcher requestDispatcher=request.getRequestDispatcher("Login.jsp");
	 requestDispatcher.forward(request, response); */
	response.sendRedirect("Login.jsp");
}
else
{
%>
<form method="get" action="CustomerPlaceSoftwareOrder">
<table border="2">
<thead>
	<tr>
		<th> Software_Sr.No</th>
		<th> Software_Name </th>
		<th> Software_Price </th>
		<th> Software_Discount </th>
		<th> Software_Company </th>
		<th> Select</th>
		<th> select quantity</th>
	</tr>
	</thead>
<% 
SoftwareDetailsService softwareDetailsService= new SoftwareDetailsServiceImpl();
List<SoftwareDetails> allsoftwarelist=new ArrayList<SoftwareDetails>();
allsoftwarelist=softwareDetailsService.getAllSoftware();
for(int i=0;i<allsoftwarelist.size();i++)
{
%>
<tr>
	<td><%=allsoftwarelist.get(i).getSoftwareSrNo() %></td>
	<td><%=allsoftwarelist.get(i).getSoftwareName() %></td>
	<td><%=allsoftwarelist.get(i).getSoftwarePrice() %></td>
	<td><%=allsoftwarelist.get(i).getSoftwareDiscount() %></td>
	<td><%=allsoftwarelist.get(i).getSoftwareManufacture() %></td>
	<th><input type="checkbox" name="checkboxGroup" value="<%=allsoftwarelist.get(i).getSoftwareSrNo() %>"/></th>
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