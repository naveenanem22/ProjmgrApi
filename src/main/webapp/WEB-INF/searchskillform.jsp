<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/resources/styles/searchskillform.css" />" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Skill</title>
<script type="text/javascript" src="<c:url value="/resources/scripts/systemmaint.js" />"></script>

</head>
<body>
<!-- Header page -->
<%@include file="pmt_header.jsp" %>

<form class="searchskillform" action="/ProjectManagementTool/searchingskill" method="POST">
<table class="searchskillcrit" id ="srchcrit">
	<tr>	
		<td ><h3>Search Skill</h3></td>
	</tr>
	<tr> 
		<td >Search By</td>
	    <td > 
	    	<input type="radio" name="searchbynameorid" id="searchbyid" value="skillid" onclick="setPlaceHolder();">Skill ID
	    	<input type="radio" name="searchbynameorid" id="searchbyname" value="skillname" onclick="setPlaceHolder();">Skill Name
	     </td>	    			
	</tr>
	<tr>
		<td>Enter search value</td>
	    <td >	    	
	    	<input type="text" name="searchvalue" id="searchvalueid"/>			 
	    </td>	    			
	</tr>		
	
		
</table>	
<table class="savereset">
<tr>		
		<td >
			<input type="reset" value="Reset"/>
		</td>
	    <td >	    	
	    	<input type="submit" value="Search" />			 
	    </td>	    			
	</tr>	
</table>	

</form>


<table class="searchresultsheader">
<tr>
<td><h3 id="searchresultsheader">Search Results</h3></td>
</tr>
</table>

<table class="skillsearchresults" id ="srchresults">
<tr>
<td id="data">Skill ID</td> <td id="data">Name</td><td id="data">Detail</td><td id="data">Category</td>
</tr>
<c:forEach items="${skills}" var="skill">    
<tr>
<td id="data"><c:out value="${skill.id}"/></td>
<td id="data"><c:out value="${skill.name}"/></td>
<td id="data"><c:out value="${skill.description}" /></td>
<td id="data"><c:out value="${skill.category}" /></td> 
</tr>
</c:forEach>
</table>


<table class="navlinks" >
<tr>
	    <td>
	    	<a href="/ProjectManagementTool/systemmaint">Home</a>
			<a href="/ProjectManagementTool/skills">Skills</a>		 
	    </td>	    			
	</tr>
</table>

<!-- Footer page -->
<%@include file="pmt_footer.jsp" %>
</body>
</html>