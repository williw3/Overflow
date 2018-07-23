<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Dashboard</title>
</head>
<body>
	<h1>Display questions here</h1>
	<a href="/questions/new">New Question</a>
	<table>
    	<thead>
        	<tr>
            	<th>Question</th>
            	<th>Tags</th>
        	</tr>
    	</thead>
    	<tbody>
        	<c:forEach var="q" items="${questions}" >
        		<tr>
            		<td><a href="/questions/${q.id}"><c:out value="${q.question}"/></a></td>
            		<td>
            			<c:forEach var="tag" items="${q.tags}" >
            				<p><c:out value="${tag.subject}"/></p>
            			</c:forEach>
            		</td>
        		</tr>
        	</c:forEach>
    	</tbody>
	</table>
</body>
</html>