<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Show Question Page</title>
</head>
<body>
	<h1><c:out value="${thisQuestion.question}"></c:out></h1>
	<h3>Tags:</h3>
	<c:forEach var="tag" items="${thisQuestion.tags}" >
    	<p><c:out value="${tag.subject}"/></p>
    </c:forEach>
    <h3>Answers:</h3>
    <c:forEach var="ans" items="${thisQuestion.answers}" >
    	<p><c:out value="${ans.answer}"></c:out></p>
    </c:forEach>
    <h3>Add Your Answer:</h3>
	<form:form method="POST" action="/answers" modelAttribute="solution">
    	
        	<form:label path="answer">Answer:</form:label>
        	<form:errors path="answer"/>
        	<form:textarea path="answer"/>
        	
        	<form:input type="hidden" value="${thisQuestion.id}" path="question"/>
        	
    	<input type="submit" value="Submit Answer"/>
	</form:form>
</body>
</html>