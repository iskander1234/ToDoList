<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="LoginRegister" method="post">
    <table style="background-color: skyblue; margin-left: 20px; margin-left: 20px">
        <tr>
            <td><h3 style="color: green">Register Page!!!</h3></td>
            <td></td>
        </tr>
        <tr>
            <td> UserName : </td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td> Name : </td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td> Password : </td>
            <td><input type="password" name="password1"></td>
        </tr>
        <tr>
            <td> Re-Type Password : </td>
            <td><input type="password" name="password2"></td>
        </tr>
        <tr>
            <td><input type="submit" name="submit" value="Register">
            </td><td></td></tr>
    </table>
</form>
</body>
</html>
