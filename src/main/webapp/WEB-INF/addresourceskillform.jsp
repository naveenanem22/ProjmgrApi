<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="<c:url value="/resources/scripts/scripts-jquery-1.9.1.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/scripts/addresourceskillform.js" />"></script>
<link href="<c:url value="/resources/styles/addresourceskillform.css" />" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Resource Skill</title>
</head>
<body>
<!-- Header page -->
<%@include file="pmt_header.jsp" %>

<form action="/ProjectManagementTool/addingresourceskill/${resource.id}" class="addresourceskillform" method="post">
<table>
<tr>		
		<td ><h3>Enter Skill details:</h3></td>
	</tr>
</table>
<table class="resourceinfo">	
	<tr>
		<td>${resource.firstName}   ${resource.lastName}</td>	   	    			
	</tr>	
</table>

<table class="addresourceskilldetails">
<tr>
<th>#</th>
<th>Category</th>
<th>Skill</th>
<th>isCoreSkill</th>
<th>Self Rating</th>
</tr>
<tr class="resourceskilldetailrow">
<td><input type="checkbox" class="resourceskillrownum0" name="resourceskillrownum0"></input></td>
<td>
<select class="resourceskillcat0" name="resourceskillcat0">
<option value="select">SELECT</option>
<option value="technology">Technology</option>
<option value="lifecycle">LifeCycle Management</option>
<option value="tools">Tools</option>
<option value="domain">Domain</option>
</select>
</td>
<td>
<select class="resourceskill0" name="resourceskill0">
<option value="select">SELECT</option>
</select>
</td>

<td>
<select class="resourceskillcore0" name="resourceskillcore0">
<option value="select">SELECT</option>
<option value="yes">YES</option>
<option value="no">NO</option>
</select>
</td>

<td>
<select class="resourceskillrating0" name="resourceskillrating0">
<option value="select">SELECT</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
<option value="4">4</option>
<option value="5">5</option>
</select>
</td>
</tr>
</table>

<button type="button" class="addrow" name="addrow">AddRow</button>
<button type="button" class="removerow" name="removerow">RemoveRow</button>	
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
			<a href="/ProjectManagementTool/resources">Resources</a>		 
	    </td>	    			
	</tr>
</table>
<!-- Footer page -->
<%@include file="pmt_footer.jsp" %>
</body>
</html>