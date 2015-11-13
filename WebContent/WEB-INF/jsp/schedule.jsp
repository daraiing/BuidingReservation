<%@page import="com.exercise.spring.model.Room"%>
<%@page import="com.exercise.spring.model.Building"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Schedule</title>
<%@include file="style.jsp"%>
</head>
<body>
	<%@include file="header.jsp"%>
	<div class="ul">
		<%
			List<Building> blist = (List<Building>) request.getAttribute("blist");
			for (Building b : blist) {
				out.println("<ul id=\"list\"><h3>" + b.getB_name() + "</h3>");
				List<Room> room = (List<Room>) request.getAttribute(String.valueOf(b.getB_id()));
				for (Room r : room) {
		%>
		<li><div id="text3">
				<a href="show?id=<%=r.getR_id()%>"><%=r.getR_name()%></a><br>
			</div></li>
		<%
// 			out.println("<li><div id=\"text3\"><a href=\"show?id=\"" + r.getR_id() + "\"\">" + r.getR_name()
// 							+ "</a><br>" +

// 					// 						if(r.getR_status())
// 							"<span id=\"green\">[ " + r.getR_status() + " ]</span></div></li>");
				}
				out.print("</ul>");
			}
		%>

	</div>
</body>
</html>