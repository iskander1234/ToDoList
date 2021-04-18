package com.example.ToDoList.database;

import com.example.ToDoList.model.Task;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Taskdb {

    public static int save(Task bean){
        int status=0;
        try{
            Connection con= Database.getCon();
            PreparedStatement ps=con.prepareStatement("insert into Tasks values(?,?,?,?,?,?,?,?)");
            ps.setInt(1,bean.getId());
            ps.setString(2,bean.getName());
//            ps.setString(3,bean.getAbout());
//            ps.setString(4,bean.setPriority());
//            ps.setString(5,bean.setStatus());
//            ps.setDate(6,bean.setOpenedDate());
//            ps.setDate(7,bean.setClosedDate());
//            ps.setDate(8,bean.setСreatedDate());
            status=ps.executeUpdate();
            con.close();

        }catch(Exception e){System.out.println(e);}

        return status;
    }
    public static List<Task> view(){
        List<Task> list = new ArrayList<>();
        try{
            Connection con= Database.getCon();
            PreparedStatement ps=con.prepareStatement("select * from Tasks");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
//                Task bean = new Task();
//                bean.setId(rs.getInt(1));
//                bean.setName(rs.getString(2));
//                bean.setAbout(rs.getString(3));
//                bean.setPriority(rs.getString(4));
//                bean.setPriority(rs.getString(5));
//                bean.setOpenedDate(rs.getDate(6));
//                bean.setClosedDate(rs.getDate(7));
//                bean.setСreatedDate(rs.getDate(8));
//                list.add(bean);
            }
            con.close();
        }catch(Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public static int delete(int id){
        int status=0;
        try{
            Connection con= Database.getCon();
            PreparedStatement ps=con.prepareStatement("delete from Tasks where id=?");
            ps.setInt(1,id);
            status=ps.executeUpdate();
            con.close();
        }catch(Exception e)
        {
            System.out.println(e);
        }
        return status;
    }

    public static List<Task> viewById(int id){
        Task bean=new Task(id,"","","","");
        try{
            Connection con= Database.getCon();
            PreparedStatement ps=con.prepareStatement("select * from Tasks where id=?");
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
//                bean.setId(rs.getInt(1));
//                bean.setName(rs.getString(2));
//                bean.setAbout(rs.getString(3));
//                bean.setPriority(rs.getString(4));
//                bean.setPriority(rs.getString(5));
//                bean.setOpenedDate(rs.getDate(6));
//                bean.setClosedDate(rs.getDate(7));
//                bean.setСreatedDate(rs.getDate(8));
            }
            con.close();

        }catch(Exception e)
        {
            System.out.println(e);
        }
        return (List<Task>) bean;
    }

    public static int update(Task bean){
        int status=0;
        try{
            Connection con= Database.getCon();
            PreparedStatement ps=con.prepareStatement("update Tasks set name=?, where id=?");
            ps.setString(1,bean.getName());
//            ps.setString(3,bean.setAbout());
//            ps.setString(4,bean.setPriority());
//            ps.setString(5,bean.setStatus());
//            ps.setDate(6,bean.setOpenedDate());
//            ps.setDate(7,bean.setClosedDate());
//            ps.setDate(8,bean.setСreatedDate());
            status=ps.executeUpdate();
            con.close();

        }catch(Exception e){System.out.println(e);}

        return status;
    }
}
