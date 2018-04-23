<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<link href="<c:url value="/resources/styles/projectmanagementhome.css" />" type="text/css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Project Management-Home</title>
<script type="text/javascript" src="<c:url value="/resources/scripts/scripts-jquery-1.9.1.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/scripts/projectmanagementhome.js" />"></script>
</head>


<body >
<!-- Header page -->
<%@include file="pmt_header.jsp" %>

<table>
	<tr>
	<td><a href="/ProjectManagementTool/projectmanagement/newresreq">New Resource Request</a></td>
	</tr>
	<tr>
	<td><a href="/ProjectManagementTool/projectmanagement/newresreq">View Resource Requests</a></td>
	</tr>
	<tr>
	<td><a href="/ProjectManagementTool/projectmanagement/manageresreq">Manage Resource Requests</a></td>
	</tr>	
</table>

<table class="navlinks">
<tr>
<td><a href="/ProjectManagementTool/projectmanagement">Home</a></td>
</tr>
</table>

<!-- Footer page -->
<%@include file="pmt_footer.jsp" %>
</body>
</html>