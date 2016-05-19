<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/main/index.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="text/css" href="${pageContext.servletContext.contextPath}/css/MainPageStyle.css">
<title>Delete guest</title>
</head>
<body>
	<center>
		<form action="DeleteGuestResultServlet" method="post"
			class="form_from_content" style="height: 634px">
			<p>
				<select size="${size}" name="select_guest" required>
					<option disabled>Select guest:</option>
					<c:forEach var="guest" items="${guests}">
						<option value="${guest.getId()}">${guest.getName()}
							${guest.getPassportSeries()} ${guest.getPassportNumber()}</option>
					</c:forEach>
				</select>
			</p>
			<input type="submit" name="logon" class="login-button" value="Delete" />
		</form>
	</center>
</body>
</html>