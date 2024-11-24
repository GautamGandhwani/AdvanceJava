<%@page import="co.in.Bean.UserBean"%>
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

	<center>
		<form action="LoginCtl" method="post">
			<br> <br> <br>

			<%
				String msg = (String) request.getAttribute("msg");
				String err = (String) request.getAttribute("err");
			%>

			<%
				if (msg != null) {
			%>

			<span style="color: green"><%=msg%></span>

			<%
				}
			%>
			<%
				if (err != null) {
			%>

			<span style="color: red"><%=err%></span>

			<%
				}
			%>


			<h1>LogIn</h1>

			<table>

				<tr>
					<th>Login Id :</th>
					<td><input type="email" name="loginId"
						placeholder="Enter Login Id"></td>
				</tr>

				<tr>
					<th>PassWord :</th>
					<td><input type="password" name="passWord"
						placeholder="Enter Pass Word"></td>
				</tr>

				<tr>
					<th></th>
					<td><input type="submit" name="operation" value="SignIn"></td>
				</tr>

			</table>
		</form>
	</center>
	<%@ include file="Footer.jsp"%>
</body>
</html>