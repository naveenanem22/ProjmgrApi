<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Client</title>
</head>
<body>
<!-- Header page -->
<%@include file="pmt_header.jsp" %>

<form action="/ProjectManagementTool/addingclient" method="post">
<table border="0" width="70%" bgcolor="#f0f0f5">
	<tr height="50px;">
		<td width="300px;"></td>
		<td width="150px;" align="right"><h2>Enter&nbsp;</h2></td>
		<td align="left"><h2>Client details:</h2></td>
	</tr>
	<tr height="50px;">
		<td width="300px;"></td>
		<td align="left"  width="150px;">Client Name</td>
	    <td align="left"> <input type="text" name="name"> </td>	    			
	</tr>
	<tr height="50px;">
		<td width="300px;"></td>
		<td align="left" width="150px;">Client Description</td>
	    <td align="left"><input type="text" size=50 name="description"> </td>	    			
	</tr>
	<tr height="50px;">
		<td width="300px;"></td>
		<td align="left" width="150px;">Client Location</td>
	    <td align="left">
	    <select name = "location">
        <option value = "select">SELECT</Option>
        <c:forEach items="${locations}" var="location">
        <option>${location.city}</option>
        </c:forEach>
        </select>
	    </td>	    			
	</tr>
	
	<tr height="50px;">
		<td width="300px;"></td>
		<td align="right" width="150px;">
			<input type="reset" value="Reset"/>
		</td>
	    <td align="left">	    	
	    	<input type="submit" value="Save" />			 
	    </td>	    			
	</tr>
	<tr height="50px;">
		<td width="300px;"></td>
		<td align="left" width="150px;"></td>
	    <td align="right">
	    	<a href="/ProjectManagementTool/systemmaint">Home</a>&nbsp;&nbsp;
			<a href="/ProjectManagementTool/clients">Clients</a>&nbsp;&nbsp;		 
	    </td>	    			
	</tr>
</table>		

</form>

<!-- Footer page -->
<%@include file="pmt_footer.jsp" %>
</body>
</html>