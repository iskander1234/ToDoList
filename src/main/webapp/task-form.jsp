
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<html>
<head>
    <title>Task Application</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: blue">
        <div>
            <a href="https://www.xadmin.net" class="navbar-brand"> ToDoList </a>
        </div>

        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/list"
                   class="nav-link">Tasks</a></li>
        </ul>
    </nav>
</header>
<br>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <c:if test="${task != null}">
            <form action="update" method="post">
                </c:if>
                <c:if test="${task == null}">
                <form action="insert" method="post">
                    </c:if>

                    <caption>
                        <h2>
                            <c:if test="${task != null}">
                                Edit Task
                            </c:if>
                            <c:if test="${task == null}">
                                Add New Task
                            </c:if>
                        </h2>
                    </caption>

                    <c:if test="${task != null}">
                        <input type="hidden" name="id" value="<c:out value='${task.id}' />" />
                    </c:if>

                    <fieldset class="form-group">
                        <label>Task Name</label> <input type="text"
                                                        value="<c:out value='${task.name}' />" class="form-control"
                                                        name="name" required="required">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Task Description</label> <input type="text"
                                                               value="<c:out value='${task.description}' />" class="form-control"
                                                               name="description">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Task Status</label> <input type="text"
                                                          value="<c:out value='${task.status}' />" class="form-control"
                                                          name="status">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Task Priority</label> <input type="text"
                                                            value="<c:out value='${task.priority}' />" class="form-control"
                                                            name="priority">
                    </fieldset>

                    <button type="submit" class="btn btn-success">Save</button>
                </form>
        </div>
    </div>
</div>
</body>
</html>
