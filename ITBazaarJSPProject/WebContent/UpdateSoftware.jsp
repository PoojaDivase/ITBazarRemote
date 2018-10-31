<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Software</title>
</head>
<body>
<center>
<h1>Update Software</h1>
<hr />
<form action="AdminUpdateSoftware" method="post">
Software Sr.No : <input type="text" name="softwareSrNo" /> <br><br>
Software Price : <input type="text" name="softwarePrice" /> <br><br>
Software Quantity : <input type="text" name="softwareQuantity" /><br> <br>
Software Discount : <input type="text" name="softwareDiscount" /> <br><br>
<input type="submit" name="Update" value="Update" />
</form>
	<form action="Admin.jsp" method="post">
		<input type="submit" value="Back" name="Back"/>
	</form>
</center>
</body>
</html>