<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../main/index.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/ccss/MainPageStyle.css">
	<title>Add guest</title>
</head>
<body>
	<center>
		<form action="../AddGuestServlet" method="post" class="form_from_content" style="height: 634px">
			<h2 class="form_name">Add guest</h2>
			</br>
			</br>
			</br>
			</br>
			</br>
			</br> <input type="text" name="name" required placeholder="Input name" /></br>
			<input type="text" name="passportSeries" required
				placeholder="Input passport series" /></br> <input type="text"
				name="passportNumber" pattern="^[ 0-9]+$" required
				placeholder="Input passport number" /></br>
			</br> <input type="submit" name="logon" class="login-button" value="Add" />
		</form>
	</center>
</body>
</html>