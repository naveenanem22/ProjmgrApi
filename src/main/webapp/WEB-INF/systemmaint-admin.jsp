<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<link href="<c:url value="/resources/styles/systemmaint.css" />" type="text/css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>System Maintenance-Admin</title>
<script type="text/javascript" src="<c:url value="/resources/scripts/scripts-jquery-1.9.1.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/scripts/systemmaint.js" />"></script>
</head>


<body >
<!-- Header page -->
<%@include file="pmt_header.jsp" %>

<table border="0" width="70%" bgcolor="#f0f0f5">
	<tr height="50px;">
		<td align="left"><h2>System Maintenance</h2></td>
	</tr>
	<tr height="80px;">
	    <td align="center">
	    	<ul id="menu">
			
			  <li><a onClick="myFunction()">Projects</a></li>
			  <li><a onClick="clients()">Clients</a></li>
			  <li><a onClick="resources()">Resources</a></li>
			  <li><a onClick="skills()">Skills</a></li>
			  <li><a onClick="businessunits()">Business Units</a></li>
			  <li><a onClick="deliveryunits()">Delivery Units</a></li>
			  <li><a onClick="locations()">Locations</a></li>
			  <li><a onClick="regions()">Regions</a></li>
			  <li><a onClick="accounts()">Accounts</a></li>
			</ul>	    	
	    </td>		    		
	</tr>
	<tr height="50px;">
		<td align="center">
			<div id="linkdetail">
			The project section which provides links to maintain Projects. The project section which provides links to maintain Projects.
			The project section which provides links to maintain Projects. The project section which provides links to maintain Projects.
			The project section which provides links to maintain Projects.
			<br><br>
			The project section which provides links to maintain Projects. The project section which provides links to maintain Projects.
			The project section which provides links to maintain Projects. The project section which provides links to maintain Projects.
			The project section which provides links to maintain Projects.
			<br><br>
			The project section which provides links to maintain Projects. The project section which provides links to maintain Projects.
			The project section which provides links to maintain Projects. The project section which provides links to maintain Projects.
			The project section which provides links to maintain Projects.
			<br><br>
			The project section which provides links to maintain Projects. The project section which provides links to maintain Projects.
			The project section which provides links to maintain Projects. The project section which provides links to maintain Projects.
			The project section which provides links to maintain Projects.
			</div>
		</td> 			
	</tr>
	<tr height="30px;">
		<td align="center">
			
		</td> 			
	</tr>
</table>


<!-- Footer page -->
<%@include file="pmt_footer.jsp" %>
</body>
</html>