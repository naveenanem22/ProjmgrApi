<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PMT Login</title>
</head>
<body>
<%-- <!-- Header page -->
<%@include file="pmt_header.jsp" %>
 --%>
<center>
<table border="0" width="70%" bgcolor="#e0e0eb"> 
	<tr>
		<td style="width:30%;"><a href="#"> <img src="<c:url value="/resources/images/cigniti_logo.png" />" alt=""> </a> </td>
		<td align="center" width="40%"><h2 style="color: #cc7a00;">Project Management Tool</h2></td>
		<td width="30%"></td>
	</tr>		
</table>
 
 
<form action="/projmgr/verifylogin" method="post">

	<table border="0" width="70%" bgcolor="#f0f0f5">
		<tr height="50px;">
			<td></td>
			<td align="left"><h2>Login Form</h2></td>
			<td></td>
		</tr>
		<tr height="50px;">
			<td align="right">Username</td>
		    <td align="left"> <input name="username" size=15 type="text" /> </td>
			<td></td>		    			
		</tr>
		
		<tr height="50px;">
			<td align="right"> Password</td>			
			<td align="left"> <input name="password" size=15 type="password" /> </td>
			<td></td> 			
		</tr>
		
		<tr height="50px;">
			<td align="right"></td>
			<td align="left">
				<input type="reset" value="Reset"/>
				<input type="submit" value="Login"/>				
			</td>
			<td></td>
		</tr>
	</table>
	<table border="0" width="70%" bgcolor="#f0f0f5">
		<tr height="50px;">
			<td></td>
			<td ></td>
			<td></td>
		</tr>
		<tr height="50px;">
			<td></td>
		    <td> </td>
			<td></td>		    			
		</tr>
		
		<tr height="50px;">
			<td></td>			
			<td></td>
			<td></td> 			
		</tr>
		
		<tr height="50px;">
			<td></td>
			<td></td>
			<td></td>
		</tr>
	</table>
</form>

<!-- Footer page -->
<%@include file="pmt_footer.jsp" %>
</body>
</html>