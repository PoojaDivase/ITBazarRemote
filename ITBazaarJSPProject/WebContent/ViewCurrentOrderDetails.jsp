<%@page import="java.util.List"%>
<%@page import="com.model.Order"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order Details</title>
</head>
<body>
<center>
<h1>Current Details</h1>
<%
if(session.getAttribute("currentorder")==null)
{
	response.sendRedirect("Login.jsp");
}
%>
<table border=1>
	<thead>
	<tr>
		<th> Product_Name </th>
		<th> Ordered_Quantity </th>
		<th> Ordered_Product_SrNo</th>
		<th> Ordered_Date </th>
		<th> Ordered_Actual_Price </th>
		<th> Ordered_Discounted_Price</th>
	
	</tr>
	</thead>
	<tbody>
		<c:forEach var="currentorder" items="${currentorder}">
		<tr>
			
			<td><c:out value="${currentorder.productName} " /></td>
			<td><c:out value="${currentorder.orderedQuantity} " /></td>
			<td><c:out value="${currentorder.orderedProductSrNo} " /></td>
			<td><c:out value="${currentorder.orderDate} " /></td>
			<td><c:out value="${currentorder.actualprice}" /></td>
			<td><c:out value="${currentorder.discountedprice} " /></td>
		</tr>
		</c:forEach>
	</tbody>
</table>
<br>

<form method="post" action="Customer.jsp">
<input type="submit" name="Back" value="Back" /> <br> <br></form>
</center>

</body>
</html>