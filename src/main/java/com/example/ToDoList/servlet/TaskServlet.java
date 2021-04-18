package com.example.ToDoList.servlet;

import com.example.ToDoList.database.TaskDao;
import com.example.ToDoList.model.Task;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/")
public class TaskServlet extends HttpServlet {
    private TaskDao taskDao;

    public void init() throws ServletException{
        taskDao = new TaskDao();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        switch (action){
            case "/new":
                showNewForm(request,response);
                break;
            case "/insert":
                try {
                    insertTask(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "/delete":
                try {
                    deleteTask(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "/edit":
                try {
                    showEditForm(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "/update":
                try {
                    updateTask(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            default:
                //handle list
                listTask(request,response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    private void listTask(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        try {
            List<Task> listTask = taskDao.selectAllTask();
            request.setAttribute("listTask", listTask);
            RequestDispatcher dispatcher =request.getRequestDispatcher("task-list.jsp");
            dispatcher.forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private void updateTask(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String status = request.getParameter("status");
        String priority = request.getParameter("priority");

        Task task = new Task(id, name,description,status,priority);
        taskDao.updateTask(task);
        response.sendRedirect("list");

    }

    private void deleteTask(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            taskDao.deleteTask(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("list");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        Task existingTask;
        try {
            existingTask = taskDao.selectTask(id);
            RequestDispatcher dispatcher = request.getRequestDispatcher("task-form.jsp");
            request.setAttribute("task", existingTask);
            dispatcher.forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }



    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("task-form.jsp");
        dispatcher.forward(request,response);
    }

    private void insertTask(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String status = request.getParameter("status");
        String priority = request.getParameter("priority");
        Task newTask = new Task(name, description, status,priority);
        taskDao.insertTasks(newTask);
        response.sendRedirect("list");
    }


}
