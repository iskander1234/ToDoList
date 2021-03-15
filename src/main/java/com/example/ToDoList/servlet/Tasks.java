package com.example.ToDoList.servlet;

import com.example.ToDoList.database.Taskdb;
import com.example.ToDoList.model.Task;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/Tasks")
public class Tasks extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        System.out.println("<div class='container'>");

        List<Task> list = Taskdb.view();

        System.out.println("<table class='table table-bordered table-striped'>");
        System.out.println("<tr><th>Id</th><th>Name</th><th>About</th><th>Status</th><th>Priority</th><th>Edit</th><th>Delete</th></tr>");
        for(Task bean: list){
            System.out.println("<tr><td>"+bean.getId()+"</td><td>"+bean.getName()+"</td><td>"+bean.getAbout()+"</td><td>"+bean.getStatus()+"</td><td>"+bean.getPriority()+"</td><td><a href='Edit?id="+bean.getId()+"'>Edit</a></td><td><a href='Delete?id="+bean.getId()+"'>Delete</a></td></tr>");
        }
        System.out.println("</table>");

        System.out.println("</div>");
        System.out.close();

    }
}
