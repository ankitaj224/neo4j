<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Crime</title>
</head>
<body>
<f:view>
<h1>Chicago Crime Data</h1>
<hr/>
	<br />

		<div align="center">

			<h:form>
				<h:commandButton type="submit" value="Home Page"
					action="index" /> &nbsp;&nbsp;&nbsp;
				<h:commandButton type="submit" value="Logout"
					action="#{crimeBean.logout}" />
			</h:form>
		</div>
		<hr />
<center>
<h:form>
				<h:panelGrid columns="2">

					<h:outputText value="Area Name:" />
					<h:inputText id="areaName" value="#{crimeBean.areaName}" />
					<h:commandButton type="submit" value="View Crime"
						action="#{crimeBean.viewCrimeDB}" />
					<h:outputText value="#{messageBean.successMessage}"
					style="color:green" rendered="#{messageBean.renderSuccessMessage}" />
				</h:panelGrid>
				
			</h:form>
</center>
<div>
<t:dataList id="datalist" style="myStyle"
  var="test"
  value="#{crimeBean.crimes}"
  rendered="#{crimeBean.crimeRendered}"
  rowCountVar="rowCount"
  rowIndexVar="rowIndex"
  layout="unorderedList"> 
  <h:outputText value="#{test}"></h:outputText>					
</t:dataList>
</div>
</f:view>
</body>
</html>