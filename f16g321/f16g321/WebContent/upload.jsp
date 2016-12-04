<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:useBean id="loginBean" scope="session"
	class="edu.uic.ids517.model.LoginBean">
</jsp:useBean>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>f16g321 Upload</title>
</head>
<body>
	<h1 align="center">IDS517 f16g321</h1>
	<hr />
	<br />
	<div align="center">
		<table>

			<tr>
				<td><a href="instructor.jsp">Back</a>&nbsp;&nbsp;&nbsp;</td>
				<td><a href="index.jsp">Home</a>&nbsp;&nbsp;&nbsp;</td>
				<td><a href="help.jsp">Get Help</a>&nbsp;&nbsp;&nbsp;</td>
				<td><a href="logout.jsp">Logout</a></td>
			</tr>
		</table>
	</div>
	<hr>
	<div align="left">

		<form method="post" action="uploadSuccess.jsp"
			enctype="multipart/form-data">
			<table>

				<tr>
					<td>Select file to upload: <input type="file" name="dataFile"
						id="fileChooser" /><br /> <br /></td>
				</tr>
				<tr>
					<td><INPUT TYPE="radio" name="extension" value="tab" CHECKED>
						Tab Separated <BR /></td>
				</tr>
				<tr>
					<td><INPUT TYPE="radio" name="extension" value="comma">
						Comma Separated <BR /> <br /></td>
				</tr>
				<tr>
					<td><select name="uploadType" size="2">
							<option value="CourseRoster" selected="selected">Course
								Roster</option>

							<option value="Test">Test</option>

					</select><br /> <br /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Upload" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>