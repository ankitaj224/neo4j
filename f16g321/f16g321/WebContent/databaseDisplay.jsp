<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>f16g321 DataBase Details</title>
</head>
<body>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<jsp:useBean id="dBAccessBean" scope="session"
		class="edu.uic.ids517.model.DBAccessBean">
	</jsp:useBean>
	<h1 align="center">IDS517 f16g321</h1>
	<hr />
	<br />
	<div align="center">
		<table>

			<tr>

				<td><a href="index.jsp">Home</a>&nbsp;&nbsp;&nbsp;</td>

				<td><a href="logout.jsp">Logout</a></td>
			</tr>
		</table>
	</div>
	<hr>
	<div>
		<a href="/f16g321/DBAccessOperations">List all DB Tables</a> </br> </br>
	</div>

	<div align="left">
		<p>List Columns of a Table</p>
		<form action="/f16g321/DBAccessOperations" method=post>
			<table>

				<tr>
					<td align="right">Enter Table Name:</td>
					<td><input type="text" name="tableName" size="16" />
				</tr>
				<tr>
					<td><input type="submit" value="Submit" /></td>
					<td><input type="reset" value="Reset" /></td>
				</tr>
			</table>

		</form>
	</div>
	</br>
	</br>
	</br>
	<div align="left">
		<p>Run SQL Query</p>
		<form action="/f16g321/DBAccessOperations" method=post>
			<table>
				<tr>
					<td align="right">Enter SQL Query</td>
					<td><input type="text" name="sqlQuery" size="100" />
				</tr>
				<tr>
					<td><input type="submit" value="Run" /></td>
					<td><input type="reset" value="Reset" /></td>
				</tr>
			</table>
		</form>
	</div>
	</br>
</body>
</html>