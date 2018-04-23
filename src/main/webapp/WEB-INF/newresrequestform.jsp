<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="<c:url value="/resources/scripts/scripts-jquery-1.9.1.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/scripts/newresrequestform.js" />"></script>
<link href="<c:url value="/resources/styles/newresrequestform.css" />" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Resource Request</title>
</head>
<body>
<!-- Header page -->
<%@include file="pmt_header.jsp" %>

<form action="/ProjectManagementTool/projectmanagement/creatingresreq" class="" method="post">
<table>
<tr>		
		<td ><h3>Resource Request Form:</h3></td>
	</tr>
</table>
<input type="hidden" name="resourceid" value="${resource.id}"/>
<h3>CLIENT DETAILS:</h3>
<table class="clientdetails">

<tr>
<td>Account Type:</td> <td><input name="accounttype" type="text" value="${account.type}" readonly="readonly"/></td>
<td width="50"></td>
<td>Account Name</td><td><input name="accountname" type="text" value="${account.name}" readonly="readonly"/></td>
</tr>

<tr>
<td>Account Manager</td> <td><input name="accountmanager" type="text" value="${account.manager.firstName}" readonly="readonly"/></td>
<td width="50"></td>
<td>BDM</td> <td><input name="BDM" type="text"/></td>
</tr>
</table>

<h3>BUSINESS/PROJECT DETAILS</h3>
<table>

<tr><td>Account ID</td><td><input name="accountid" type="text" value="${account.id}" readonly="readonly"/></td><td>Project ID</td><td><input type="text" name="projectid" value="${project.id}" readonly="readonly"/></td></tr>
<tr>
<td>Business Unit</td><td><input name="acbuid" type="text" readonly="readonly" value="${account.businessunit.name}"/></td>
<td>Delivery Unit</td><td><input name="acduid" type="text" readonly="readonly" value="${account.deliveryunit.name}"/></td>

<td>Project Name</td><td><input name="projectname" type="text" readonly="readonly" value="${project.name}"/></td>
</tr>

<tr>
<td>Request Owner</td><td><input name="requestownerfirstname" value="${resource.firstName}" readonly="readonly"/></td>
<td>Project StartDate</td><td><input name="projectstartdate" type="text" value="${project.startDate}" readonly="readonly"/></td>
<td>Project EndDate</td><td><input name="projectenddate" type="text" value="${project.endDate}" readonly="readonly"/></td>
</tr>

<tr>
<td>Department</td>
<td>
<select name="department">
<option value="select">SELECT</option>
<option value="ICT">ICT</option>
<option value="HR">HR</option>
<option value="RMG">RMG</option> <option value="RMG">RMG</option> <option value="Marketing">Marketing</option>
<option value="Delivery">Delivery</option> <option value="TA">TA</option> <option value="L&D">L and D</option>
<option value="Corporate Services">Corporate Services</option><option value="ESG">ESG</option><option value="ATS">ATS</option>
<option value="Process">Process</option><option value="IST">IST</option>
</select>
</td>

<td>Billable</td>
<td>
<select name="billable">
<option value="select">SELECT</option>
<option value="yes">yes</option>
<option value="no">no</option>
</select>
</td>

<td>Deal Probability</td><td><input name="dealprobability" type="text"/></td>
</tr>


</table>
<h3>RESOURCE DETAILS</h3>

<table class="resourcereqdetails">
<thead class="resreqdetails">
<tr>
<th>Request Type</th>
<th>Role Required</th>
<th>No. of resources</th>
<th>Allocation Type</th>
<th>Allocation StartDate</th>
<th>Allocation EndDate</th>
<th>Client Interview</th>
<th>Competency Group</th>
<th>Primary Skill</th>
<th>Secondary Skill</th>
<th>Domain</th>
<th>Resource Required Location</th>
 </tr>
 </thead>
 
<tbody class="resreqdetails">
 
<tr class="resrequestrow0">
<td>
<select name="requesttype0">
<option value="select">SELECT</option>
<option value="New">New</option>
<option value="Replacement">Replacement</option>
</select>
</td>

 <td><input name="rolerequired0" type="text" required="required"/></td>

 <td><input name="rescount0" type="number" required="required" min="1" max="10"/></td>


<td>
<select name="allctype0">
<option value="Billing">Billing</option>
<option value="Buffer">Buffer</option>
</select>
</td>


<td><input name="allcstartdate0" type="date"/></td>


<td><input name="allcenddate0" type="date"/></td>


<td>
<select name="clientinterview0">
<option value="select">SELECT</option>
<option value="YES">YES</option>
<option value="NO">NO</option>
</select>
</td>


<td>
<select name="competencygrp0">
<option value="Functional Testing">Functional Testing</option> <option value="Automation Testing">Automation Testing</option> <option value="Performance Testing">Performance Testing</option>
<option value="Security Testing">Security Testing</option> <option value="Development">Development</option> <option value="SME">SME</option>
<option value="Project Management">Project Management</option> <option value="Testing Services">Testing Services</option>
</select>
</td>


<td>
<select name="primaryskill0">
<option value="select">SELECT</option>
<c:forEach items="${skills}" var="skill">
<option value="${skill.id}">${skill.name}</option>
</c:forEach>
</select>
</td>


<td>
<select name="secondaryskill0">
<option value="select">SELECT</option>
<c:forEach items="${skills}" var="skill">
<option value="${skill.id}">${skill.name}</option>
</c:forEach>
</select>
</td>

<td>
<select name="domain0">
<option value="select">SELECT</option>
<c:forEach items="${skills}" var="skill">
<c:if test="${skill.category eq 'domain'}">
<option value="${skill.id}">${skill.name}</option>
</c:if>
</c:forEach>
</select>
</td>




<td>
<select name="location0">
<option value="select">SELECT</option>
<c:forEach items="${locations}" var="location">
<option value="${location.id}">${location.city}</option>
</c:forEach>
</select>
</td>




</tr>
</tbody>
</table>

<button type="button" class="addrow" name="addrow">AddRow</button>
<button type="button" class="removerow" name="removerow">RemoveRow</button>

<table 	class="savereset">
<tr>			
		<td>
			<input type="reset" value="Reset"/>	
		</td>
		<td>			    	
	    	<input type="submit" value="Save" />			 
	    </td>
	    	    			
	</tr>
</table>
</form>


<table class="navlinks">
<tr>	
	    <td >
	    <a href="/ProjectManagementTool/projectmanagement">Home</a>
					 
	    </td>	    			
	</tr>
</table>
<!-- Footer page -->
<%@include file="pmt_footer.jsp" %>
</body>
</html>