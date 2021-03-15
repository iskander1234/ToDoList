package com.example.ToDoList.servlet;

import com.example.ToDoList.database.Taskdb;
import com.example.ToDoList.model.Task;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Delete")
public class Delete extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sid=request.getParameter("id");
        int id=Integer.parseInt(sid);
        Taskdb.delete(id);
        response.sendRedirect("Tasks");
    }
}
