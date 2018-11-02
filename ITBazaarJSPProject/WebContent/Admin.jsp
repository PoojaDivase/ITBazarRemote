 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Page</title>


</head>
<body
	background="C:\Users\Administrator\Desktop\admin.jpg">
	

	<center>
		

			<br><br><br><br><br><br><br><br><br><br><br><br><br><br>
			
			<form action="HardwareCategory" method="post">
			<legend> Hardware</legend>
			<select  name="hardware">
				<option value="101">Laptop</option>
				<option value="102">Mobile</option>
				<option value="103">Storage Devices</option>
				<option value="104">Desktop</option>
			</select> 
			<input type="submit" value="Search"><br> <br>
			</form>
			
			<form action="SoftwareCategory" method="post">
			<legend>Software</legend>
			<select id="software" name="software">
				<option value="201">Antivirus</option>
				<option value="202">Photoshop</option>
				<option value="203">Testing Softwares</option>
				<option value="204">Ms Office</option>
			</select> 
			<input type="submit" value="Search"><br> <br>
			</form><br>
			
			<form action="AdminSearchProduct" method="post">
			Search a product : <input type="text" name="search" />
			Product Type : <select name="type">
				  <option value="hardware">Hardware</option>
				  <option value="software">Software</option>
				</select> <br><br>
				<input type="submit" name="Search" value="Search" />
			</form>
			<br>

			<form action="AdminShowAllOrders" method="post">
				<input type="submit" value="Show all Orders" name="Show all Orders"/>
			</form></td>
<table>
<tr><td>
			<form action="AdminCheckHardwareStock" method="post">
				<input type="submit" value="Check Hardware Stock" name="Check Hardware Stock"/>
			</form></td>
</td><td>
			<form action="AdminCheckSoftwareStock" method="post">
				<input type="submit" value="Check Software Stock" name="Check Software Stock"/>
			</form>
</td></tr>
<tr><td>
			<form action="AddHardware.jsp" method="post">
				<input type="submit" value="Add Hardware" name="Add_Hardware"/>
			</form></td>
</td><td>
			<form action="AddSoftware.jsp" method="post">
				<input type="submit" value="Add Software" name="Add_Software"/>
			</form>
</td></tr>
<tr><td>
			<form action="UpdateHardware.jsp" method="post">
				<input type="submit" value="Update Hardware" name="Update_Hardware"/>
			</form>
</td><td>
			<form action="UpdateSoftware.jsp" method="post">
				<input type="submit" value="Update Software" name="Update_Software"/>
			</form>
</td></tr>
<tr><td>
			<form action="DeleteHardware.jsp" method="post">
				<input type="submit" value="Delete Hardware" name="Delete_Hardware"/>
			</form>
</td><td>
			<form action="DeleteSoftware.jsp" method="post">
				<input type="submit" value="Delete Software" name="Delete_Software"/>
			</form>
			
</td></tr>
<tr><td>
			<form action="ShowAllHardwares" method="post">
			<input type="submit" value="View All Hardware" name="ViewAllHardware"/>
			</form>
</td><td>
			<form action="ShowAllSoftwares" method="post">
				<input type="submit" value="View All Software" name="ViewAllSoftware"/>
			</form>
</td></tr>
</table>
			<form action="Login.jsp" method="post">
				<input type="submit" value="Logout" />
			</form>		
</center>
</body>


</html>