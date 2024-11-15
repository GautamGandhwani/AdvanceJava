<%@page import="co.in.Bean.UserBean"%>
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
	<%@ include file="Header.jsp"%>
	<%
		List list = (List) request.getAttribute("list");
	%>
	<form action="UserListCtl" method="post">
		<h1 align="center">User List</h1>
		<table border="1px" width="100%">
			<tr>
				<th>Delete</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Login Id</th>
				<th>Address</th>
				<th>Dob</th>
			</tr>

			<%
				Iterator it = list.iterator();
				while (it.hasNext()) {
					UserBean bean = (UserBean) it.next();
			%>
			<tr>
				<td><input type="checkbox" name="ids" value="<%=bean.getId()%>"></td>
				<td><%=bean.getFirstName()%></td>
				<td><%=bean.getLastName()%></td>
				<td><%=bean.getLoginId()%></td>
				<td><%=bean.getAddress()%></td>
				<td><%=bean.getDob()%></td>
			</tr>
			<%
				}
			%>
		</table>
		<table>
			<tr>
				<input type="submit" name="operation" value="delete">
			</tr>
		</table>
	</form>
	<%@ include file="Footer.jsp"%>
</body>
</html>