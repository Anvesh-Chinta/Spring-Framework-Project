<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring MVC Zero XML Example</title>
</head>
<body>
	<h2>Spring MVC Zero XML Example</h2>
	<c:if test="${not empty msg}">
        ${msg}
    </c:if>
	<c:choose>
		<c:when test="${customers != null}">
			<h3>List of Customers</h3>
			<table cellpadding="5" cellspacing="5">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Expertise</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="c" items="${customers}">
						<tr>
							<td>${c.id}</td>
							<td>${c.name}</td>
							<td>${c.expertise}</td>
							<td><a
								href="<%=request.getContextPath()%>/update/customer/${c.id}">Update</a>
								&nbsp; <a
								href="<%=request.getContextPath()%>/delete/customer/${c.id}"
								onclick="return confirm('Do you really want to delete?')">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:when>
		<c:otherwise>
        No User found in the DB!
        </c:otherwise>
	</c:choose>
</body>
</html>
