<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Room List</title>
<%@include file="style.jsp"%>
</head>
<body>
<%@include file="header.jsp"%>
<!-- 	<div class="ul"> -->
		<table class="room" align="center">
		<tr>
		<td> Room_ID</td>
		<td>Room_No</td>
		<td>Room_name</td>
		<td>Room_Seat</td>
		</tr>
			<c:forEach var="r" items="${list}">
				<tr>
				<td>${r.r_id}</td>
				<td>${r.r_no}</td>
				<td>${r.r_name}</td>
				<td>${r.r_seat}</td>
				<td><a href="/BuildingReservation/schedule/show?id=${r.r_id }"><button>Schedule</button></a>
				</tr>
			</c:forEach>
		</table>
<!-- 	</div> -->
</body>
</html>