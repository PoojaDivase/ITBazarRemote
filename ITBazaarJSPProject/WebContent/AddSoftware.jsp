<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AddSoftware</title>
</head>
<body>
<center>
<h1>Add Software</h1>
<hr />
<form action="AdminAddSoftware" method="post">
Software Sr.No : <input type="text" name="softwareSrNo"/><br><br>
SoftwareName : <input type="text" name="softwareName"/><br><br>
SoftwarePrice : <input type="text" name="softwarePrice"/><br><br>
SoftwareQuantity : <input type="text" name="softwareQuantity"/><br><br>
SoftwareManufacture : <input type="text" name="softwareManufacture"/><br><br>
SoftwareDiscount : <input type="text" name="softwareDiscount"/><br><br>
Software Id : <input type="text" name="software_Id"/><br><br>
<input type="submit" name="Add" value="Add"/><br>
</form>
<form method="post" action="Admin.jsp">
<input type="submit" name="Back" value="Back" /> <br> <br></form>
</center>

</body>
</html>