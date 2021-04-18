package com.example.ToDoList.register;

import java.sql.*;

public class RegisterDao {
    private String dbUrl = "jdbc:postgresql://localhost:5432/ToDoListRegister";
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

    public String insert(Member member){
        loadDriver(dbDriver);
        Connection con = getConnection();
        String result = "task-list.jsp";
        String sql = "insert into member values(?,?,?,?)";

        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,member.getUname());
            ps.setString(2,member.getPassword());
            ps.setString(3,member.getEmail());
            ps.setString(4,member.getPhone());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            result = "Data not entered";
        }
        return result;
    }

}
