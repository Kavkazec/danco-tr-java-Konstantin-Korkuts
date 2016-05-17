<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.danco.training.entity.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="../css/MainPageStyle.css">
<title>Add room</title>
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
		  <li><a href="../MainPage.jsp">Main</a></li>
		   <li><a>Rooms</a>
			<ul class="submenu">
			 <form action="addRoomPage.jsp" method="post"><input type="submit" class="menu-input" value="Add room" /></form>
			 <form action="showRoomsPage.jsp" method="post"><input type="submit" class="menu-input" value="Show rooms" /></form>
			 <form action="deleteRoomPage.jsp" method="post"><input type="submit" class="menu-input" value="Delete room" /></form>
			 <form action="sortedRoomsPage.jsp" method="post"><input type="submit" class="menu-input" value="Sorted rooms" /></form>
			 <form action="freeRoomsCountPage.jsp" method="post"><input type="submit" class="menu-input" value="Free rooms count" /></form>
			 <form action="cloneRoomPage.jsp" method="post"><input type="submit" class="menu-input" value="Clone room" /></form>
			 <form action="importExportRoomPage.jsp" method="post"><input type="submit" class="menu-input" value="Import/export room" /></form>
			 <form action="changeRoomPage.jsp" method="post"><input type="submit" class="menu-input" value="Change room" /></form>
			 <form action="showRoomsDetailsPage.jsp" method="post"><input type="submit" class="menu-input" value="Show room's details" /></form>
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
			 <form action="../guests/addGuestPage.jsp" method="post"><input type="submit" class="menu-input" value="Add guest" /></form>
			 <form action="../guests/showGuestsPage.jsp" method="post"><input type="submit" class="menu-input" value="Show guests" /></form>
			 <form action="../guests/deleteGuestPage.jsp" method="post"><input type="submit" class="menu-input" value="Delete guest" /></form>
			 <form action="../guests/importExportGuestPage.jsp" method="post"><input type="submit" class="menu-input" value="Import/export guests" /></form>
			 <form action="../guests/countGuestsPage.jsp" method="post"><input type="submit" class="menu-input" value="Count guests" /></form>
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
		<form action="../AddRoomServlet" method="get" class="form_from_content">
			<h2 class="form_name">Add room</h2></br></br></br></br></br></br>
				<input type="text" name="number" pattern="^[ 0-9]+$" required placeholder="Input number" /></br></br>
				<input type="text" name="capacity" pattern="^[ 0-9]+$" required placeholder="Input capacity" /></br></br>
				<input type="text" name="numberOfStars" pattern="^[ 0-9]+$" required placeholder="Input number of stars" /></br></br>
				<input type="text" name="coast" pattern="^[ 0-9]+$" required placeholder="Input coast" /></br></br>
				<legend>On repair?</legend>
				<input type="radio" name="isOnRepair" value="true">Yes</br>
   				<input type="radio" name="isOnRepair" value="false">No</br></br>
				<input type="submit" name="logon" class="login-button" value="Add" />
		</form>
	</center>
</body>
</html>