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
	<h1 align="center">IDS517 f16g321</h1>
	<hr />
	<br />
	<div align="center">
		<table>

			<tr>
				<td><a href="index.jsp">Back</a>&nbsp;&nbsp;&nbsp;</td>
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
				<th>Courses</th>
			</tr>
			<tr>
				<td><a href="course.jsp">MKTG 500 Introduction to Marketing
						(12927) 2016 Fall</a></td>
			</tr>
			<tr>
				<td><a href="course.jsp">IDS 570 Statistics for Management
						(25943) 2016 Fall</a></td>
			</tr>
			<tr>
				<td><a href="course.jsp">IDS 521 Adv Database Management
						(14091) 2016 Fall</a></td>
			</tr>

		</table>
	</div>
	<hr>
	<h4>
		<a href="upload.jsp">Upload Content</a>
	</h4>
</body>
</html>