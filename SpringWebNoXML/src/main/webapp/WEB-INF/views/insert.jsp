<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Insert Employee Details</h1>

	
	<form action="insert" method="post">
		<table>
			<tr>
				<td>ID<input type="text" name="id"></td>
			</tr>
			<tr>
				<td>NAME<input type="text" name="name"></td>
			</tr>
			<tr>
			<td><input type="reset" name="reset" value="clear"></td>
			<td><input type="submit" name="save" value="Add"> </td>
			
			</tr>
		</table>
	</form>
	<h1>${msg}</h1>
</body>
</html>