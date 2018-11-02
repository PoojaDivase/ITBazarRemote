<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>
<center>
<h3> Please Fill The Details </h3>
<fieldset>

<form method= "post" action="Registration">
 	Name    :<input type="text" name= "name" /><br><br>
 	Address :<input type="text" name= "address" /><br><br>
 	Email   :<input  type="text" name= "email" /><br><br>
 	Mobile No.:<input type="text" name="mobileNo" /><br><br>
 	UserId :<input type="text" name="userId" /><br><br>
 	Password<input type="text" name= "password" /><br><br>
 	<input type="submit"  value ="submit" >
</form>
 
<form method="post" action="Login.jsp">
<input type="submit" name="Back" value="Back" /> <br> <br></form>
</fieldset>
<% String message = (String)request.getAttribute("alertMsg");%>
<script type="text/javascript">
    var msg = "<%=message%>";
    alert(msg);
</script>
</center>
</body>
</html>