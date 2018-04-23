<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/resources/styles/searchclientform.css" />" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Project</title>
<script type="text/javascript" src="<c:url value="/resources/scripts/systemmaint.js" />"></script>
</head>
<body>
<!-- Header page -->
<%@include file="pmt_header.jsp" %>

<form action="/ProjectManagementTool/searchingclient" method="POST">
<table >
	<tr>	
		<td><h2>Search Client</h2></td>
	</tr>
	
	<tr>
		
		<td >Search By</td>
	    <td> 
	    	<input type="radio" name="searchbynameorid" id="searchbyid" value="clientid" onclick="setPlaceHolder();"/>Client ID
	    	<input type="radio" name="searchbynameorid" id="searchbyname" value="clientname" onclick="setPlaceHolder();"/>Client Name
	     </td>	    			
	</tr>
	<tr>
		
		<td>
			Enter search value
		</td>
	    <td >	    	
	    	<input type="text" name="searchvalue" id="searchvalueid" />			 
	    </td>	    			
	</tr>		
	<tr >
		
		<td >
			<input type="reset" value="Reset"/>
		</td>
	    <td >	    	
	    	<input type="submit" value="Search" />			 
	    </td>	    			
	</tr>
	
</table>		

</form>
<!-- Search Results -->


<div>
<div>
<h4 id="searchresultsheader">Search Results</h4>
</div>
<table id ="srchresults" border="0" style="width:70%;" bgcolor="#f0f0f5">
<tr>
<td id="data">Client ID</td> <td id="data">Name</td><td id="data">City</td><td id="data">Country</td>
</tr>
<c:forEach items="${clients}" var="client">    
<tr>
<td id="data"><c:out value="${client.id}"/></td>
<td id="data"><c:out value="${client.name}"/></td>
<td id="data"><c:out value="${client.location.city}" /></td>
<td id="data"><c:out value="${client.location.country}" /></td> 
</tr>
</c:forEach>
</table>
</div>

<table>
<tr height="50px;">
		<td width="300px;"></td>
		<td align="left" width="150px;"></td>
	    <td align="right">
	    	<a href="/ProjectManagementTool/systemmaint">Home</a>&nbsp;&nbsp;
			<a href="/ProjectManagementTool/clients">Clients</a>&nbsp;&nbsp;		 
	    </td>	    			
	</tr>
</table>

<!-- Footer page -->
<%@include file="pmt_footer.jsp" %>
</body>
</html>