<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hardware details</title>
</head>
<body>

<center>
<%
if(session.getAttribute("productlist")==null)
{
	response.sendRedirect("Login.jsp");
}
%>

<h1>Hardware Details</h1>
<table border=1>
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
	<tbody>
		<c:forEach var="category" items="${productlist}">
		<tr>
			<td><c:out value="${category.hardwareSrNo} " /></td>
			<td><c:out value="${category.hardwareName} " /></td>
			<td><c:out value="${category.hardwarePrice} " /></td>
			<td><c:out value="${category.hardwareQuantity} " /></td>
			<td><c:out value="${category.hardwareDiscount} " /></td>
			<td><c:out value="${category.hardwareManufacture}" /></td>
			<td><c:out value="${category.color} " /></td>
			
			

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