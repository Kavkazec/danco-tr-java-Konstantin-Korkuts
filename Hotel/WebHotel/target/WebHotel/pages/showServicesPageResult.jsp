<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/main/index.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/MainPageStyle.css">
<title>Show services</title>
</head>
<body>
	<center>
		<form class="form_from_content" style="height: 634px">
			<c:if test="${not empty sevices}">
				<c:forEach items="${sevices}" var="sevice">
					<p>
						<c:out value="${sevice.getName() }" />
						<c:out value=" † " />
						<c:out value="${sevice.getCoast()}" />
						<c:out value=" † " />
						<c:out value="${sevice.getType()}" />
						<c:out value=" † " />
						<c:out value="${sevice.getSettlement().getId() }" />
						<c:out value=" † " />
						<c:out value="${sevice.getDate()}" />
					</p>
				</c:forEach>
			</c:if>
			<c:if test="${empty sevices}">
				<h3>Empty or null</h3>
			</c:if>
		</form>
	</center>
</body>
</html>