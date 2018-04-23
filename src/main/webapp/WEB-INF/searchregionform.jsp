<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/resources/styles/searchregionform.css" />" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Project</title>
<script type="text/javascript" src="<c:url value="/resources/scripts/systemmaint.js" />"></script>
</head>
<body>
<!-- Header page -->
<%@include file="pmt_header.jsp" %>

<form action="/ProjectManagementTool/searchingregion" method="POST">
<table border="0" width="70%" bgcolor="#f0f0f5">
	<tr height="50px;">
		<td width="300px;"></td>
		<td width="150px;" align="right"><h2></h2></td>
		<td align="left"><h2>Search Region</h2></td>
	</tr>
	<tr height="50px;">
		<td width="300px;"></td>
		<td align="left"  width="150px;">Search By</td>
	    <td align="left"> 
	    	<input type="radio" name="searchbynameorid" id="searchbyid" value="regionid" onclick="setPlaceHolder();">Region ID
	    	<input type="radio" name="searchbynameorid" id="searchbyname" value="regionname" onclick="setPlaceHolder();">Region Name
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
	
</table>		
<!-- Search results -->
<div>
<div>
<h4 id="searchresultsheader">Search Results</h4>
</div>
<table id ="srchresults" border="0" style="width:70%;" bgcolor="#f0f0f5">
<tr>
<td id="data">Region ID</td> <td id="data">Name</td><td id="data">Description</td>
</tr>
<c:forEach items="${regions}" var="region">    
<tr>
<td id="data"><c:out value="${region.id}"/></td>
<td id="data"><c:out value="${region.name}"/></td>
<td id="data"><c:out value="${region.description}" /></td>

</tr>
</c:forEach>
</table>
</div>

</form>
<table>
<tr height="50px;">
		<td width="300px;"></td>
		<td align="left" width="150px;"></td>
	    <td align="right">
	    	<a href="/ProjectManagementTool/systemmaint">Home</a>&nbsp;&nbsp;
			<a href="/ProjectManagementTool/regions">Regions</a>&nbsp;&nbsp;		 
	    </td>	    			
	</tr>
</table>
<!-- Footer page -->
<%@include file="pmt_footer.jsp" %>
</body>
</html>