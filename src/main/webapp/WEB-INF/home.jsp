<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<link href="<c:url value="/resources/styles/home.css" />" type="text/css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<script type="text/javascript" src="<c:url value="/resources/scripts/scripts-jquery-1.9.1.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/scripts/home.js" />"></script>
</head>


<body >
<!-- Header page -->
<%@include file="pmt_header.jsp" %>

<table>
	
	<tr>
	    <td>
	    	<ul>			
			  <li><a href="/ProjectManagementTool/projectmanagement">Project Management</a></li>
			  <li><a href="/ProjectManagementTool/systemmaint">System Admin</a></li>
			  <li><a href="/ProjectManagementTool/employeeportal">Employee Section</a></li>
			  <li><a href="/ProjectManagementTool/Reports">Reports</a></li>
			  <li><a href="/ProjectManagementTool/tempsection1">SampleSection1</a></li>
			  <li><a href="/ProjectManagementTool/tempsection2">SampleSection 2</a></li>			
			</ul>	    	
	    </td>		    		
	</tr>
	
	
</table>


<!-- Footer page -->
<%@include file="pmt_footer.jsp" %>
</body>
</html>