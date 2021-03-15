package com.example.ToDoList.model;

public enum Status {
    New(0),
    Open(1),
    Close(2);

    private final int value;

    private Status(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}
