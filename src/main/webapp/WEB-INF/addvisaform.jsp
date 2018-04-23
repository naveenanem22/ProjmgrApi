<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="<c:url value="/resources/scripts/scripts-jquery-1.9.1.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/scripts/addvisaform.js" />"></script>
<link href="<c:url value="/resources/styles/addvisaform.css" />" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Visa</title>
</head>
<body>
<!-- Header page -->
<%@include file="pmt_header.jsp" %>

<form action="/ProjectManagementTool/addingvisa/${resource.id}" class="addvisaform" method="post">
<table>
<tr>		
		<td ><h3>Enter VISA details:</h3></td>
	</tr>
</table>
<table class="resourceinfo">	
	<tr>
		<td>${resource.firstName}   ${resource.lastName}</td>	   	    			
	</tr>	
</table>

<table class="addvisadetails">
<tr>
<td>#</td>
<td>Country</td>
<td>Visa Type</td>
<td>Valid till</td>
</tr>
<tr class="visadetailrow">
<td><input type="checkbox" class="visarownum0" name="visarownum0"></input></td>
<td><input type="text" class="visacountry0" name="visacountry0"/></td>
<td><input type="text" class="visatype0" name="visatype0"/></td>
<td><input type="date" class="validtill0" name="validtill0"/></td>
</tr>
</table>
<button type="button" class="addrow" name="addcertrow">AddRow</button>
<button type="button" class="removerow" name="remcertrow">RemoveRow</button>	
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