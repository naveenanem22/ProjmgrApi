<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="<c:url value="/resources/styles/addskillform.css" />" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Skill</title>
</head>
<body>
<!-- Header page -->
<%@include file="pmt_header.jsp" %>

<form class="addskillform" action="/ProjectManagementTool/addingskill" method="post">
<table>
<tr>		
		<td ><h3>Enter Skill details:</h3></td>
	</tr>
</table>
<table class="addskilltable">
	
	<tr>		
		<td >Skill Name</td>
	    <td > <input type="text" name="name"> </td>	    			
	</tr>
	<tr>		
		<td >Skill Description</td>
	    <td ><input type="text" size=50 name="description"> </td>	    			
	</tr>
	<tr>
		<td >Skill Category</td>
	    
	    <td>
<select class="category" name="category">
<option value="select">SELECT</option>
<option value="technology">Technology</option>
<option value="lifecycle">LifeCycle Management</option>
<option value="tools">Tools</option>
<option value="domain">Domain</option>
</select>
</td>
	    	    			
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
			<a href="/ProjectManagementTool/skills">Skills</a>		 
	    </td>	    			
	</tr>
</table>

<!-- Footer page -->
<%@include file="pmt_footer.jsp" %>
</body>
</html>