package com.example.ToDoList.database;

import com.example.ToDoList.model.Task;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskDao {
    private static String dbUrl = "jdbc:postgresql://localhost:5432/TaskDao";
    private static String dbUname = "postgres";
    private static String dbPassword = "postgres";
    private static String dbDriver = "org.postgresql.Driver";


    private static final String INSERT_TASKS_SQL = "insert into tasks" + "(name, description, status, priority) values" +
            "(?,?,?,?);";
    private static final String SELECT_TASKS_BY_ID = "select id,name,description,status,priority  from  tasks  where id = ?";
    private static final String SELECT_ALL_TASKS = "select * from tasks";
    private static final String DELETE_TASKS_SQL = "delete from tasks where id = ?;";
    private static final String UPDATE_TASKS_SQL = "update tasks  set name = ? , description  = ?, status = ?, priority = ? where id = ?";

    public TaskDao() {
    }

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName(dbDriver);
            con = DriverManager.getConnection(dbUrl,dbUname,dbPassword);
        } catch (SQLException e) {
            System.out.println(e);
        }catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }

    //insert tasks

    public void insertTasks(Task task) throws  SQLException{
        System.out.println(INSERT_TASKS_SQL);
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TASKS_SQL)){
            preparedStatement.setString(1, task.getName());
            preparedStatement.setString(2, task.getDescription());
            preparedStatement.setString(3, task.getStatus());
            preparedStatement.setString(4, task.getPriority());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            printSQLException(e);
        }
    }

    public Task selectTask(int id) throws  SQLException{
        Task task = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TASKS_BY_ID)){
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                String name = rs.getString("name");
                String description = rs.getString("description");
                String status = rs.getString("status");
                String priority  = rs.getString("priority");
                task = new Task(id,name,description,status,priority);
            }
        }catch (SQLException e){
            printSQLException(e);
        }
        return task;
    }

    public List<Task> selectAllTask(){
        List<Task> tasks = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TASKS)){
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String status = rs.getString("status");
                String priority  = rs.getString("priority");
                tasks.add(new Task(id,name,description,status,priority));
            }
        }catch (SQLException e){
            printSQLException(e);
        }
        return tasks;
    }

    public boolean updateTask(Task task) throws SQLException{
        boolean rowUpdate;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_TASKS_SQL)){
            System.out.println("update Tasks :" +statement );
            statement.setInt(1, task.getId());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setString(4, task.getStatus());
            statement.setString(5, task.getPriority());

            rowUpdate = statement.executeUpdate() > 0;
        }
        return rowUpdate;
    }

    public boolean deleteTask(int id) throws SQLException{
        boolean rowDelete;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_TASKS_SQL)){
            statement.setInt(1,id);
            rowDelete = statement.executeUpdate() > 0;
        }
        return rowDelete;
    }

    private void printSQLException(SQLException ex){
        for (Throwable e :ex){
            e.printStackTrace(System.err);
            System.err.println("SQLState: " + ((SQLException) e).getSQLState());
            System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
            System.err.println("Message: " + e.getMessage());
            Throwable t = ex.getCause();
            while (t != null){
                System.out.println("Cause: " + t);
                t = t.getCause();
            }
        }
    }

}
