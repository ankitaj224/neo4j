<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Logout</title>
</head>
<body>
<f:view>
<h1>Chicago Crime Data</h1>
<hr/>
	<br />
	<h3>Successfully Logged out</h3>
	<h:form>
				<h:commandButton type="submit" value="Login Again"
					action="index" /> &nbsp;&nbsp;&nbsp;
			</h:form>
</f:view>
</body>
</html>