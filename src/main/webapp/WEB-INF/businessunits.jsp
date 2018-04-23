<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/resources/styles/businessunits.css" />" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="<c:url value="/resources/scripts/businessunits.js" />"></script>
<title>System Maintenance-Businessunits</title>
</head>

<body>
<!-- Header page -->
<%@include file="pmt_header.jsp" %>

<h3>Businessunits</h3>
<form>
<table class="businessunitresults">
<tr>
<td>#</td><td>Businessunit ID</td> <td>Name</td><td>Detail</td>
</tr>

<c:forEach items="${businessunits}" var="businessunit">
    <tr>
        <td><input type="checkbox" name="businessunitrow" value="${businessunit.id}"></input></td>
        <td><c:out value="${businessunit.id}"/></td>
        <td><c:out value="${businessunit.name}"/></td>
        <td><c:out value="${businessunit.description}" /></td>
                  
    </tr>
</c:forEach>


</table>

<br>
<ul id="menu">
  <li><a href="/ProjectManagementTool/addbusinessunit">Add Businessunit</a></li>
  <li><a onClick="getEditBusinessunitId()" id="editbusinessunit">Edit businessunit</a></li>
  <!-- <li><a href="/ProjectManagementTool/searchbusinessunit" id="searchbusinessunit">Search Businessunit</a></li> -->
  <li><a onClick="getRemoveBusinessunitId()" id="removebusinessunit">Remove Businessunit</a></li>
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