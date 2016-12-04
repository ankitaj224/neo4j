<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Crime</title>
</head>
<body>
	<f:view>
		<h1>Chicago Crime Data</h1>
		<hr />
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
					<h:outputText value="Crime Type:" />
					<h:selectOneMenu value="#{crimeBean.crimeType}">
						<f:selectItem itemValue="OFFENSE INVOLVING CHILDREN" itemLabel="OFFENSE INVOLVING CHILDREN" />
						<f:selectItem itemValue="THEFT" itemLabel="THEFT" />
						<f:selectItem itemValue="CRIMINAL TRESPASS" itemLabel="CRIMINAL TRESPASS" />
						<f:selectItem itemValue="BATTERY" itemLabel="BATTERY" />
						<f:selectItem itemValue="ROBBERY" itemLabel="ROBBERY" />
						<f:selectItem itemValue="CRIMINAL DAMAGE" itemLabel="CRIMINAL DAMAGE" />
						<f:selectItem itemValue="NARCOTICS" itemLabel="NARCOTICS" />
						<f:selectItem itemValue="BURGLARY" itemLabel="BURGLARY" />
						<f:selectItem itemValue="OTHER OFFENSE" itemLabel="OTHER OFFENSE" />
						<f:selectItem itemValue="PUBLIC PEACE VIOLATION" itemLabel="PUBLIC PEACE VIOLATION" />
						<f:selectItem itemValue="MOTOR VEHICLE THEFT" itemLabel="MOTOR VEHICLE THEFT" />
						<f:selectItem itemValue="ASSAULT" itemLabel="ASSAULT" />
						<f:selectItem itemValue="INTIMIDATION" itemLabel="INTIMIDATION" />
						<f:selectItem itemValue="DECEPTIVE PRACTICE" itemLabel="DECEPTIVE PRACTICE" />
						<f:selectItem itemValue="WEAPONS VIOLATION" itemLabel="WEAPONS VIOLATION" />
						<f:selectItem itemValue="CRIME SEXUAL ASSAULT" itemLabel="CRIME SEXUAL ASSAULT" />
						<f:selectItem itemValue="SEX OFFENSE" itemLabel="SEX OFFENSE" />
						<f:selectItem itemValue="INTERFERENCE WITH PUBLIC OFFICER"
							itemLabel="INTERFERENCE WITH PUBLIC OFFICER" />
						<f:selectItem itemValue="GAMBLING" itemLabel="GAMBLING" />
						<f:selectItem itemValue="ARSON" itemLabel="ARSON" />
						<f:selectItem itemValue="STALKING" itemLabel="STALKING" />
						<f:selectItem itemValue="LIQUOR LAW VIOLATION" itemLabel="LIQUOR LAW VIOLATION" />
						<f:selectItem itemValue="wHOMICIDE" itemLabel="HOMICIDE" />
						<f:selectItem itemValue="x"
							itemLabel="CONCEALED CARRY LICENSE VIOLATION" />
						<f:selectItem itemValue="PROSTITUTION" itemLabel="PROSTITUTION" />
						<f:selectItem itemValue="KIDNAPPING" itemLabel="KIDNAPPING" />
						<f:selectItem itemValue="OTHER NARCOTIC VIOLATION" itemLabel="OTHER NARCOTIC VIOLATION" />
						<f:selectItem itemValue="PUBLIC INDECENCY" itemLabel="PUBLIC INDECENCY" />
						<f:selectItem itemValue="NON - CRIMINAL" itemLabel="NON - CRIMINAL" />
						<f:selectItem itemValue="HUMAN TRAFFICKING" itemLabel="HUMAN TRAFFICKING" />
						<f:selectItem itemValue="OBSCENITY" itemLabel="OBSCENITY" />
						<f:selectItem itemValue="NON-CRIMINAL" itemLabel="NON-CRIMINAL" />
						<f:selectItem itemValue="NON-CRIMINAL (SUBJECT SPECIFIED)"
							itemLabel="NON-CRIMINAL (SUBJECT SPECIFIED)" />
						<f:selectItem itemValue="RITUALISM" itemLabel="RITUALISM" />
						<f:selectItem itemValue="DOMESTIC VIOLENCE" itemLabel="DOMESTIC VIOLENCE" />

					</h:selectOneMenu>
					<h:outputText value="" />
					<h:commandButton type="submit" value="Submit"
						action="#{crimeBean.addCrimeDB}" />
						
						<h:outputText value="#{crimeBean.successMessage}"
					style="color:green" rendered="#{crimeBean.renderSuccessMessage}" />
				
					</h:panelGrid>
				
			</h:form>
		</center>
	</f:view>
</body>
</html>