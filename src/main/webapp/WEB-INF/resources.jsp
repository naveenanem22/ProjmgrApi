<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/resources/styles/resources.css" />" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="<c:url value="/resources/scripts/resources.js" />"></script>
<title>System Maintenance-Resources</title>
</head>

<body>
<!-- Header page -->
<%@include file="pmt_header.jsp" %>

<h3>Resources:</h3> 
<form>
<table class="resourceresults">
<tr>
<th>#</th><th>Employee ID</th><th>First Name</th><th>Last Name</th><th>CurrentLocation</th>
<th>PermanentLocation</th> <th>Contact</th> <th>e-mail</th>
</tr>
 
<c:forEach items="${resources}" var="resource">
    <tr>
        <td><input type="checkbox" name="resourcerow" value="${resource.id}"></input></td>
       <%--  <td><c:out value="${resource.employeeId}"/></td> --%>
       <td><a href="/ProjectManagementTool/viewResource/${resource.id}" target="_blank"><c:out value="${resource.employeeId}"/></a></td>
        <td><c:out value="${resource.firstName}"/></td>
        <td><c:out value="${resource.lastName}" /></td>
        <td><c:out value="${resource.currLocation.city}" /></td>
        <td><c:out value="${resource.permLocation.city}" /></td>
        <td><c:out value="${resource.contactNumber}" /></td>
        <td><c:out value="${resource.email}" /></td>
                  
    </tr>
</c:forEach>
 

</table>

<br>
<ul id="menu">
  <li><a href="/ProjectManagementTool/addresource">Add Resource</a></li>  
  <!-- <li><a onClick="getEditResourceId()" id="editresource">Edit resource</a></li> -->
  <!-- <li><a href="/ProjectManagementTool/searchresource" id="searchresource">Search Resource</a></li> -->
  <!-- <li><a onClick="getRemoveResourceId()" id="removeresource">Remove Resource</a></li> -->
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