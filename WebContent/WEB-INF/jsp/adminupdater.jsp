<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Room Information</title>
<%@include file="adstyle.jsp"%>
</head>
<body>
	<div id="headbar">
		<h3>Admin Management</h3>
	</div>
	<div class="left"></div>
	<div class="content">
		<div class="head">
			<h4>Update Room Information</h4>
		</div>
		<form:form action="/BuildingReservation/admin/updaterp" method="post">
			<table class="tableh">
			<tr>
			<th>Column Name</th>
			<th>Value</th>
			</tr>
				<tr>
					<td><form:label path="r_id">ID</form:label></td>
					<td><form:input path="r_id"  /></td>
				</tr>
				<tr>
					<td><form:label path="r_no">Room No.</form:label></td>
					<td><form:input path="r_no" /></td>
				</tr>
				<tr>
					<td><form:label path="r_name">Room Name</form:label></td>
					<td><form:input path="r_name" /></td>
				</tr>
				<tr>
					<td><form:label path="r_seat">Maximum Seat</form:label></td>
					<td><form:input path="r_seat" /></td>
				</tr>
				<tr>
					<td><form:label path="r_bname">Located Buliding</form:label></td>
					<td><form:input path="r_bname" /></td>
				</tr>
				<tr>
<%-- 					<td><form:label path="">Building Location</form:label></td> --%>
					<td colspan="2"><input type="submit" value="Submit" class="btn-submit" />
					<input type="reset" value="Reset" class="btn-danger"/>
					</td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>