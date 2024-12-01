<%@page import="co.in.Bean.CollegeBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="Header.jsp"%>
	<%
		List list = (List) request.getAttribute("list");
	%>
	<form action="CollegeListCtl.do" method="post">
		<h1 align="center">College list</h1>

		<table border="1px" width="100%">
			<tr>
				<th>Delete</th>
				<th>Name</th>
				<th>Address</th>
				<th>State</th>
				<th>City</th>
				<th>Phneno</th>
				<th>Edit</th>
			</tr>

			<%
				Iterator it = list.iterator();
				while (it.hasNext()) {
					CollegeBean bean = (CollegeBean) it.next();
			%>
			<tr>
				<td><input type="checkbox" name="ids" value="<%=bean.getId()%>"></td>
				<td><%=bean.getName()%></td>
				<td><%=bean.getAddress()%></td>
				<td><%=bean.getState()%></td>
				<td><%=bean.getCity()%></td>
				<td><%=bean.getPhoneno()%></td>
				<td><a href="CollegeCtl.do?id=<%=bean.getId()%>">Edit</a></td>
			</tr>
			<%
				}
			%>
		</table>
		<table>
			<tr>
				<td><input type="submit" name="operation" value="delete"></td>
			</tr>
		</table>

	</form>
</body>
</html>