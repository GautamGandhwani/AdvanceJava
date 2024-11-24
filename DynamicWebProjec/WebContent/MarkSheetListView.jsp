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
	%>
	<form action="MarkSheetListCtl.do" method="post">
		<h1 align="center">MarkSheet List</h1>

		<table border="1px" width="100%">
			<tr bgcolor="grey" style="color: white">
				<th>Delete</th>
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
				<td><%=bean.getRollNo()%></td>
				<td><%=bean.getName()%></td>
				<td><%=bean.getPhysics()%></td>
				<td><%=bean.getChemistry()%></td>
				<td><%=bean.getMaths()%></td>
				<td><a href="MarkSheetCtl.do?rollNo=<%=bean.getRollNo()%>">Edit</a> <%
 	}
 %>
			</tr>
		</table>
		
		
		<table>
			<tr>
				<td><input type="submit" name="operation" value="delete"></td>
			</tr>
		</table>
	</form>
	<%@include file="Footer.jsp"%>

</body>
</html>