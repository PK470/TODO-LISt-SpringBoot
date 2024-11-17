package com.ToDOList.TODO.repository;

public class TaskNotFoundException extends Exception {
    public TaskNotFoundException(String s) {
        super(s);
    }
}
