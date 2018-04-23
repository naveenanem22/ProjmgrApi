<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Location</title>
<script type="text/javascript" src="<c:url value="/resources/scripts/systemmaint.js" />"></script>
</head>
<body>
<!-- Header page -->
<%@include file="pmt_header.jsp" %>

<form>
<table border="0" width="70%" bgcolor="#f0f0f5">
	<tr height="50px;">
		<td width="300px;"></td>
		<td width="150px;" align="right"><h2></h2></td>
		<td align="left"><h2>Search Location</h2></td>
	</tr>
	<tr height="50px;">
		<td width="300px;"></td>
		<td align="left"  width="150px;">Search By</td>
	    <td align="left"> 
	    	<input type="radio" name="search" id="searchid" value="byname" onclick="setPlaceHolder();">Location ID
	    	<input type="radio" name="search" id="searchid" value="byid1" onclick="setPlaceHolder();">Country
	     </td>	    			
	</tr>
	<tr height="50px;">
		<td width="300px;"></td>
		<td align="left" width="150px;">
			Enter search value
		</td>
	    <td align="left">	    	
	    	<input type="text" name="searchvalue" id="searchvalueid" />			 
	    </td>	    			
	</tr>		
	<tr height="50px;">
		<td width="300px;"></td>
		<td align="right" width="150px;">
			<input type="reset" value="Reset"/>
		</td>
	    <td align="left">	    	
	    	<input type="submit" value="Search" />			 
	    </td>	    			
	</tr>
	<tr height="50px;">
		<td width="300px;"></td>
		<td align="left" width="150px;"></td>
	    <td align="right">
	    	<a href="/ProjectManagementTool/systemmaint">Home</a>&nbsp;&nbsp;
			<a href="/ProjectManagementTool/locations">Locations</a>&nbsp;&nbsp;		 
	    </td>	    			
	</tr>
</table>		

</form>

<!-- Footer page -->
<%@include file="pmt_footer.jsp" %>
</body>
</html>