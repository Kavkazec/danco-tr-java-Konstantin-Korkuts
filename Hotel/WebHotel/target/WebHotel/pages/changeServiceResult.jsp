<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/main/index.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/ccss/MainPageStyle.css">
<title>Change service</title>
</head>
<body>
	<center>
		<form action="ChangeServiceResultServlet" method="post"
			class="form_from_content" style="height: 634px">
			<input type="text" name="id" value="${serviceEntity.getId()}"
				disabled /> </br> <input type="text" name="name"
				value="${serviceEntity.getName()}" disabled /> </br> <input type="text"
				name="coast" required placeholder="Input coast" /> </br> <input
				type="text" name="type" value="${serviceEntity.getType()}" disabled />
			</br> <input type="text" name="settlement"
				value="${serviceEntity.getSettlement().getId()}" disabled /> </br> <input
				type="text" name="date" value="${serviceEntity.getDate()}" disabled />
			</br> <input type="submit" name="logon" class="login-button"
				value="Change" />
		</form>
	</center>
</body>
</html>