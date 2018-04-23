<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/resources/styles/skills.css" />" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="<c:url value="/resources/scripts/skills.js" />"></script>
<title>System Maintenance-Skills</title>
</head>

<body>
<!-- Header page -->
<%@include file="pmt_header.jsp" %>

<h3>Skills</h3>
<form>
<table class="skillresults">
<tr>
<td>#</td><td>Skill ID</td> <td>Name</td><td>Detail</td><td>Category</td>
</tr>

<c:forEach items="${skills}" var="skill">
    <tr>
        <td><input type="checkbox" name="skillrow" value="${skill.id}"></input></td>
        <td><c:out value="${skill.id}"/></td>
        <td><c:out value="${skill.name}"/></td>
        <td><c:out value="${skill.description}" /></td>
        <td><c:out value="${skill.category}" /></td>          
    </tr>
</c:forEach>


</table>

<br>
<ul id="menu">
  <li><a href="/ProjectManagementTool/addskill">Add Skill</a></li>
  <li><a onClick="getEditSkillId()" id="editskill">Edit skill</a></li>
  <!-- <li><a href="/ProjectManagementTool/searchskill" id="searchskill">Search Skill</a></li> -->
  <li><a onClick="getRemoveSkillId()" id="removeskill">Remove Skill</a></li>
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