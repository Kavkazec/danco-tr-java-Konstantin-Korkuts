<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../main/index.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/MainPageStyle.css">
	<title>Add room</title>
</head>
<body>
	<center>
		<form action="../AddRoomServlet" method="post"
			class="form_from_content" style="height: 634px">
			<h2 class="form_name">Add room</h2>
			</br>
			</br>
			</br>
			</br>
			</br>
			</br> <input type="text" name="number" pattern="^[ 0-9]+$" required
				placeholder="Input number" /></br>
			</br> <input type="text" name="capacity" pattern="^[ 0-9]+$" required
				placeholder="Input capacity" /></br>
			</br> <input type="text" name="numberOfStars" pattern="^[ 0-9]+$" required
				placeholder="Input number of stars" /></br>
			</br> <input type="text" name="coast" pattern="^[ 0-9]+$" required
				placeholder="Input coast" /></br>
			</br>
			<legend>On repair?</legend>
			<input type="radio" name="isOnRepair" value="true">Yes</br> <input
				type="radio" name="isOnRepair" value="false">No</br>
			</br> <input type="submit" name="logon" class="login-button" value="Add" />
		</form>
	</center>
</body>
</html>