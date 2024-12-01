<%@page import="co.in.Bean.StudentBean"%>
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
		StudentBean bean = (StudentBean) request.getAttribute("bean");
	%>
	<center>
		<form action="StudentCtl.do" method="post">
			<%
				String msg = (String) request.getAttribute("msg");
			%>
			<%
				if (msg != null) {
			%>
			<span style="color: green"><%=msg%></span>
			<%
				}
			%>
			<%
				if (bean != null) {
			%>
			<h1>Update Student</h1>
			<%
				} else {
			%>
			<h1>Add Student</h1>
			<%
				}
			%>
			<table>

				<tr>
					<td><input type="hidden" name="id"
						value="<%=bean != null ? bean.getId() : ""%>"></td>
				</tr>

				<tr>
					<th>First Name :</th>
					<td><input type="text" name="firstName"
						value="<%=bean != null ? bean.getFirstName() : ""%>"
						placeholder="Enter First Name"></td>
				</tr>

				<tr>
					<th>Last Name :</th>
					<td><input type="text" name="lastName"
						value="<%=bean != null ? bean.getLastName() : ""%>"
						placeholder="Enter Last Name"></td>
				</tr>

				<tr>
					<th>Collage Name :</th>
					<td><input type="text" name="collageName"
						value="<%=bean != null ? bean.getCollageName() : ""%>"
						placeholder="Enter Collage Name"></td>
				</tr>

				<tr>
					<th>Email :</th>
					<td><input type="email" name="email"
						value="<%=bean != null ? bean.getEmail() : ""%>"
						placeholder="Enter Email"></td>
				</tr>

				<tr>
					<th>Mobile No :</th>
					<td><input type="text" name="mobileNo"
						value="<%=bean != null ? bean.getMobileNo() : ""%>"
						placeholder="Enter Mobile Number"></td>
				</tr>

				<tr>
					<th>DOB :</th>
					<td><input type="date" name="dob"
						value="<%=bean != null ? bean.getDob() : ""%>"
						placeholder="Enter DOB"></td>
				</tr>

				<tr>
					<th></th>
					<td><input type="submit" name="operation"
						value="<%=bean != null ? "update" : "save"%>"></td>
				</tr>

			</table>
		</form>
	</center>
	<%@include file="Footer.jsp"%>
</body>
</html>