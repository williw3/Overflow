<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>New Question</title>
</head>
<body>
<h1>New Question</h1>
	<form:form method="POST" action="/questions" modelAttribute="query">
    	
        	<form:label path="question">Question:</form:label>
        	<form:errors path="question"/>
        	<form:textarea path="question"/>
   
			<p><label for="tagsInput">Tags:</label>
			<input type="text" name="tagsInput"/></p>

    	<input type="submit" value="Submit Question"/>
	</form:form>
	
</body>
</html>