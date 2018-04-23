<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/resources/styles/accounts.css" />" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="<c:url value="/resources/scripts/accounts.js" />"></script>
<title>System Maintenance-Accounts</title>
</head>

<body>
<!-- Header page -->
<%@include file="pmt_header.jsp" %>

<h3>Accounts:</h3>
<form>
<table>
<tr>
<th>#</th><th>Account ID</th> <th>Name</th><th>Detail</th> <th>BusinessUnit</th>
<th>DeliveryUnit</th> <th>Status</th> <th>Start date</th> <th>End date</th><th>Edit</th>
</tr>

<c:forEach items="${accounts}" var="account">
    <tr>
        <td><input type="checkbox" name="accountrow" value="${account.id}"></input></td>
        <td><c:out value="${account.id}"/></td>
        <td><c:out value="${account.name}"/></td>
        <td><c:out value="${account.desc}" /></td>
        <td><c:out value="${account.businessunit.name}"/></td>
        <td><c:out value="${account.deliveryunit.name}"/></td>    
        <td><c:out value="${account.status}"></c:out></td> 
        <td><c:out value="${account.startDate}"></c:out></td>
        <td><c:out value="${account.endDate}"></c:out></td>
        <td><a href="/ProjectManagementTool/editaccount/${account.id}">edit</a></td>
                  
    </tr>
</c:forEach>


</table>

<br>
<ul id="menu">
  <li><a href="/ProjectManagementTool/addaccount">Add Account</a></li>
  <!-- <li><a onClick="getEditAccountId()" id="editaccount">Edit account</a></li> -->
  <!-- <li><a href="/ProjectManagementTool/searchaccount" id="searchaccount">Search Account</a></li> -->
  <!-- <li><a onClick="getRemoveAccountId()" id="removeaccount">Remove Account</a></li> -->
</ul>  
<br>
<br>
</form>
<a href="/ProjectManagementTool/systemmaint">Home</a>

<!-- Footer page -->
<%@include file="pmt_footer.jsp" %>
</body>
</html>