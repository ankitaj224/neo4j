<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:useBean id="loginBean" scope="session"
	class="edu.uic.ids517.model.LoginBean">
</jsp:useBean>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>f16g321 Welcome <%=loginBean.getUserName()%></title>
</head>
<body>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<jsp:useBean id="courseBean" scope="session"
		class="edu.uic.ids517.model.CourseBean">
	</jsp:useBean>
	<h1 align="center">IDS517 f16g321</h1>
	<hr />
	<br />

	<div align="center">
		<table>

			<tr>
				<td><a href="login.jsp">Back</a>&nbsp;&nbsp;&nbsp;</td>
				<td><a href="index.jsp">Home</a>&nbsp;&nbsp;&nbsp;</td>
				<td><a href="help.jsp">Get Help</a>&nbsp;&nbsp;&nbsp;</td>
				<td><a href="logout.jsp">Logout</a></td>
			</tr>
		</table>
	</div>
	<hr>
	<div align="left">
		<table>

			<tr>
				<th align="left">Test Section</th>
			</tr>
			<tr>
				<td><a href="test.jsp">Enterprise Application Quiz 1</a></td>
			</tr>
			<tr>
				<td><a href="test.jsp">Statistics Anova Quiz</a></td>
			</tr>
			<tr>
				<td><a href="test.jsp">MYSQL Quiz-2</a></td>
			</tr>
		</table>
	</div>
	<hr>
	<h3>
		<a href="scores.jsp">View Scores</a>
	</h3>
</body>
</html>