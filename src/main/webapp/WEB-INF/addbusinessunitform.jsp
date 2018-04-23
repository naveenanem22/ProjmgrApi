<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/resources/styles/addbusinessunitform.css" />" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Businessunit</title>
</head>
<body>
<!-- Header page -->
<%@include file="pmt_header.jsp" %>

<form class="addbusinessunitform" action="/ProjectManagementTool/addingbusinessunit" method="post">
<table>
<tr>		
		<td ><h3>Enter Businessunit details:</h3></td>
	</tr>
</table>
<table class="addbusinessunittable" >
	
	<tr >
		
		<td >Businessunit Name</td>
	    <td > <input type="text" name="name"> </td>	    			
	</tr>
	<tr >
		
		<td >Businessunit Description</td>
	    <td ><input type="text" size=50 name="description"> </td>	    			
	</tr>
	
	
</table>		
<table 	class="savereset">
<tr>			
		<td>
			<input type="reset" value="Reset"/>	
		</td>
		<td>			    	
	    	<input type="submit" value="Save" />			 
	    </td>
	    	    			
	</tr>
</table>

</form>
<table class="navlinks">
<tr>	
	    <td >
	    	<a href="/ProjectManagementTool/systemmaint">Home</a>
			<a href="/ProjectManagementTool/businessunits">Businessunits</a>		 
	    </td>	    			
	</tr>
</table>

<!-- Footer page -->
<%@include file="pmt_footer.jsp" %>
</body>
</html>