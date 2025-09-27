<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head><title>Login</title></head>
<body>
<h1>Login</h1>

<c:if test="${not empty message}">
    <p style="color:red;">${message}</p>
</c:if>

<form method="post" action="login">
    Username: <input type="text" name="username" required><br>
    Password: <input type="password" name="password" required><br>
    <input type="submit" value="Login">
</form>

<p><a href="home">Back to student list</a></p>
</body>
</html>