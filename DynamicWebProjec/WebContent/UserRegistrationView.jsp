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
		<form action="UserRegistrationCtl" method="post">
		<br><br><br>
		
		<% String msg = (String) request.getAttribute("msg"); %>
		
		<% if(msg != null) {%>
		
		<span><%= msg %></span>
		
		<% } %>
			<h1>User Registration</h1>
			<table>
				<tr>
					<th>FirstName</th>
					<td><input type="text" name="firstName"
						placeholder="Enter First Name"></td>
				</tr>

				<tr>
					<th>LastName</th>
					<td><input type="text" name="lastName"
						placeholder="Enter Last Name"></td>
				</tr>

				<tr>
					<th>LoginId</th>
					<td><input type="email" name="loginId"
						placeholder="Enter Login Id"></td>
				</tr>

				<tr>
					<th>PassWord</th>
					<td><input type="password" name="passWord"
						placeholder="Enter Pass Word"></td>
				</tr>

				<tr>
					<th>Address</th>
					<td><input type="text" name="address"
						placeholder="Enter Address"></td>
				</tr>

				<tr>
					<th>DOB</th>
					<td><input type="date" name="dob"
						placeholder="Enter Date of Birth"></td>
				</tr>

				<tr>
					<th></th>
					<td><input type="submit"></td>
				</tr>
			</table>
		</form>
	</center>
	<%@ include file="Footer.jsp"%>

</body>
</html>