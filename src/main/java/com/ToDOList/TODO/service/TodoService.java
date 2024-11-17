package com.ToDOList.TODO.service;

import com.ToDOList.TODO.model.Task;
import com.ToDOList.TODO.repository.TaskNotFoundException;
import com.ToDOList.TODO.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    public TodoRepository getRs() {
        return rs;
    }
    @Autowired
    public void setRs(TodoRepository rs) {
        this.rs = rs;
    }

    private TodoRepository rs;


    public void addTask(Task t){

        rs.save(t);
    }

    public List<Task> getTask(){

        return rs.findAll();
    }

    public Task getTaskById(Long id) throws TaskNotFoundException {
            return rs.findById(id);

        }
    public void updateTask(Task t){
        rs.updateT(t);
    }
    public boolean getByTitle(String s){
        return rs.isTitle(s);
    }
    }

