<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/RegistrationStyle.css">
<title>Registration</title>
</head>
<body align="center" class="fullbody">
	<div class="container">
		<center>
			<form action="Registration" method="post">
				<h1 class="form_name">Registration</h1>
				<label for="login">Login:</label> <input type="text" name="login"
					required placeholder="Input login" /></br> <label for="password">Password:</label>
				<input type="password" name="password" required
					placeholder="Input password" /></br> <label for="password">Repeat
					password:</label> <input type="password" name="re_password" required
					placeholder="Repeat password" /></br>
				</br> <input type="submit" name="registration" class="login-button"
					value="Registration" />
			</form>
			<form action="Authorization.jsp" method="get">
				<input type="submit" name="logon" class="login-button" value="Logon" />
			</form>
		</center>
	</div>
</body>
</html>