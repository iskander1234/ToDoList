package com.example.ToDoList.login;

import com.example.ToDoList.register.Member;

import java.sql.*;

public class LoginBean {
    private String dbUrl = "jdbc:postgresql://localhost:5432/ToDoListLogin";
    private String dbUname = "postgres";
    private String dbPassword = "postgres";
    private String dbDriver = "org.postgresql.Driver";

    public void loadDriver(String dbDriver){
        try {
            Class.forName(dbDriver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection(){
        Connection con = null;
        try {
            con = DriverManager.getConnection(dbUrl, dbUname, dbPassword);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return con;
    }
    public boolean validate(ModelLogin login) {
        loadDriver(dbDriver);
        Connection con = getConnection();
        boolean result = false;

        String sql = "select * from  login where username=? and password=?";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,login.getUsername());
            ps.setString(2,login.getPassword());
            ResultSet rs = ps.executeQuery();
            result = rs.next();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }
}
