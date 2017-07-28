<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>Add contact</h1>
	</center>
	<form action="/contacts" method="post">
		<table style="margin-left: 150px">
			<tr>
				<td colspan="2" style="font-weight: bold;">name</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td colspan="2" style="font-weight: bold;">phone Number</td>
				<td><input type="text" name="phno1" /></td>
			</tr>
			<tr>
				<td colspan="2" style="font-weight: bold;">phone Number-2</td>
				<td><input type="text" name="phno2" /></td>
			</tr>
			<tr>
				<td colspan="2" style="font-weight: bold;">email</td>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<td colspan="2" style="font-weight: bold;">email-2</td>
				<td><input type="text" name="email1" /></td>
			</tr>
			<tr>
				<td colspan="2" style="font-weight: bold;">address</td>
				<td><input type="text" name="address" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="ADD" />
				<td>
			</tr>
		</table>
	</form>



</body>
</html>