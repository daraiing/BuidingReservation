<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Building Management for Administrator</title>
<%@include file="adstyle.jsp"%>
<link
	href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css"
	rel="stylesheet">
</head>
<body>
	<div id="headbar">
		<h3>Admin Management</h3>
	</div>
	<div class="left">
		<ui>
		<p>Menu</p>
		<li><a href="/BuildingReservation/admin/roommgmt">Room
				Management</a></li>
		<li><a href="/BuildingReservation/admin/buildingmgmt">Building
				Management</a></li>
		<li><a href="/BuildingReservation/admin/schedulemgmt">Schedule
				Management</a></li>
		</ui>
	</div>
	<div class="content">
		<div class="head">
			<h4>Building Management</h4>
		</div>
		<a href="/BuildingReservation/admin/insertb/">
		<button class="btn-warning" id="right">
			<i class="icon-plus"></i> Add Building
		</button>
		</a>
		<table class="table">
			<tr>
				<th>ID</th>
				<!-- 				<th>No</th> -->
				<th>Building Name</th>
				<!-- 				<th>Maximum Seat</th> -->
				<th>Location</th>
				<th>Control</th>
			</tr>
			<c:forEach var="b" items="${blist}">
				<tr>
					<td>${b.b_id}</td>
					<td>${b.b_name }</td>
					<td>${b.b_location }</td>
					<td><a href="/BuildingReservation/admin/updateb?id=${b.b_id}"><button class="btn-primary">Edit</button></a>
						<button class="btn-danger" onclick="deleteBuilding(${b.b_id})">Delete</button></td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<script type="text/javascript">
		function deleteBuilding(id) {
		
			if (confirm("Are you sure to delete this this building?\n To confirm please click 'OK'") == true) {
				window.location = "/BuildingReservation/admin/deletes?&id=" + id;
			}
		}
	</script>
</body>
</html>