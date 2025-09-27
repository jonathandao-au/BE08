<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Student" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Student List</title>
<style>
    table {
        border-collapse: collapse;
        width: 60%;
        margin: 20px 0;
    }
    th, td {
        border: 1px solid #ccc;
        padding: 8px 12px;
        text-align: left;
    }
    th {
        background-color: #f2f2f2;
    }
</style>
</head>
<body>
<h1>Student List (${course})</h1>
<c:choose>
    <c:when test="${not empty sessionScope.user}">
        Logged in as ${sessionScope.user} | <a href="logout">Logout</a>
    </c:when>
    <c:otherwise>
        <a href="login">Login</a>
    </c:otherwise>
</c:choose>
<table>
    <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Course</th>
        </tr>
    </thead>
    <tbody>
        <%
            List<model.Student> studentList = (List<model.Student>) request.getAttribute("studentList");
            if (studentList != null && !studentList.isEmpty()) {
                for (model.Student s : studentList) {
        %>
        <tr>
            <td><%= s.getId() %></td>
            <td><%= s.getName() %></td>
            <td><%= s.getCourse() %></td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="3">No students found.</td>
        </tr>
        <%
            }
        %>
    </tbody>
</table>

<p>
    <a href="register">Register a new student</a>
</p>
</body>
</html>
