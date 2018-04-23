<!-- Header Starting -->
<!-- table border="0" width="50%" bgcolor="#DCDCDC"-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<center>
<table border="0" width="70%" bgcolor="#e0e0eb"> 
	<tr>
		<td style="width:30%;"><a href="#"> <img src="<c:url value="/resources/images/cigniti_logo.png" />" alt=""> </a> </td>
		<td align="center" width="40%"><h2 style="color: #cc7a00;">Project Management Tool</h2></td>
		<td width="30%" align="right">Logged in as:<h4><%= session.getAttribute("username") %></h4> </td>
	</tr>
			
</table>

<!-- Header Ending -->