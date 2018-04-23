<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Location</title>
</head>
<body>
<!-- Header page -->
<%@include file="pmt_header.jsp" %>

<form action="/ProjectManagementTool/editinglocation" method="POST">
<table border="0" width="70%" bgcolor="#f0f0f5">
	<tr height="50px;">
		<td width="300px;"></td>
		<td width="150px;" align="right"><h2>Edit&nbsp;</h2></td>
		<td align="left"><h2>Location details</h2></td>
	</tr>
	<tr height="50px;">
		<td width="300px;"></td>
		<td align="left"  width="150px;">Location Id</td>
	    <td align="left"> <input type="text" name="id" value="${location.id}" readonly="readonly"> </td>	    			
	</tr>
	<tr height="50px;">
		<td width="300px;"></td>
		<td align="left"  width="150px;">Country</td>
	    <td align="left"> <input type="text" name="country" value="${location.country}"> </td>	    			
	</tr>
	<tr height="50px;">
		<td width="300px;"></td>
		<td align="left" width="150px;">State</td>
	    <td align="left"><input type="text" name="state" value="${location.state}"></td>	    			
	</tr>
	<tr height="50px;">
		<td width="300px;"></td>
		<td align="left" width="150px;">City</td>
	    <td align="left"><input type="text" name="city" value="${location.city}"></td>	    			
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
			<a href="/ProjectManagementTool/locations">Locations</a>&nbsp;&nbsp;		 
	    </td>	    			
	</tr>
</table>		

</form>

<!-- Footer page -->
<%@include file="pmt_footer.jsp" %>
</body>
</html>