<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/resources/styles/locations.css" />" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="<c:url value="/resources/scripts/locations.js" />"></script>
<title>System Maintenance-Locations</title>
</head>

<body>
<!-- Header page -->
<%@include file="pmt_header.jsp" %>

<h3>Locations</h3>
<form>
<table class="locationresults">
<tr>
<td>#</td><td>Location ID</td> <td>Country</td><td>State</td><td>City</td>
</tr>

<c:forEach items="${locations}" var="location">
    <tr>
        <td><input type="checkbox" name="locationrow" value="${location.id}"></input></td>
        <td><c:out value="${location.id}"/></td>
        <td><c:out value="${location.country}"/></td>
        <td><c:out value="${location.state}" /></td>
        <td><c:out value="${location.city}" /></td>          
    </tr>
</c:forEach>


</table>

<br>
<ul id="menu">
  <li><a href="/ProjectManagementTool/addlocation">Add Location</a></li>
  <li><a onClick="getEditLocationId()" id="editlocation">Edit location</a></li>
  <!-- <li><a href="/ProjectManagementTool/searchlocation" id="searchlocation">Search Location</a></li> -->
  <li><a onClick="getRemoveLocationId()" id="removelocation">Remove Location</a></li>
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