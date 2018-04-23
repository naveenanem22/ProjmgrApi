<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Account</title>
</head>
<body>
<!-- Header page -->
<%@include file="pmt_header.jsp" %>

<form action="/ProjectManagementTool/editingaccount/${account.id}" method="POST">
<table>
	<tr >		
		<td ><h2>Edit Account details</h2></td>
	</tr>
	<tr >
		<td >Account Id</td>
	    <td > <input type="text" name="accountid" value="${account.id}" readonly="readonly"> </td>	    			
	</tr>
	<tr >
		<td >Account Name</td>
	    <td > <input type="text" name="name" value="${account.name}"> </td>	    			
	</tr>
	<tr >		
		<td >Account Description</td>
	    <td ><input type="text" name="desc" value="${account.desc}"></td>	    			
	</tr>
	
	<tr>
	<td>Type:</td>
	<td><select name="type">
	<option value="select">SELECT</option>
	<option value="Existing">Existing</option>
	<option value="New">New</option>
	<option value="Not Applicable">Not Applicable</option>
	</select></td>
	</tr>
	
	<tr >
		<td >Account Location</td>
	    <td>
	    <select name = "location">
        <option value = "select">SELECT</Option>
        <c:forEach items="${locations}" var="location">
        <option>${location.city}</option>
        </c:forEach>
        </select>
	    </td>	    			
	</tr>
	
	
	<tr >
		<td >Account Manager</td>
	    <td>
	    <select name = "manager">
        <option value = "select">SELECT</Option>
        <c:forEach items="${managers}" var="manager">
        <option value="${manager.id}">${manager.firstName}</option>
        </c:forEach>
        </select>
	    </td>	    			
	</tr>
	
	<tr>
		<td >BusinessUnit</td>
	    <td>
	    <select name = "businessunit">
        <option value = "select">SELECT</Option>
        <c:forEach items="${businessunits}" var="businessunit">
        <option value="${businessunit.id}">${businessunit.name}</option>
        </c:forEach>
        </select>
	    
	    </td>	    			
	</tr>	
<tr>
		<td >DeliveryUnit</td>
	    <td>
	    <select name = "deliveryunit">
        <option value = "select">SELECT</Option>
        <c:forEach items="${deliveryunits}" var="deliveryunit">
        <option value="${deliveryunit.id}">${deliveryunit.name}</option>
        </c:forEach>
        </select>
	    
	    </td>	    			
	</tr>
	
	<tr>
	<td>Start Date</td> <td><input type="date" name="startdate"></input></td>
	</tr>
	
	<tr>
	<td>End Date</td> <td><input type="date" name="enddate"></input></td>
	</tr>
	
	<tr>
	<td>Domain</td>
	<td>
	<select name="domain">
	<option value="domain1">Domain 1</option>
	<option value="domain2">Domain 2</option>
	<option value="domain3">Domain 3</option>
	<option value="domain4">Domain 4</option>
	</select>
	</td>
	</tr>
	
	<tr>
	<td>SubDomain</td>
	<td>
	<select name="subdomain">
	<option value="subdomain1">SubDomain 1</option>
	<option value="subdomain2">SubDomain 2</option>
	<option value="subdomain3">SubDomain 3</option>
	<option value="subdomain4">SubDomain 4</option>
	</select>
	</td>
	</tr>
	
	<tr>
	<td>Client Contact Person</td> <td><input type="text" name="ccp" /></td>
	</tr>
	
	<tr>
	<td>Status</td>
	<td>
	<select name="status">
	<option value="active">Active</option>
	<option value="closed">Closed</option>
	</select>
	</td>
	</tr>
	

</table>	
<table class="savereset">	
	<tr >
		<td ></td>
		<td >
			<input type="reset" value="Reset"/>
		</td>
	    <td >	    	
	    	<input type="submit" value="Save" />			 
	    </td>	    			
	</tr>
	
</table>		

<table class="navlinks">
<tr >
		
	    <td >
	    	<a href="/ProjectManagementTool/systemmaint">Home</a>
			<a href="/ProjectManagementTool/accounts">Accounts</a>		 
	    </td>	    			
	</tr>
</table>

</form>

<!-- Footer page -->
<%@include file="pmt_footer.jsp" %>
</body>
</html>