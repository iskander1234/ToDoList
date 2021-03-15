package com.example.ToDoList.servlet;

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
        String name=request.getParameter("name");
        String about=request.getParameter("about");
        String priority=request.getParameter("priority");
        String status=request.getParameter("status");
        String CreateData=request.getParameter("CreateData");
        String CloseData=request.getParameter("CloseData");
        String OpenData=request.getParameter("OpenData");
//        String status=request.getParameter("");
//        Tasks bean=new Tasks(name,about,priority,status,CreateData,CloseData,OpenData);
//        int i = BookDao.save(bean);
//        if(i>0){
            out.println("<h3>Book saved successfully</h3>");
//        }
//        request.getRequestDispatcher("addbookform.jsp").include(request, response);
//        out.println("</div>");
//
//
//        request.getRequestDispatcher("footer.jsp").include(request, response);
//        out.close();
    }
}
