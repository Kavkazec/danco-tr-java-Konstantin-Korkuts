<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.danco.training.entity.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<form class="hdr" action="Logout" method="post">
		<span>H</span><span>O</span>
		<div><span>T</span><span>E</span><span>L</span></div>
		<label>You are logged in as:</label><label class="nik"><c:out value="${user.getLogin()}" /></label>
		<input type="submit" class="logout "value="Logout" />	
	</form>
	<nav>
		<ul class="menu">
		   <li><a>Rooms</a>
			<ul class="submenu">
			 <form action="${pageContext.servletContext.contextPath}/rooms/addRoomPage.jsp" method="post"><input type="submit" class="menu-input" value="Add room" /></form>
			 <form action="${pageContext.servletContext.contextPath}/rooms/showRoomsPage.jsp" method="post"><input type="submit" class="menu-input" value="Show rooms" /></form>
			 <form action="${pageContext.servletContext.contextPath}/rooms/deleteRoomPage.jsp" method="post"><input type="submit" class="menu-input" value="Delete room" /></form>
			 <form action="${pageContext.servletContext.contextPath}/rooms/sortedRoomsPage.jsp" method="post"><input type="submit" class="menu-input" value="Sorted rooms" /></form>
			 <form action="${pageContext.servletContext.contextPath}/rooms/freeRoomsCountPage.jsp" method="post"><input type="submit" class="menu-input" value="Free rooms count" /></form>
			 <form action="${pageContext.servletContext.contextPath}/rooms/cloneRoomPage.jsp" method="post"><input type="submit" class="menu-input" value="Clone room" /></form>
			 <form action="${pageContext.servletContext.contextPath}/rooms/importExportRoomPage.jsp" method="post"><input type="submit" class="menu-input" value="Import/export room" /></form>
			 <form action="${pageContext.servletContext.contextPath}/rooms/changeRoomPage.jsp" method="post"><input type="submit" class="menu-input" value="Change room" /></form>
			 <form action="${pageContext.servletContext.contextPath}/rooms/showRoomsDetailsPage.jsp" method="post"><input type="submit" class="menu-input" value="Show room's details" /></form>
			</ul>
		  </li>
		  <li><a>Services</a>
			<ul class="submenu">
			 <form action="${pageContext.servletContext.contextPath}/services/addServicePage.jsp" method="post"><input type="submit" class="menu-input" value="Add service" /></form>
			 <form action="${pageContext.servletContext.contextPath}/services/showServicesPage.jsp" method="post"><input type="submit" class="menu-input" value="Show services" /></form>
			 <form action="${pageContext.servletContext.contextPath}/services/deleteServicePage.jsp" method="post"><input type="submit" class="menu-input" value="Delete service" /></form>
			 <form action="${pageContext.servletContext.contextPath}/services/importExportServicePage.jsp" method="post"><input type="submit" class="menu-input" value="Import/export services" /></form>
			 <form action="${pageContext.servletContext.contextPath}/services/changeServicePage.jsp" method="post"><input type="submit" class="menu-input" value="Change service" /></form>
			</ul>
		  </li>
		  <li><a>Guests</a>
			<ul class="submenu">
			 <form action="${pageContext.servletContext.contextPath}/guests/addGuestPage.jsp" method="post"><input type="submit" class="menu-input" value="Add guest" /></form>
			 <form action="${pageContext.servletContext.contextPath}/guests/showGuestsPage.jsp" method="post"><input type="submit" class="menu-input" value="Show guests" /></form>
			 <form action="${pageContext.servletContext.contextPath}/guests/deleteGuestPage.jsp" method="post"><input type="submit" class="menu-input" value="Delete guest" /></form>
			 <form action="${pageContext.servletContext.contextPath}/guests/importExportGuestPage.jsp" method="post"><input type="submit" class="menu-input" value="Import/export guests" /></form>
			 <form action="${pageContext.servletContext.contextPath}/guests/countGuestsPage.jsp" method="post"><input type="submit" class="menu-input" value="Count guests" /></form>
			</ul>
		  </li>
		   <li><a>Settlement</a>
			<ul class="submenu">
			 <form action="${pageContext.servletContext.contextPath}/settlements/addSettlementPage.jsp" method="post"><input type="submit" class="menu-input" value="New settlement" /></form>
			 <form action="${pageContext.servletContext.contextPath}/settlements/showSettlementsPage.jsp" method="post"><input type="submit" class="menu-input" value="Show settlements" /></form>
			 <form action="${pageContext.servletContext.contextPath}/settlements/deleteSettlementPage.jsp" method="post"><input type="submit" class="menu-input" value="Delete settlement" /></form>
			 <form action="${pageContext.servletContext.contextPath}/settlements/importExportSettlementPage.jsp" method="post"><input type="submit" class="menu-input" value="Import/export settlements" /></form>
			 <form action="${pageContext.servletContext.contextPath}/settlements/roomReleasedInPage.jsp" method="post"><input type="submit" class="menu-input" value="Room released in ..." /></form>
			 <form action="${pageContext.servletContext.contextPath}/settlements/roomsPaymentPage.jsp" method="post"><input type="submit" class="menu-input" value="Room's payment" /></form>
			 <form action="${pageContext.servletContext.contextPath}/settlements/sortingPage.jsp" method="post"><input type="submit" class="menu-input" value="Sorting" /></form>
			 <form action="${pageContext.servletContext.contextPath}/settlements/addServiceToGuestPage.jsp" method="post"><input type="submit" class="menu-input" value="Add service to guest" /></form>
			 <form action="${pageContext.servletContext.contextPath}/settlements/moveOutFromRoomPage.jsp" method="post"><input type="submit" class="menu-input" value="Move out from room" /></form>
			</ul>
		  </li>
		</ul>
	</nav>
</body>
</html>