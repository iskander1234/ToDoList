<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 11.04.2021
  Time: 23:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<nav class="navbar navbar-expand-md navbar-dark"
     style="background-color: tomato">
    <div><a href="" class="navbar-brand">ToDoList App</a></div>
    <ul class="navbar-nav">
        <li>
            <a href="<%=request.getContextPath()%>/"
               class="nav-link">List</a>
        </li>
        <li>
            <a href="<%=request.getContextPath()%>/login.jsp"
               class="nav-link">Login</a>
        </li>
    </ul>
</nav>
</body>
</html>
