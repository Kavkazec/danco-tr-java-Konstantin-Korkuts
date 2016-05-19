<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../main/index.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/MainPageStyle.css">
	<title>IE guests</title>
</head>
<body>
	<center>
		<form action="../SortedRoomServlet" method="get"
			class="form_from_content" style="height: 634px">
			<h2 class="form_name">Sort room:</h2>
			</br>
			</br>
			</br>
			<legend>Which rooms?</legend>
			<input type="radio" name="rooms" value="Free">Free</br> <input
				type="radio" name="rooms" value="All">All</br>
			<legend>Sorted by:</legend>
			<input type="radio" name="sort" value="coast">coast</br> <input
				type="radio" name="sort" value="capacity">capasity</br> <input
				type="radio" name="sort" value="numberOfStars">stars</br>
			</br> <input type="submit" name="logon" class="login-button" value="Sort" />
		</form>
	</center>
</body>
</html>