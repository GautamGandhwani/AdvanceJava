<%@page import="co.in.Bean.CollegeBean"%>
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
		CollegeBean bean = (CollegeBean) request.getAttribute("bean");
	%>
	<center>
		<form action="CollegeCtl.do" method="post">
			<h1>Add College</h1>

			<table>
				<tr>
					<td><input type="hidden" name="id" value="<%=bean.getId()%>"></td>
				</tr>
				<tr>
					<th>Name :</th>
					<td><input type="text" name="name"
						value="<%=bean != null ? bean.getName() : ""%>"
						placeholder="Enter Name"></td>
				</tr>

				<tr>
					<th>Address :</th>
					<td><input type="text" name="address"
						value="<%=bean != null ? bean.getAddress() : ""%>"
						placeholder="Enter Address"></td>
				</tr>

				<tr>
					<th>State :</th>
					<td><input type="text" name="state"
						value="<%=bean != null ? bean.getState() : ""%>"
						placeholder="Enter State"></td>
				</tr>

				<tr>
					<th>City :</th>
					<td><input type="text" name="city"
						value="<%=bean != null ? bean.getCity() : ""%>"
						placeholder="Enter City"></td>
				</tr>

				<tr>
					<th>Phone No. :</th>
					<td><input type="text" name="phoneno"
						value="<%=bean != null ? bean.getPhoneno() : ""%>"
						placeholder="Enter Phone Number"></td>
				</tr>

				<tr>
					<th></th>
					<td><input type="submit" name="operation"
						value="<%=bean != null ? "update" : "seve"%>"></td>
				</tr>
			</table>
		</form>
	</center>
	<%@include file="Footer.jsp"%>
</body>
</html>