<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Software Details</title>
</head>
<body>
<center>
<%
if(session.getAttribute("productlist")==null)
{
	response.sendRedirect("Admin.jsp");
}
%>
<h1>Software Details</h1>
<table border=1>
	<thead>
	<tr>
		<th> Software_Sr.No</th>
		<th> Software_Name </th>
		<th> Software_Price </th>
		<th> Software_Quantity</th>
		<th> Software_Discount </th>
		<th> Software_Company </th>
		
		
		
	</tr>
	</thead>
	<tbody>
		<c:forEach var="category" items="${productlist}">
		<tr>
			<td><c:out value="${category.softwareSrNo} " /></td>
			<td><c:out value="${category.softwareName} " /></td>
			<td><c:out value="${category.softwarePrice} " /></td>
			<td><c:out value="${category.softwareQuantity} " /></td>
			<td><c:out value="${category.softwareDiscount} " /></td>
			<td><c:out value="${category.softwareManufacture}" /></td>
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