<%@page import="com.model.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Details</title>
</head>
<body>
<center>
<h1>Customer Details</h1>
<hr />
<%
Customer customer=(Customer) session.getAttribute("customer");
if(session.getAttribute("customer")==null)
{
	 RequestDispatcher requestDispatcher=request.getRequestDispatcher("Login.jsp");
	 requestDispatcher.include(request, response);
}
else
{
%>
<table border="2">
<thead>
	<tr>
		<th> Customer_Id</th>
		<th> Customer_Name </th>
		<th> Customer_Address </th>
		<th> Customer_Email</th>
		<th> Customer_Mobile_No </th>
		<th> Customer_UserID </th>
		<th> Hardware_Password</th>
	</tr>
	</thead>
	<tr>
		<td><%=customer.getCid() %></td>
		<td><%=customer.getCname()%></td>
		<td><%=customer.getCaddress()%></td>
		<td><%=customer.getEmail()%></td>
		<td><%=customer.getMobileNo() %></td>
		<td><%=customer.getUserId() %></td>
		<td><%=customer.getPassword()%></td>
	</tr>
<%
}
%>
</table>
<form method="post" action="Customer.jsp">
<input type="submit" name="Back" value="Back" /> <br> <br></form>

</center>
</body>
</html>