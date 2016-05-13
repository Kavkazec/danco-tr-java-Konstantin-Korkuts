<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="css/MainPageStyle.css">
<title>Main page</title>
</head>
<body>
	<div class="hdr">
		<span>H</span><span>O</span>
		<div><span>T</span><span>E</span><span>L</span></div></br>
	</div>
	<nav>
		<ul class="menu">
		  <li><a href="#">Main</a></li>
		  <li><a href="#">Rooms</a>
			<ul class="submenu">
			 <form><input type="submit" class="menu-input" value="Add room" /></form>
			 <form><input type="submit" class="menu-input" value="Show rooms" /></form>
			 <form><input type="submit" class="menu-input" value="Delete room" /></form>
			</ul>
		  </li>
		  <li><a href="#">Services</a>
			<ul class="submenu">
			 <form><input type="submit" class="menu-input" value="Add service" /></form>
			 <form><input type="submit" class="menu-input" value="Show services" /></form>
			 <form><input type="submit" class="menu-input" value="Delete service" /></form>
			</ul>
		  </li>
		  <li><a href="#">Guests</a>
			<ul class="submenu">
			 <form><input type="submit" class="menu-input" value="Add guest" /></form>
			 <form><input type="submit" class="menu-input" value="Show guests" /></form>
			 <form><input type="submit" class="menu-input" value="Delete guest" /></form>
			</ul>
		  </li>
		   <li><a href="#">Settlement</a>
			<ul class="submenu">
			 <form><input type="submit" class="menu-input" value="New settlement" /></form>
			 <form><input type="submit" class="menu-input" value="Show settlements" /></form>
			 <form><input type="submit" class="menu-input" value="Delete settlement" /></form>
			</ul>
		  </li>
		</ul>
	</nav>
	<center>
		<form class="form_from_content">
		
		</form>
	</center>
</body>
</html>