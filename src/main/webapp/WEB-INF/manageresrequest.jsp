<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="<c:url value="/resources/scripts/scripts-jquery-1.9.1.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/scripts/manageresrequest.js" />"></script>
<link href="<c:url value="/resources/styles/manageresrequest.css" />" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View/Manage Resource Requests</title>
</head>
<body>
<!-- Header page -->
<%@include file="pmt_header.jsp" %>
<h3>New Resource Requests</h3>
<form>
<table class="newresrequests">
<thead>
<tr>
<th>#</th>
<th>RequestId</th><th>RequestDetailId</th> <th>AccountName</th> <th>ProjectName</th> <th>RequestType</th>
<th>Role</th><th>AllocationType</th> <th>AllcStart</th> <th>AllcEnd</th>
<th>ClientInterview</th> <th>PrimarySkill</th> <th>SecondarySkill</th> <th>Domain</th>
<th>Location</th><th>ResourceId</th><th>ResourceName</th><th>Status</th>
</tr>
</thead>
<tbody>

</tbody>
</table>


<table 	class="actionbuttons">
<tr>			
		<td>
			<input type="submit" value="Accept"/>	
		</td>
		<td>			    	
	    	<input type="submit" value="Nominate" />			 
	    </td>
		<td>			    	
	    	<input type="submit" value="Allocate" />			 
	    </td>
	    <td>			    	
	    	<input type="submit" value="Reject" />			 
	    </td>
	    <td>			    	
	    	<input type="submit" value="Cancel" />			 
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