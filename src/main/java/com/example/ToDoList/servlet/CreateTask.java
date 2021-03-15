package com.example.ToDoList.servlet;

import com.example.ToDoList.database.Taskdb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/CreateTast")
public class CreateTask  {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        out.println("<div class='container'>");
        String id=request.getParameter("id");
        String name=request.getParameter("name");
        String about=request.getParameter("about");
        String priority=request.getParameter("priority");
        String status=request.getParameter("status");
        String CreateData=request.getParameter("CreateData");
        String CloseData=request.getParameter("CloseData");
        String OpenData=request.getParameter("OpenData");
        int module=Integer.parseInt(id);
//        Tasks bean=new Tasks(module,name,about,status,priority,CreateData,CloseData,OpenData);
//        int i = Taskdb.save(bean);
//        if(i>0){
//            out.println("<h3>task create successful</h3>");
//        }
        request.getRequestDispatcher("createtask.jsp").include(request, response);
        out.println("</div>");

        out.close();
    }
}
