<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.danco.training.entity.User" %>
     <%@ page import="com.danco.training.entity.Guest" %>
    <%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="../css/MainPageStyle.css">
<title>Show guests</title>
</head>
<body>
	<form class="hdr" action="../Logout" method="get">
		<span>H</span><span>O</span>
		<div><span>T</span><span>E</span><span>L</span></div>
		<% User user = (User) session.getAttribute("user");%>
		<label>You are logged in as:</label><label class="nik"><%=user.getLogin()%></label>
		<input type="submit" class="logout "value="Logout" />	
	</form>
	<nav>
		<ul class="menu">
		  <li><a href="../main/MainPage.jsp">Main</a></li>
		   <li><a>Rooms</a>
			<ul class="submenu">
			 <form action="../rooms/addRoomPage.jsp" method="post"><input type="submit" class="menu-input" value="Add room" /></form>
			 <form action="../rooms/showRoomsPage.jsp" method="post"><input type="submit" class="menu-input" value="Show rooms" /></form>
			 <form action="../rooms/deleteRoomPage.jsp" method="post"><input type="submit" class="menu-input" value="Delete room" /></form>
			 <form action="../rooms/sortedRoomsPage.jsp" method="post"><input type="submit" class="menu-input" value="Sorted rooms" /></form>
			 <form action="../rooms/freeRoomsCountPage.jsp" method="post"><input type="submit" class="menu-input" value="Free rooms count" /></form>
			 <form action="../rooms/cloneRoomPage.jsp" method="post"><input type="submit" class="menu-input" value="Clone room" /></form>
			 <form action="../rooms/importExportRoomPage.jsp" method="post"><input type="submit" class="menu-input" value="Import/export room" /></form>
			 <form action="../rooms/changeRoomPage.jsp" method="post"><input type="submit" class="menu-input" value="Change room" /></form>
			 <form action="../rooms/showRoomsDetailsPage.jsp" method="post"><input type="submit" class="menu-input" value="Show room's details" /></form>
			</ul>
		  </li>
		  <li><a>Services</a>
			<ul class="submenu">
			 <form action="../services/addServicePage.jsp" method="post"><input type="submit" class="menu-input" value="Add service" /></form>
			 <form action="../services/showServicesPage.jsp" method="post"><input type="submit" class="menu-input" value="Show services" /></form>
			 <form action="../services/deleteServicePage.jsp" method="post"><input type="submit" class="menu-input" value="Delete service" /></form>
			 <form action="../services/importExportServicePage.jsp" method="post"><input type="submit" class="menu-input" value="Import/export services" /></form>
			 <form action="../services/changeServicePage.jsp" method="post"><input type="submit" class="menu-input" value="Change service" /></form>
			</ul>
		  </li>
		  <li><a>Guests</a>
			<ul class="submenu">
			 <form action="addGuestPage.jsp" method="post"><input type="submit" class="menu-input" value="Add guest" /></form>
			 <form action="showGuestsPage.jsp" method="post"><input type="submit" class="menu-input" value="Show guests" /></form>
			 <form action="deleteGuestPage.jsp" method="post"><input type="submit" class="menu-input" value="Delete guest" /></form>
			 <form action="importExportGuestPage.jsp" method="post"><input type="submit" class="menu-input" value="Import/export guests" /></form>
			 <form action="countGuestsPage.jsp" method="post"><input type="submit" class="menu-input" value="Count guests" /></form>
			</ul>
		  </li>
		   <li><a>Settlement</a>
			<ul class="submenu">
			 <form action="../settlements/addSettlementPage.jsp" method="post"><input type="submit" class="menu-input" value="New settlement" /></form>
			 <form action="../settlements/showSettlementsPage.jsp" method="post"><input type="submit" class="menu-input" value="Show settlements" /></form>
			 <form action="../settlements/deleteSettlementPage.jsp" method="post"><input type="submit" class="menu-input" value="Delete settlement" /></form>
			 <form action="../settlements/importExportSettlementPage.jsp" method="post"><input type="submit" class="menu-input" value="Import/export settlements" /></form>
			 <form action="../settlements/roomReleasedInPage.jsp" method="post"><input type="submit" class="menu-input" value="Room released in ..." /></form>
			 <form action="../settlements/roomsPaymentPage.jsp" method="post"><input type="submit" class="menu-input" value="Room's payment" /></form>
			 <form action="../settlements/sortingPage.jsp" method="post"><input type="submit" class="menu-input" value="Sorting" /></form>
			 <form action="../settlements/addServiceToGuestPage.jsp" method="post"><input type="submit" class="menu-input" value="Add service to guest" /></form>
			 <form action="../settlements/moveOutFromRoomPage.jsp" method="post"><input type="submit" class="menu-input" value="Move out from room" /></form>
			</ul>
		  </li>
		</ul>
	</nav>
	<center>
		<form action="../ShowGuestsServlet" method="post" class="form_from_content">
			<input type="submit" name="logon" class="login-button" value="Show" />
		</form>
	</center>
</body>
</html>