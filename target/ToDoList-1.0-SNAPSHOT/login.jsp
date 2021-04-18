<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 15.03.2021
  Time: 05:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="Login" method="post">
    <table>
        <tr><td>Username: </td><td><input type="text" name="uname"></td></tr>
        <tr><td>Password: </td><td><input type="password" name="password"></td></tr>
        <tr><td></td><td><input type="submit" value="login"></td><a href="<%=request.getContextPath()%>/register.jsp">Register</a></tr>
    </table>
</form>
</body>
</html>
