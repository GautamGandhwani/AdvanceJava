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
	<%
		UserBean userBean = (UserBean) session.getAttribute("user");
	%>
	<%
		if (userBean != null) {
	%>
	<h2 align="right"><%="Hi,  " + userBean.getFirstName()%></h2>
	<a href="UserCtl.do">Add User</a> |
	<a href="UserListCtl.do">User List</a> |
	<a href="MarkSheetCtl.do">Add MarkSheet</a> |
	<a href="MarkSheetListCtl.do">MarkSheet List</a> |
	<a href="WelcomeCtl">Welcome</a> |
	<a href="LoginCtl?operation=logout">Logout </a>
	<%
		} else {
	%>
	<h2 align="right">Hi, Guest</h2>
	<a href="UserRegistrationCtl">SignUp</a> |
	<a href="LoginCtl">Signin</a> |
	<a href="WelcomeCtl">Welcome</a>
	<%
		}
	%>
	<hr>
</body>
</html>