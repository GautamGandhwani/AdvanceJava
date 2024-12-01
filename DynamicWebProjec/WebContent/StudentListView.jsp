<%@page import="co.in.Bean.StudentBean"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
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
		int pageNo = 1;
	%>
	<%
		if (request.getAttribute("pageNo") != null) {
	%>
	<%
		pageNo = (int) request.getAttribute("pageNo");
	%>
	<%
		}
	%>
	<form action="StudentListCtl.do" method="post">
		<h1 align="center">Student List</h1>

		<table>
			<th>First Name :</th>
			<td><input type="text" name="firstName"
				placeholder="Enter First Name"></td>&nbsp;

			<th>Last Name :</th>
			<td><input type="text" name="lastName"
				placeholder="Enter Last Name"></td>&nbsp;

			<th>College Name :</th>
			<td><input type="text" name="collageName"
				placeholder="Enter College Name"></td>&nbsp;

			<th>Email :</th>
			<td><input type="email" name="email" placeholder="Enter Email"></td>&nbsp;

			<th>Mobile No. :</th>
			<td><input type="text" name="mobileNo"
				placeholder="Enter Mobile Number"></td>&nbsp;

			<th>DOB</th>
			<td><input type="date" name="dob" placeholder="Enter DOB"></td>&nbsp;

			<td><input type="submit" name="operation" value="search"></td>
		</table>
		<br>
		<table border="1px" width="100%">
			<tr>
				<th>Delete</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Collage Name</th>
				<th>Email</th>
				<th>Mobile No</th>
				<th>DOB</th>
				<th>Edit</th>
			</tr>

			<%
				Iterator it = list.iterator();
				while (it.hasNext()) {
					StudentBean bean = (StudentBean) it.next();
			%>
			<tr align="center">
				<td><input type="checkbox" name="ids" value="<%=bean.getId()%>"></td>
				<td><%=bean.getFirstName()%></td>
				<td><%=bean.getLastName()%></td>
				<td><%=bean.getCollageName()%></td>
				<td><%=bean.getEmail()%></td>
				<td><%=bean.getMobileNo()%></td>
				<td><%=bean.getDob()%></td>
				<td><a href="StudentCtl.do?id=<%=bean.getId()%>">Edit</a></td>
			</tr>
			<%
				}
			%>
		</table>
		<table width="100%">
			<tr>
				<td align="left"><input type="submit" name="operation"
					value="previous" <%=(pageNo == 1) ? "disabled" : ""%>></td>

				<td><input type="submit" name="operation" value="delete"></td>

				<td align="right"><input type="submit" name="operation"
					value="next" <%=list.size() == 0 ? "disabled" : ""%>></td>
			</tr>
		</table>
		<input type="hidden" name="pageNo" value="<%=pageNo%>">
	</form>
	<%@include file="Footer.jsp"%>
</body>
</html>