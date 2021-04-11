package com.example.ToDoList.login;

import com.example.ToDoList.register.Member;
import com.example.ToDoList.register.Register;
import com.example.ToDoList.register.RegisterDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Login", value = "/Login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname = request.getParameter("uname");
        String password = request.getParameter("password");
        ModelLogin member = new ModelLogin();
        member.setUsername(uname);
        member.setPassword(password);

        LoginBean loginBean = new LoginBean();

        if (loginBean.validate(member)){
            response.sendRedirect("register.jsp");
        }
        else  {
            response.sendRedirect("login.jsp");
        }
    }
}
