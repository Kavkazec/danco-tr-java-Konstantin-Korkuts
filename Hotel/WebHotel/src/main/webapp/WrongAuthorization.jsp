<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="css/RegistrationStyle.css">
<title>Authorization</title>
</head>
<body align="center" class="fullbody">
	<div class="container">
			<form action="Authorization" method="get">
				<h1 class="form_name">Authorization</h1>
				<p>Wrong login or password</p>
				<label for="login">Login:</label>
				<input type="text" name="login" required placeholder="Input login" /></br>
				<label for="password">Password:</label>
				<input type="password" name="password" required placeholder="Input password" /></br></br>
				<input type="submit" name="logon" class="login-button" value="Logon" />
			</form>
			<form action="Registration.jsp" method="get">
				<input type="submit" name="registration" class="login-button" value="Registration" />
			</form>
		</div>
</body>
</html>