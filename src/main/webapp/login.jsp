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
<form action="LoginRegister" method="post">
    <table style="background-color: lightgreen; margin-left: 20px; margin-left: 20px">
        <tr>
            <td><h3 style="color:red;">${message}</h3>
            <h3 style="color: green">${successMessage}</h3></td>
            <td></td>
        </tr>

        <tr>
        <td><h3 style="color: red">Login Page!!!</h3></td>
        <td></td>
        </tr>
        <tr><td> UserName : </td><td><input type="text" name="username"></td></tr>
        <tr><td> Password : </td><td><input type="password" name="password"></td></tr>
        <tr><td><input type="submit" name="submit" value="Login"></td><td><a href="register.jsp">Registration</a></td></tr>
    </table>
</form>
</body>
</html>
