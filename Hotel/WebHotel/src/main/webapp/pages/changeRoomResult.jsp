<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/main/index.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="text/css" href="${pageContext.servletContext.contextPath}/css/MainPageStyle.css">
<title>Change room</title>
</head>
<body>
	<center>
		<form action="ChangeRoomResultServlet" method="post"
			class="form_from_content" style="height: 634px">
			<c:if test="${not empty room}">
					<input type="text" name="id" value="${room.getId()}"  />
					</br>
					<input type="text" name="type" value="${room.getType()}" disabled />
					</br>
					<input type="text" name="number" value="${room.getNumber()}"
						disabled />
					</br>
					<input type="text" name="capacity" value="${room.getCapacity()}"
						disabled />
					</br>
					<input type="text" name="numberOfStars"
						value="${room.getNumberOfStars()}" disabled />
					</br>
					<c:if test="${criterion eq 'coast'}">
						<input type="text" name="coast" required placeholder="Input coast" />
						</br>
					</c:if>
					<c:if test="${criterion ne 'coast'}">
						<input type="text" name="coast" value="${room.getCoast()}"
							disabled />
						</br>
					</c:if>
					<c:if test="${criterion eq 'isOnRepair'}">
						<input type="text" name="isOnRepair" required
							placeholder="Input true or false" />
						</br>
					</c:if>
					<c:if test="${criterion ne 'isOnRepair'}">
						<input type="text" name="isOnRepair" value="${room.isFreeRoom()}"
							disabled />
						</br>
					</c:if>
					<input type="text" name="isOnRepair" value="${room.isOnRepair()}"
						disabled />
					</br>
			</c:if>
			<c:if test="${empty room}">
				<h3>Empty or null</h3>
			</c:if>
			<input type="submit" name="logon" class="login-button" value="Change" />
		</form>
	</center>
</body>
</html>