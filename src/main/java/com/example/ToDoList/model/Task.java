package com.example.ToDoList.model;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

public class Task {
    public int Id;
    public String Name;
    public String About;
    public String Status;
    public String Priority;
    public Date  СreatedDate;
    public Date ClosedDate;
    public Date OpenedDate;

    public Task(int id, String name, String about, String status, String priority, Date сreatedDate, Date closedDate, Date openedDate) {
        Id = id;
        Name = name;
        About = about;
        Status = status;
        Priority = priority;
        СreatedDate = сreatedDate;
        ClosedDate = closedDate;
        OpenedDate = openedDate;
    }

    public Task(){

    }


    public int getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public String getAbout() {
        return About;
    }

    public String getStatus() {
        return Status;
    }


    public String getPriority() {
        return Priority;
    }

    public Date getСreatedDate() {
        return СreatedDate;
    }

    public Date getClosedDate() {
        return ClosedDate;
    }

    public Date getOpenedDate() {
        return OpenedDate;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setAbout(String about) {
        About = about;
    }
    public void setStatus(String status) {
        Status = status;
    }

    public void setPriority(String priority) {
        Priority = priority;
    }

    public void setСreatedDate(Date сreatedDate) {
        СreatedDate = сreatedDate;
    }

    public void setClosedDate(Date closedDate) {
        ClosedDate = closedDate;
    }

    public void setOpenedDate(Date openedDate) {
        OpenedDate = openedDate;
    }
}
