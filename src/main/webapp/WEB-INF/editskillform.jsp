<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/resources/styles/editskillform.css" />" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Skill</title>
</head>
<body>
<!-- Header page -->
<%@include file="pmt_header.jsp" %>

<form class="editskillform" action="/ProjectManagementTool/editingskill" method="POST">
<table>
<tr>		
		<td ><h3>Edit Skill details:</h3></td>
	</tr>
</table>
<table class="editskilltable">
	
	<tr >
		
		<td >Skill Id</td>
	    <td > <input type="text" name="id" value="${skill.id}" readonly="readonly"> </td>	    			
	</tr>
	<tr >
		
		<td >Skill Name</td>
	    <td > <input type="text" name="name" value="${skill.name}"> </td>	    			
	</tr>
	<tr >
		
		<td >Skill Description</td>
	    <td ><input type="text" name="description" value="${skill.description}"></td>	    			
	</tr>
	<tr >
		
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