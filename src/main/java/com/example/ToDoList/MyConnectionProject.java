package com.example.ToDoList;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnectionProject implements MyProvider{
    static Connection con = null;

    public static Connection getCon(){
        try {
            Class.forName("org.postgresql.Driver");
            con= DriverManager.getConnection(connUrl, username, pwd);
        }catch (Exception e){
            System.out.println(e);
        }
        return con;
    }
}
