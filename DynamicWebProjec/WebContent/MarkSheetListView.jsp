<%@page import="java.util.Iterator"%>
<%@page import="co.in.Bean.MarkSheetBean"%>
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

	<form action="MarkSheetListCtl.do" method="post"
		style="background-color: skyblue">
		<h1 align="center">MarkSheet List</h1>
		<table>

			<th>Roll No :</th>
			<td><input type="text" name="rollNo" placeholder="Enter Roll No"></td>&nbsp;

			<th>Name :</th>
			<td><input type="text" name="name" placeholder="Enter Name"></td>&nbsp;

			<th>Physics :</th>
			<td><input type="text" name="physics"
				placeholder="Enter Physics Marks"></td>&nbsp;

			<th>Chemistry :</th>
			<td><input type="text" name="chemistry"
				placeholder="Enter Chemistry Marks"></td>&nbsp;

			<th>Maths :</th>
			<td><input type="text" name="maths"
				placeholder="Enter Maths Marks"></td>&nbsp;

			<td><input type="submit" name="operation" value="search"></td>
		</table>
		<br>
		<table border="1px" width="100%">
			<tr bgcolor="grey" style="color: white">
				<th>Delete</th>
				<th>S. No</th>
				<th>Roll No</th>
				<th>Name</th>
				<th>Physics</th>
				<th>Chemistry</th>
				<th>Maths</th>
				<th>Edit</th>
			</tr>
			<%
				Iterator it = list.iterator();
				while (it.hasNext()) {
					MarkSheetBean bean = (MarkSheetBean) it.next();
			%>
			<tr align="center">
				<td><input type="checkbox" name="ids" value="<%=bean.getId()%>"></td>
				<td><%=bean.getId()%></td>
				<td><%=bean.getRollNo()%></td>
				<td><%=bean.getName()%></td>
				<td><%=bean.getPhysics()%></td>
				<td><%=bean.getChemistry()%></td>
				<td><%=bean.getMaths()%></td>
				<td><a href="MarkSheetCtl.do?rollNo=<%=bean.getRollNo()%>">Edit</a>
					<%
						}
					%>
			</tr>
		</table>
		<br>
		<table width="100%">
			<tr>
				<td align="left"><input type="submit" name="operation"
					value="previous" <%=(pageNo == 1) ? "disabled" : ""%>></td>

				<td><input type="submit" name="operation" value="delete"></td>

				<td align="right"><input type="submit" name="operation"
					value="next" <%=(list.size() == 0) ? "disabled" : ""%>></td>
			</tr>
		</table>
		<input type="hidden" name="pageNo" value="<%=pageNo%>">
	</form>
	<%@include file="Footer.jsp"%>

</body>
</html>