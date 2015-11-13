<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Building Information</title>
<%@include file="style.jsp"%>

</head>
<body>
	<%@include file="header.jsp"%>

	<div class="ul">
		<h3 align="center">Click on the Building Name to see the
			information</h3>
		<ul id="list">
			<c:forEach var="b" items="${blist}">
				<li><a href="/BuildingReservation/room/list?id=${b.b_id}">${b.b_name}</a></li>
			</c:forEach>
		</ul>
	</div>

	
</body>
</html>