<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/resources/styles/projects.css" />" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>System Maintenance-Projects</title>
</head>

<body>
<!-- Header page -->
<%@include file="pmt_header.jsp" %>

<h3>Projects</h3>
<table>
<tr>
<th>#</th><th>Project ID</th> <th>Name</th><th>Detail</th>
<th>Start Date</th> <th>End Date</th> <th>Manager</th> <th>Account</th>
<th>Edit</th>
</tr>

<c:forEach items="${projects}" var="project">
    <tr>
        <td><input type="checkbox" value="${project.id}"></input></td>
        <td><c:out value="${project.id}"/></td>
        <td><c:out value="${project.name}"/></td>
        <td><c:out value="${project.desc}" /></td>
        <td><c:out value="${project.startDate}"/></td>
        <td><c:out value="${project.endDate}"/></td>
        <td><c:out value="${project.manager.firstName}"/></td>
        <td><c:out value="${project.account.name}"/></td>
        <td><a href="/ProjectManagementTool/editproject/${project.id}" target="_blank">edit</a></td>          
    </tr>
</c:forEach>


</table>

<br>
<ul id="menu">
  <li><a href="/ProjectManagementTool/addproject">Add Project</a></li>
  <!-- <li><a href="/ProjectManagementTool/editproject">Edit Project</a></li> -->
  <!-- <li><a href="/ProjectManagementTool/searchproject">Search Project</a></li> -->
  <!-- <li><a href="/ProjectManagementTool/removeproject">Remove Project</a></li> -->
</ul>  
<br>
<br>

<a href="/ProjectManagementTool/systemmaint">Home</a>

<!-- Footer page -->
<%@include file="pmt_footer.jsp" %>
</body>
</html>