<%@page import="com.exercise.spring.model.Schedule"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Schedule Management</title>
<%@include file="adstyle.jsp"%>
<link
	href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css"
	rel="stylesheet">
</head>
<body>
	<div id="headbar">
		<h3>Administrator Management</h3>
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

		<table class="table">

			<tr>
<!-- 				<th>sDate</th> -->
				<th>Date</th>
				<th>Status</th>
				<th>U_name</th>
				<th>Control</th>
			</tr>
			<%
				Date today_date = new Date();
				for (int i = 0; i < 31; i++) {
					Boolean check = false;
					int index = -1;
					Date M_date = new Date();
					M_date.setDate(today_date.getDate() + i);
					String mday = new SimpleDateFormat("yyyy-MM-dd").format(M_date);
					List<Schedule> s = (List<Schedule>) request.getAttribute("slist");
					for (int j = 0; j < s.size(); j++) {
						if (s.get(j).getS_sdate().equals(mday)) {
							check = true;
							index = j;
						}

					}
					if (check == true) {
						SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
						Date s_date = formatter.parse(s.get(index).getS_sdate());
						Date e_date = formatter.parse(s.get(index).getS_date());
						double temp = (e_date.getTime() - s_date.getTime()) / (1000 * 3600 * 24);
						int day = (int) Math.ceil(temp);
						for (int x = 0; x < day + 1; x++) {
							Date date = new Date();
							date.setDate(today_date.getDate() + i + x);
							String mdate = new SimpleDateFormat("yyyy-MM-dd").format(date);
			%>
			<tr>
								<td><p id="date"><%=mdate%></p></td>
<%-- 				<td><%=s.get(index).getS_sdate() %></td> --%>
<%-- 				<td><%=s.get(index).getS_date() %></td> --%>
<%-- 				<td><%=s.get(index).getS_rname() %></td> --%>
				<td><%=s.get(index).getS_status()%></td>
				<td><%=s.get(index).getS_uname()%></td>
				<td><button class="btn-primary">Edit</button>
					<button class="btn-danger"
						onclick="deleteSchedule(<%=s.get(index).getS_id()%>)">Delete</button></td>
			</tr>
			<%
				}
						i = i + day;
					}

					else {
			%>
			<tr>
				<td><p id="date"><%=mday%></p></td>
				<td>Available</td>
				<td>-</td>
				<td><a
					href="/BuildingReservation/schedule/add?id=${rid}&sdate=<%=mday%>"><Button
							class="btn-reserve">Reserve</Button></a></td>
			</tr>
			<%
				}
				}
			%>

		</table>
	</div>
	<script type="text/javascript">
		function deleteSchedule(id) {
		
			if (confirm("Are you sure to delete this this schedule?\n To confirm please click 'OK'") == true) {
				window.location = "/BuildingReservation/admin/deletes?&id=" + id;
			}
		}
	</script>
</body>
</html>