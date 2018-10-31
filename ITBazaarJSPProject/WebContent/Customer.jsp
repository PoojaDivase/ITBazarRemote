<%@page import="com.dao.CustomerDao"%>
<%@page import="com.model.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Page</title>
</head>
<body background="C:\Users\Administrator\Desktop\Final Project\cu.jpg">

<center>
<%
Customer customer=(Customer) session.getAttribute("customer");
int cid = customer.getCid();
if(session==null)
{
	 RequestDispatcher requestDispatcher=request.getRequestDispatcher("Login.jsp");
	 requestDispatcher.include(request, response);
}
else
{
%>
<br><br><br><br><br><br><br><br><br>
<table border=1>
		<tr><td> Customer Cid : </td><td><%=customer.getCid()%></td></tr>
		<tr><td> Customer Name :</td><td><%=customer.getCname() %></td></tr>
		<tr><td> Customer Mobile : </td><td><%=customer.getMobileNo()%></td></tr>
		<tr><td> Customer Email :</td><td><%=customer.getEmail() %></td></tr>
	</table>


<h3>"You are logged in  Successfully"</h3>

		<form action="CustomerSearchProduct" method="post">
			Search a product : <input type="text" name="search" />
			Product Type : <select name="type">
				  <option value="hardware">Hardware</option>
				  <option value="software">Software</option>
				</select> <br><br>
				<input type="submit" name="Search" value="Search" />
		</form>
<br>

<form action="View My Details">
<input type="submit" value="View My Details"></form>

<br>
<form action="PlaceOrder.jsp">
<input type="submit" value="Place Order"></form>
<br>

<form action="ViewMyOrders.jsp">
<input type="submit" value="View My Orders"></form>

<br>

<form method="post" action="Login.jsp">
<input type="submit" name="Logout" value="Logout" /> <br> <br></form>


<br>
<br>
<%
}
%>
</center>
</body>
</html>