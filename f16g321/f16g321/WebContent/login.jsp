<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>f16g321 Login</title>
</head>
<body>
	<jsp:useBean id="loginBean" scope="session"
		class="edu.uic.ids517.model.LoginBean">
	</jsp:useBean>
	<h1 align="center">IDS517 f16g321</h1>
	<hr />
	<br />
	<h2 align="center">Online Examination System</h2>
	<hr />
	<br />
	<div align="center">
		<a href="index.jsp">Home</a> <br /> <br />
	</div>
	<hr />
	<div align="left">
		<form action="login" method="post">
		<table>
			<tr>
				<th align="right">UserName:</th>
				<td><input type="text" name="userName"
				value="${loginBean.userName}"

				 size="16" /></td>
			</tr>
			<tr>
				<th align="right">Password:</th>
				<td><input type="password" name="password" 
				value="${loginBean.password }"
				size="16" /></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="Login" /></td>
			</tr>

			<tr>
				<td><input type="reset" value="Reset" /></td>
			</tr>

		</table>
	</form>
	<p>
	For Student Login :<br/>
	Username-student<br/>
	password- student<br/>
	<br/><br/>
	Instructor:<br/>
	Username-prof<br/>
	password- prof<br/>
	<br/><br/>
	DBA:<br/>
	Username-admin<br/>
	password- admin<br/>
	</p>
		</div>
	<p align="center">
	<c:if test="${loginBean.getRenderMessage() == true}" >
	
		<%=loginBean.getMessage()%> 
	
	</c:if>
	</p>

</body>
</html>