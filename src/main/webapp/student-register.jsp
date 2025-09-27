<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Register Student</title>
</head>
<body>
<h1>Register Student</h1>
<c:choose>
    <c:when test="${not empty sessionScope.user}">
        Logged in as ${sessionScope.user} | <a href="logout">Logout</a>
    </c:when>
    <c:otherwise>
        <a href="login">Login</a>
    </c:otherwise>
</c:choose>
<%
    String message = (String) request.getAttribute("message");
    if (message != null && !message.isEmpty()) {
%>
    <p><%= message %></p>
<%
    }
%>

<form method="post" action="register">
    Name: <input type="text" name="name" required><br>
    Course: <input type="text" name="course" required><br>
    <input type="submit" value="Register">
</form>

<p><a href="home">Back to student list</a></p>

</body>
</html>
