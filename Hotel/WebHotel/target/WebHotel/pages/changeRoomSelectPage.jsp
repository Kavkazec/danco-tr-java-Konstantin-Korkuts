<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/main/index.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/MainPageStyle.css">
	<title>Change room</title>
</head>
<body>
		<form action="ChangeRoomSelectServlet" method="post"
			class="form_from_content" style="height: 634px">
			<legend>Select criterion:</legend>
			<input type="radio" name="criterion" value="coast">Coast</br> <input
				type="radio" name="criterion" value="isOnRepair">On repair</br>
			<p>
				<select size="${size}" name="select_room" required>
					<option disabled>Select room:</option>
					<c:forEach var="room" items="${rooms}">
						<option value="${room.getId()}">${room.getType()}
							${room.getNumber()} ${room.getCapacity()}
							${room.getNumberOfStars()} ${room.getCoast()}
							${room.isFreeRoom()} ${room.isOnRepair()}</option>
					</c:forEach>
				</select>
			</p>
			<input type="submit" name="logon" class="login-button" value="Select" />
		</form>
	</center>
</body>
</html>