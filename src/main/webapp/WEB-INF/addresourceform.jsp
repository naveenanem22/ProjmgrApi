<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="<c:url value="/resources/scripts/scripts-jquery-1.9.1.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/scripts/addresourceform.js" />"></script>
<link href="<c:url value="/resources/styles/addresourceform.css" />" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Resource</title>
</head>
<body>
<!-- Header page -->
<%@include file="pmt_header.jsp" %>

<form class="addresourceform" action="/ProjectManagementTool/addingresource" method="post">
<table>
<tr>		
		<td ><h3>Enter Resource details:</h3></td>
	</tr>
</table>
<table class="addresourcetable">
	
	<tr >		
		<td >Gender:</td>
	    <td>
	   <select name = "gender">
        <option value = "select">SELECT</Option>
        <option value="Male">Male</option>
        <option value="Female">Female</option>
        </select>
	    </td>	    			
	</tr>
	
	<tr >		
		<td >Marital Status:</td>
	    <td>
	   <select name = "maritalstatus">
        <option value = "select">SELECT</Option>
        <option value="Married">Married</option>
        <option value="Single">Single</option>
        <option value="Divorced">Divorced</option>
        <option value="Widowed">Widowed</option>
        </select>
	    </td>	    			
	</tr>
	
	
	
	
	<tr>
		<td>First Name:</td>
	    <td><input type="text" name="firstname"> </td>	    			
	</tr>
	<tr>
		<td>Last Name:</td>
	    <td><input type="text" name="lastname"> </td>	    			
	</tr>
	
	<tr>
		<td>Employee id:</td>
	    <td><input type="text" name="employeeid"> </td>	    			
	</tr>
	
	<tr>
		<td>Designation:</td>
	    <td><input type="text" name="designation"> </td>	    			
	</tr>
	
	<tr>
		<td>Contact Number:</td>
	    <td><input type="text" name="contactnumber"> </td>	    			
	</tr>
	
	<tr>
		<td>e-Mail:</td>
	    <td><input type="text" name="email"> </td>	    			
	</tr>
	
	<tr>
		<td>Date of Joining:</td>
	    <td> <input type="date" name="doj"> </td>	    			
	</tr>
	
	<tr >		
		<td >Current Location:</td>
	    <td>
	   <select name = "currentlocation">
        <option value = "select">SELECT</Option>
        <c:forEach items="${locations}" var="location">
        <option>${location.city}</option>
        </c:forEach>
        </select>
	    </td>	    			
	</tr>
	
	<tr >		
		<td >Permanent Location:</td>
	    <td>
	   <select name = "permanentlocation">
        <option value = "select">SELECT</Option>
        <c:forEach items="${locations}" var="location">
        <option>${location.city}</option>
        </c:forEach>
        </select>
	    </td>	    			
	</tr>
	
	<tr >		
		<td >Tier:</td>
	    <td>
	    <select name = "tier">
        <option value = "select">SELECT</Option>
        <option value="Tier 1">Tier 1</option>
        <option value="Tier 2">Tier 2</option>
        <option value="Tier 3">Tier 3</option>
        <option value="Tier 4">Tier 4</option>
        <option value="Tier 5">Tier 5</option>
        </select>
	    </td>	    			
	</tr>
	
	<tr >		
		<td >Nature of Employment:</td>
	    <td>
	    <select name = "noe">
        <option value = "select">SELECT</Option>
        <option value="Contract">Contract</option>
        <option value="Permanent">Permanent</option>
        </select>
	    </td>	    			
	</tr>
	
	<tr >		
		<td >Employment Status:</td>
	    <td>
	    <select name = "empstatus">
        <option value = "select">SELECT</Option>
        <option value="Active">Active</option>
        <option value="Inactive-ManagedOut">Inactive-ManagedOut</option>
        <option value="Inactive-Resigned">Inactive-Resigned</option>
        <option value="Inactive-OnNotice">Inactive-OnNotice</option>
        </select>
	    </td>	    			
	</tr>
	
	<tr>
		<td>Last Working Day:</td>
	    <td> <input type="date" name="lwd"> </td>	    			
	</tr>
	
	<tr class="csd">
		<td>Contract Start Date:</td>
	    <td> <input type="date" name="csd"> </td>	    			
	</tr>
	
	<tr class="ced">
		<td>Contract End Date:</td>
	    <td> <input type="date" name="ced"> </td>	    			
	</tr>
	
	<tr>
		<td>Passport Number:</td>
	    <td><input type="text" name="passportnumber"> </td>	    			
	</tr>
	
	<tr>
		<td>Passport Expiry Date:</td>
	    <td> <input type="date" name="ppexpdt"> </td>	    			
	</tr>
	
	<tr >		
		<td >Track:</td>
	    <td>
	    <select name = "track">
        <option value = "select">SELECT</Option>
        <option value="Development">Development</option>
        <option value="Testing">Testing</option>
        <option value="SME">SME</option>        
        </select>
	    </td>	    			
	</tr>
	
	<tr >		
		<td >Competency Group:</td>
	    <td>
	    <select name = "competencygroup">
        <option value = "select">SELECT</Option>
        <option value="Manual Testing">Manual Testing</option>
        <option value="Automation Testing">Automation Testing</option>
        <option value="Performance Testing">Performance Testing</option>
        <option value="Security Testing">Security Testing</option>
        <option value="Test Support Services">Test Support Services</option>        
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
			<a href="/ProjectManagementTool/resources">Resources</a>		 
	    </td>	    			
	</tr>
</table>
<!-- Footer page -->
<%@include file="pmt_footer.jsp" %>
</body>
</html>