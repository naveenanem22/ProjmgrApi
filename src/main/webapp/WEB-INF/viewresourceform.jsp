<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/resources/styles/viewresourceform.css" />" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Resource</title>
</head>
<body>
<!-- Header page -->
<%@include file="pmt_header.jsp" %>


<table>
<tr>		
		<td ><h3>Resource details:</h3></td>
	</tr>
</table>
<table class="viewresourcetable">
	
	<tr>		
		<th>Resource Id:</th> <td> ${employee.id}</td>
   </tr>
	
	<tr>		
		<th >Employee Id:</th> <td> ${employee.employeeId}</td>
   </tr>
   
   <tr>		
		<th >First Name:</th> <td> ${employee.firstName}</td>
   </tr>
   
   <tr>		
 		<th >Last Name:</th> <td> ${employee.lastName}</td>
   </tr>
   
   	<tr>		
		<th>Contact Number:</th> <td> ${employee.contactNumber}</td>
   </tr>
   
   <tr>		
		<th>Email:</th> <td> ${employee.email}</td>
   </tr>
   
   <tr>		
		<th >Current Location:</th> <td> ${employee.currLocation.city}</td>
   </tr>
   
   <tr>		
		<th >Permanent Location:</th> <td> ${employee.permLocation.city}</td>
   </tr>
   	
	 <tr>		
		<th >Designation:</th> <td> ${employee.designation}</td>
   </tr>
   
    <tr>		
		<th >Date of Joining:</th> <td> ${employee.doj}</td>
   </tr>
   
    <tr>		
		<th >Tier:</th> <td> ${employee.tier}</td>
   </tr>
   
    <tr>		
		<th >Gender:</th> <td> ${employee.gender}</td>
   </tr>
   
    <tr>		
		<th >Marital Status:</th> <td> ${employee.maritalStatus}</td>
   </tr>
   
	<tr>		
		<th >Nature of Employment:</th> <td> ${employee.natureOfEmployment}</td>
   </tr>
	
	<tr>		
		<th >Employee Status:</th> <td> ${employee.empStatus}</td>
   </tr>
   
   <tr>		
		<th >Last Working Day:</th> <td> ${employee.lastWorkingDay}</td>
   </tr>
   
   <tr>		
		<th >Contract Start Date:</th> <td> ${employee.contractStartDate}</td>
   </tr>
   
   <tr>		
		<th >Contract End Date:</th> <td> ${employee.contractEndDate}</td>
   </tr>
   
   <tr>		
		<th >Passport Number:</th> <td> ${employee.passportNumber}</td>
   </tr>
   
   <tr>		
		<th >Passport Expiry Date:</th> <td> ${employee.passportExpiryDate}</td>
   </tr>
   
   <tr>		
		<th >Track:</th> <td> ${employee.track}</td>
   </tr>
   
   <tr>		
		<th >Competency Group:</th> <td> ${employee.competencyGroup}</td>
   </tr>
   
	
</table>		

<table>
<tr>
	<td ><h3>Certification details:</h3></td>
</tr>
</table>

<table class="certificationdetails">
<tr >
<th>#</th> <th>Name</th> <th>CertifyingOrganization</th> <th>Grade</th> <th>Percentage</th> <th>Date Certified</th>
 <th>Valid Till</th>
</tr>
<c:forEach items="${employee.certificates}" var="certificate">
    <tr>
        <td><input type="checkbox" name="certificaterow" value="${certificate.id}"></input></td>
        <td><c:out value="${certificate.name}"/></td>
        <td><c:out value="${certificate.certifyingOrg}" /></td>
        <td><c:out value="${certificate.grade}"/></td>
        <td><c:out value="${certificate.percentage}"/></td>
        <td><c:out value="${certificate.certDate}"/></td>
        <td><c:out value="${certificate.validTill}"/></td>                  
    </tr>
</c:forEach>

</table>

<table>
<tr>
	<td ><h3>VISA details:</h3></td>
</tr>
</table>


<table class="visadetails">
<tr>
<th>#</th><th>Visa Type</th> <th>Visa Country</th> <th>Valid Till</th>
</tr>

<c:forEach items="${employee.visas}" var="visa">
<tr>
     <td><input type="checkbox" name="visarow" value="${visa.id}" /></td>
     <td><c:out value="${visa.visaType}"/></td>
     <td><c:out value="${visa.country}"/></td>
     <td><c:out value="${visa.validTill}"/></td>
</tr>
</c:forEach>
</table>

<table>
<tr>
	<td ><h3>Allocation details:</h3></td>
</tr>
</table>

<table>
<tr>
	<td ><h3>Skill details:</h3></td>
</tr>
</table>

<table class="skilldetails">
<tr>
<th>#</th><th>Skill Name</th> <th>Category</th> <th>Description</th>
</tr>

<c:forEach items="${resSkills}" var="skill">
<tr>
     <td><input type="checkbox" name="skillrow" value="${skill.id}" /></td>
     <td><c:out value="${skill.name}"/></td>
     <td><c:out value="${skill.category}"/></td>
     <td><c:out value="${skill.description}"/></td>
</tr>
</c:forEach>
</table>


<table class="navlinks">
<tr>	
	    <td >
	    	<a href="/ProjectManagementTool/systemmaint">Home</a>
			<a href="/ProjectManagementTool/resources">Resources</a>
			<a href="/ProjectManagementTool/addcertificate/${employee.id}">AddCertificateDetails</a>
			<a href="/ProjectManagementTool/addvisa/${employee.id}">AddVisaDetails</a>
			<a href="/ProjectManagementTool/addresourceskill/${employee.id}">AddSkillDetails</a>			 
	    </td>	    			
	</tr>
</table>
<!-- Footer page -->
<%@include file="pmt_footer.jsp" %>
</body>
</html>