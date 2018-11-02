<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body background="C:\Users\Administrator\Desktop\cart.jpg">
<center>
<h1>Welcome To IT Bazaar</h1>
<hr />
<fieldset>
<form method="post" action="LoginCheker">
User Id <input type="text" name="userId" /> <br> <br>
Password <input type="password" name="password" /> <br> <br>
User Type : <select name="type">
  <option value="admin">Admin</option>
  <option value="customer">Customer</option>
</select> <br><br>
<input type="submit" value="Login">
</form>
<form action="Register.jsp">
<input type="submit" value="Register">
</form>
</center>
</fieldset>
</body>
</html>