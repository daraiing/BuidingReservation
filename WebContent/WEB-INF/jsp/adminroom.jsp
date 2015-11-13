<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Room Management for Admin</title>
<%@include file="adstyle.jsp"%>
<!-- <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.no-icons.min.css" rel="stylesheet"> -->
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
			<h4>Room Management</h4>
		</div>
		<a href="/BuildingReservation/admin/insertr/">
		<button class="btn-warning" id="right">
			<i class="icon-plus"></i> Add Room
		</button>
		</a>
		<table class="table">
			<tr>
				<th>ID</th>
				<th>No</th>
				<th>Name</th>
				<th>Maximum Seat</th>
				<th>Building Name</th>
				<th>Control</th>
			</tr>
			<c:forEach var="r" items="${rlist}">
				<tr>
					<td>${r.r_id}</td>
					<td>${r.r_no }</td>
					<td>${r.r_name }</td>
					<td>${r.r_seat}</td>
					<td>${r.r_bname}</td>
					<td><a href="/BuildingReservation/admin/updater?id=${r.r_id}"><button
								class="btn-primary">Edit</button></a>
						<button class="btn-danger" onclick="deleteRoom(${r.r_id})">Delete</button></td>
				</tr>
			</c:forEach>

		</table>
	</div>

	<script type="text/javascript">
		function deleteRoom(id) {
		
			if (confirm("Are you sure to delete this this schedule?\n To confirm please click 'OK'") == true) {
				window.location = "/BuildingReservation/admin/deletes?&id=" + id;
			}
		}
	</script>
</body>
</html>