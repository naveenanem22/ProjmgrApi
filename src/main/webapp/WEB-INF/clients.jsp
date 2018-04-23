<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="<c:url value="/resources/scripts/scripts-jquery-1.9.1.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/scripts/clients.js" />"></script>
<link href="<c:url value="/resources/styles/clients.css" />" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>System Maintenance-Clients</title>
</head>

<body>
<!-- Header page -->
<%@include file="pmt_header.jsp" %>
<form>
<table >
	<tr>	
		<td><h2>Search Client By</h2></td>
	</tr>	
	<tr>		
		<td >Search By</td>
	    <td>	    
	    	<input type="radio" name="searchbynameorid"  value="id">Client Id
	    	<input type="radio" name="searchbynameorid"  value="name">Client Name	    	
	     </td>	    			
	</tr>
	<tr>		
		<td>Enter Search value
		</td>
	    <td >	    	
	    	<input type="text" name="searchvalue" id="searchvalueid" ></input>			 
	    </td>	    			
	</tr>		
	<tr >
	<td></td>
			
		<td >
			<input name="reset" type="reset" value="Reset"/>
			    	
	    	<input name="search" type="submit" value="Search" />			 
	    </td>	    			
	</tr>
	
</table>		

</form>
<div>
</div>

<h3>Clients:</h3>
<form>
<table class="clientresults">
<%--<tr>
<td>Client ID</td> <td>Name</td><td>Detail</td><td>City</td>
</tr>

 <c:forEach items="${clients}" var="client">
    <tr>
        <td><input type="checkbox" name="clientrow" value="${client.id}"></input></td>
        <td><c:out value="${client.id}"/></td>
        <td><c:out value="${client.name}"/></td>
        <td><c:out value="${client.description}" /></td>
        <td><c:out value="${client.location.city}" /></td>
                  
    </tr>
</c:forEach> --%>


</table>

<br>
<ul id="menu">
  <li><a href="/ProjectManagementTool/addclient">Add Client</a></li>
  <li><a onClick="getEditClientId()" id="editclient">Edit client</a></li>
  <!-- <li><a href="/ProjectManagementTool/searchclient" id="searchclient">Search Client</a></li> -->
  <li><a onClick="getRemoveClientId()" id="removeclient">Remove Client</a></li>
</ul>  
<br>
<br>
</form>
<table class="navlinks">
<tr>
<td><a href="/ProjectManagementTool/systemmaint">Home</a></td>
</tr>
</table>



<!-- Footer page -->
<%@include file="pmt_footer.jsp" %>
</body>
</html>