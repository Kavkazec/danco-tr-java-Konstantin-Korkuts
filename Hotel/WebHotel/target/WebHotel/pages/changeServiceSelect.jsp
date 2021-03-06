<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/main/index.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/MainPageStyle.css">
	<title>Change service</title>
</head>
<body>
	<center>
		<form action="ChangeServiceSelectServlet" method="get"
			class="form_from_content" style="height: 634px">
			<p>
				<select size="${size}" name="select_service" required>
					<option disabled>Select service:</option>
					<c:forEach var="service" items="${services}">
						<option value="${service.getId()}">${service.getName() }
							${service.getCoast()} ${service.getType()}
							${service.getSettlement().getId() } ${service.getDate()}</option>
					</c:forEach>
				</select>
			</p>
			<input type="text" name="serviceID" value="${myName}" disabled /> <input
				type="submit" name="logon" class="login-button" value="Select" />
		</form>
	</center>
</body>
</html>