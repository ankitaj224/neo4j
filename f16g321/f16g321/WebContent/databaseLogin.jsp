<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>f16g321 Database Login</title>
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

			</tr>
		</table>
	</div>
	<hr />

	<form action="/f16g321/DBAccessServlet" method=post>
		<table>
			<tr>
				<th align="right">UserName:</th>
				<td><input type="text" name="userName" size="16" /></td>
			</tr>
			<tr>
				<th align="right">Password:</th>
				<td><input type="password" name="password" size="16" /></td>
			</tr>
			<tr>
				<th align="right">DB Host:</th>
				<td><input type="text" name="dbmsHost" size="16" /></td>
			</tr>
			<tr>
				<th align="right">DB Schema:</th>
				<td><input type="text" name="dBSchema" size="16" /></td>
			</tr>
			<tr>
				<th align="right">DBMS:</th>
				<td><select name="dbms" size="3">
						<option value="MySQL" selected="selected">MySQL</option>

						<option value="DB2">DB2</option>
						<option value="Oracle">Oracle</option>
				</select></td>
			</tr>
			<tr>
				<td><input type="submit" value="Login" /></td>
			</tr>

			<tr>
				<td><input type="reset" value="Reset" /></td>
			</tr>

		</table>
	</form>
	<p align="center">
		<c:if test="${dBAccessBean.getRenderMessage() == true}">

			<%=dBAccessBean.getMessage()%>

		</c:if>
	</p>
</body>
</html>