<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reservation Page</title>
<%@include file="style.jsp"%>

</head>
<body>
	<%@include file="header.jsp"%>

	<form:form action="/BuildingReservation/reserve/addpost" method="post">
		<table class="tabler" align="center">
			<tr>
				<td colspan="2"><p id="head">Reserve Information</p> <span><font
						color="red">Please fill the information below</font></span></td>

			</tr>
			<tr>
				<td>Name<span class="red">*</span>:
				</td>
				<td><form:input type="text" path="s_uname" /></td>
			</tr>
			<tr>
				<td>Start Date<span class="red">*</span>:
				</td>
				<td><form:input type="text" path="s_sdate" value="${sdate}"/><span class="red">Pattern:
						"YYYY-mm-DD"</span></td>
			</tr>
			<tr>
				<td>End Date<span class="red">*</span>:
				</td>
				<td><form:input type="text" path="s_date" /><span class="red">Pattern:
						"YYYY-mm-DD"</span></td>
			</tr>
			<tr>
				<td>Building<span class="red">*</span>:
				</td>
				<td><form:input path="s_bname" value="${b}" /></td>
			</tr>
			<tr>
				<td>Room Name<span class="red">*</span>: <td><form:input path="s_rname" value="${r}" /></td>
			</tr>

			<tr>
				<td colspan="2"><button>Search</button></td>
			</tr>
		</table>
	</form:form>

	<script type="text/javascript">
		function checktime() {
			var time = document.getElementById("time").value;
			alert(time);
		}
	</script></
				body>
</html>