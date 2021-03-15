package com.example.ToDoList.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
    public static Connection getCon() {
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ToDoList",
                    "postgres", "postgres");
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }
}
