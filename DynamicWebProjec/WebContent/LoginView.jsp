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
	<%
		UserBean bean = (UserBean) request.getAttribute("bean");
	%>
	<center>
		<form action="LoginCtl" method="post">
			<br> <br> <br>

			<%
				String msg = (String) request.getAttribute("msg");
			%>

			<%
				if (msg != null) {
			%>

			<span><%=msg%></span>

			<%
				}
			%>

			<%
				if (bean != null) {
			%>
			<h1>Login</h1>
			<%
				} else {
			%>
			<h1>LogIn</h1>
			<%
				}
			%>
			<table>

				<tr>
					<th>Login Id :-</th>
					<td><input type="email" name="loginId"
						value="<%=bean != null ? bean.getLoginId() : ""%>"
						placeholder="Enter Login Id"></td>
				</tr>

				<tr>
					<th>PassWord :-</th>
					<td><input type="password" name="passWord"
						value="<%=bean != null ? bean.getPassWord() : ""%>"
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