<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/resources/styles/editprojectform.css" />" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Project</title>
</head>
<body>
<!-- Header page -->
<%@include file="pmt_header.jsp" %>

<form action="/ProjectManagementTool/editingproject/${project.id}" method="post">
<table>	
    <tr>		
		<td ><h2>Edit Project details</h2></td>
	</tr>
	
	<tr>
	<td>Project Name</td>
	<td>
	<input type="text" name="name" value="${project.name}"></input>
	</td>
	</tr>
	
	<tr>
	<td>Description</td> <td><input type="text" name="desc" value="${project.desc}"></input></td>
	</tr>
	
	<tr>
	<td>Type</td> <td><select name="type">
	<option value="type1">Type1</option>
	<option value="type2">Type2</option>
	<option value="type3">Type3</option>
	</select></td>
	</tr>
	
	<tr>
	<td>Location</td>
	<td>
	<select name="location">
	<option value="select">SELECT</option>
	<c:forEach items="${locations}" var="location">
	<option value="${location.id}">${location.city}</option>	
	</c:forEach>
	</select>
	</td>
	</tr>
	
	<tr>
	<td>Start Date</td> <td><input type="date" name="psd" value="${project.startDate}"></input></td>
	</tr>
	
	<tr>
	<td>End Date</td> <td><input type="date" name="ped" value="${project.endDate}"></input></td>
	</tr>
	
	<tr>
	<td>Contract Type</td> 
	<td>
	<select name="contracttype">
	<option value="cntrtype1">cntrtype1</option>
	<option value="cntrtype2">cntrtype2</option>
	<option value="cntrtype3">cntrtype3</option>
	</select>
	</td>
	</tr>
	
	<tr>
		<td >Manager</td>
	    <td>
	    <select name = "manager">
        <option value = "select">SELECT</Option>
        <c:forEach items="${managers}" var="manager">
        <option value="${manager.id}">${manager.firstName}</option>
        </c:forEach>
        </select>
	    
	    </td>	    			
	</tr>	
	
	<tr>
		<td >Account</td>
	    <td>
	    <select name = "account">
        <option value = "select">SELECT</Option>
        <c:forEach items="${accounts}" var="account">
        <option value="${account.id}">${account.name}</option>
        </c:forEach>
        </select>
	    
	    </td>	    			
	</tr>	
	
	<tr>
	<td>Status</td> 
	<td>
	<select name="status">
	<option value="Active">Active</option>
	<option value="Close">Close</option>
	<option value="Cancel">Cancel</option>
	<option value="Resourcing">Resourcing</option>
	<option value="WAR">WAR</option>
	<option value="Contract">Contract</option>
	
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
			<a href="/ProjectManagementTool/projects">Projects</a>		 
	    </td>	    			
	</tr>
</table>
<!-- Footer page -->
<%@include file="pmt_footer.jsp" %>
</body>
</html>