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
<title>Show</title>
<%@include file="style.jsp"%>

</head>
<body>
	<%@include file="header.jsp"%>
	<table class="table" align="center">
		<tr>
			<td>Date</td>
			<td>Status</td>
			<td>U_name</td>
			<td>Control</td>
		</tr>
		<% 
		Date today_date = new Date();
		for(int i=0;i<31;i++){
			Boolean check = false;
			int index = -1;
			Date M_date = new Date();
			M_date.setDate(today_date.getDate()+i);
			String mday = new SimpleDateFormat("yyyy-MM-dd").format(M_date);
			List<Schedule> s = (List<Schedule>)request.getAttribute("slist");
			for(int j=0; j<s.size();j++)
			{
				if(s.get(j).getS_sdate().equals(mday))
					{
						check= true;
						index = j;
					}
		
			}
			if(check==true){
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				Date s_date = formatter.parse(s.get(index).getS_sdate());
				Date e_date = formatter.parse(s.get(index).getS_date());
				double temp = (e_date.getTime()-s_date.getTime())/(1000*3600*24);   
				int day = (int)Math.ceil(temp);
				for(int x=0;x<day+1;x++){
					Date date = new Date();
					date.setDate(today_date.getDate()+i+x);
					String mdate = new SimpleDateFormat("yyyy-MM-dd").format(date);
					%>
					<tr>
						<td><p id="date"><%=mdate%></p></td>
						<td><%=s.get(index).getS_status()%></td>
						<td><%=s.get(index).getS_uname()%></td>
						<td>-</td>
					</tr>
		<%
				}
				i=i+day;
			}
		 
		else
		{%>
			<tr>
			<td><p id="date"><%=mday%></p>
			</td>
			<td>Available</td>
			<td>-</td>
<%-- 			<% int rid= (int)request.getAttribute("rid"); %> --%>
			<td><a href="/BuildingReservation/schedule/add?id=${rid}&sdate=<%=mday%>"><Button>Reserve</Button></a></td>
		</tr>
			<%
		}}%>
		
	</table>
</body>
</html>