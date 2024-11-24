<%@page import="co.in.Bean.MarkSheetBean"%>
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
		MarkSheetBean bean = (MarkSheetBean) request.getAttribute("bean");
	%>
	<center>
		<form action="MarkSheetCtl.do" method="post">

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
			<h1>Update MarkSheet</h1>
			<%
				} else {
			%>
			<h1>Add MarkSheet</h1>
			<%
				}
			%>
			<table>
				
				<tr>
					<th>Roll No :</th>
					<td><input type="text" name="rollno"
						value="<%=bean != null ? bean.getRollNo() : ""%>"
						placeholder="Enter Roll Number"></td>
				</tr>

				<tr>
					<th>Name :</th>
					<td><input type="text" name="name"
						value="<%=bean != null ? bean.getName() : ""%>"
						placeholder="Enter Name"></td>
				</tr>

				<tr>
					<th>Physics :</th>
					<td><input type="text" name="physics"
						value="<%=bean != null ? bean.getPhysics() : ""%>"
						placeholder="Enter Physic Marks"></td>
				</tr>

				<tr>
					<th>Chemistry :</th>
					<td><input type="text" name="chemistry"
						value="<%=bean != null ? bean.getChemistry() : ""%>"
						placeholder="Enter Chemistry Marks"></td>
				</tr>

				<tr>
					<th>Maths :</th>
					<td><input type="text" name="maths"
						value="<%=bean != null ? bean.getMaths() : ""%>"
						placeholder="Enter Maths Marks"></td>
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