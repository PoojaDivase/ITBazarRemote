<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Hardware</title>
</head>
<body>
<center>
<h1>Update Hardware</h1>
<hr />
<form action="AdminUpdateHardware" method="post">
Hardware Sr.No : <input type="text" name="hardwareSrNo" /> <br><br>
Hardware Price : <input type="text" name="hardwarePrice" /> <br><br>
Hardware Quantity : <input type="text" name="hardwareQuantity" /><br><br>
Hardware Discount : <input type="text" name="hardwareDiscount" /> <br><br>
<input type="submit" name="Update" value="Update" />
</form>
<form action="Admin.jsp" method="post">
<input type="submit" value="Back" name="Back"/>
</form>
</center>
</body>
</html>