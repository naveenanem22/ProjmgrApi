<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/resources/styles/deliveryunits.css" />" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="<c:url value="/resources/scripts/deliveryunits.js" />"></script>
<title>System Maintenance-Deliveryunits</title>
</head>

<body>
<!-- Header page -->
<%@include file="pmt_header.jsp" %>

<h3>DeliveryUnits</h3>
<form>
<table class="deliveryunitresults">
<tr>
<td>#</td><td>Delivery ID</td> <td>Name</td><td>Description</td>
</tr>

<c:forEach items="${deliveryunits}" var="deliveryunit">
    <tr>
        <td><input type="checkbox" name="deliveryunitrow" value="${deliveryunit.id}"></input></td>
        <td><c:out value="${deliveryunit.id}"/></td>
        <td><c:out value="${deliveryunit.name}"/></td>
        <td><c:out value="${deliveryunit.description}" /></td>
                  
    </tr>
</c:forEach>


</table>

<br>
<ul id="menu">
  <li><a href="/ProjectManagementTool/adddeliveryunit">Add DeliveryUnit</a></li>
  <li><a onClick="getEditDeliveryunitId()" id="editdeliveryunit">Edit DeliveryUnit</a></li>
  <!-- <li><a href="/ProjectManagementTool/searchdeliveryunit" id="searchdeliveryunit">Search DeliveryUnit</a></li> -->
  <li><a onClick="getRemoveDeliveryunitId()" id="removedeliveryunit">Remove DeliveryUnit</a></li>
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