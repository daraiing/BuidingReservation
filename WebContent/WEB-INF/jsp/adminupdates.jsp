<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Sschedule Information</title>
<%@include file="adstyle.jsp"%>
	
</head>
<body>
	<div id="headbar">
		<h3>Admin Management</h3>
	</div>
	<div class="left"></div>
	<div class="content">
		<div class="head">
			<h4>Update Schedule Information</h4>
		</div>
		<form:form action="/BuildingReservation/admin/updatesp" method="post">
			<table class="tableh">
				<tr>
					<th>Column Name</th>
					<th>Value</th>
				</tr>
				<tr>
					<td><form:label path="s_id">ID</form:label></td>
					<td><form:input path="s_id" /></td>
				</tr>
				<tr>
					<td><form:label path="s_rname">Room Name</form:label></td>
					<td><form:input path="s_rname" /></td>
				</tr>
				<tr>
					<td><form:label path="s_bname">Building Name</form:label></td>
					<td><form:input path="s_bname" /></td>
				</tr>
				<tr>
					<td><form:label path="s_sdate">Start Date</form:label></td>
					<td><form:input path="s_sdate" /></td>
				</tr>
				<tr>
					<td><form:label path="s_date">End Date</form:label></td>
					<td><form:input path="s_date" /></td>
				</tr>
				<tr>
					<td><form:label path="s_uname">Reserver Name</form:label></td>
					<td><form:input path="s_uname" /></td>
				</tr>
				<tr>
					<td><form:label path="s_status">Reserver Name</form:label></td>
					<td><form:input path="s_status" /></td>
				</tr>
				<tr>
					<%-- 					<td><form:label path="">Building Location</form:label></td> --%>
					<td colspan="2"><input type="submit" value="Submit"
						class="btn-submit" /> <input type="reset" value="Reset"
						class="btn-danger" "/></td>
				</tr>
			</table>
		</form:form>
	</div>

</body>
</html>