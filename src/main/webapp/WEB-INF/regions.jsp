<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/resources/styles/regions.css" />" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="<c:url value="/resources/scripts/regions.js" />"></script>
<title>System Maintenance-Regions</title>
</head>

<body>
<!-- Header page -->
<%@include file="pmt_header.jsp" %>

<h3>Regions</h3>
<form>
<table class="regionresults">
<tr>
<td>#</td><td>Region ID</td> <td>Name</td><td>Detail</td>
</tr>

<c:forEach items="${regions}" var="region">
    <tr>
        <td><input type="checkbox" name="regionrow" value="${region.id}"></input></td>
        <td><c:out value="${region.id}"/></td>
        <td><c:out value="${region.name}"/></td>
        <td><c:out value="${region.description}" /></td>
                  
    </tr>
</c:forEach>


</table>

<br>
<ul id="menu">
  <li><a href="/ProjectManagementTool/addregion">Add Region</a></li>
  <li><a onClick="getEditRegionId()" id="editregion">Edit region</a></li>
  <!-- <li><a href="/ProjectManagementTool/searchregion" id="searchregion">Search Region</a></li> -->
  <li><a onClick="getRemoveRegionId()" id="removeregion">Remove Region</a></li>
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