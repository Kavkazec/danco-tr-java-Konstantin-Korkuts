<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/main/index.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/MainPageStyle.css">
<title>Show rooms</title>
</head>
<body>
	<center>
		<form class="form_from_content" style="height: 634px">
			<c:if test="${not empty rooms}">
				<c:forEach items="${rooms}" var="room">
					<p>
						<c:out value="${room.getId()}" />
						<c:out value="${room.getType()}" />
						<c:out value="${room.getNumber()}" />
						<c:out value="${room.getCapacity()}" />
						<c:out value="${room.getNumberOfStars()}" />
						<c:out value="${room.getCoast()}" />
						<c:out value="${room.isFreeRoom()}" />
						<c:out value="${room.isOnRepair()}" />
					</p>
				</c:forEach>
			</c:if>
			<c:if test="${empty rooms}">
				<h3>Empty or null</h3>
			</c:if>
		</form>
	</center>
</body>
</html>