package com.example.ToDoList.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int Id;
    public String Name;
    public String Description;
    public String Status;
    public String Priority;

    public Task(String name, String description, String status, String priority) {
        Name = name;
        Description = description;
        Status = status;
        Priority = priority;
    }

    public Task(int id, String name, String description, String status, String priority) {
        Id = id;
        Name = name;
        Description = description;
        Status = status;
        Priority = priority;
    }

    public Task() {

    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getPriority() {
        return Priority;
    }

    public void setPriority(String priority) {
        Priority = priority;
    }
}
