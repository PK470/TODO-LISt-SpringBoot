package com.ToDOList.TODO.repository;

import com.ToDOList.TODO.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class TodoRepository {

    private JdbcTemplate jdbc;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }
    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }
     public void save(Task t){
        String sql = "insert into task (title, description, assignTo, date, status) values(?,?,?,?,?) ";
        int row = jdbc.update(sql,t.getTitle(), t.getDescription(), t.getAssignTo(), t.getDate(), t.isStatus());

     }
     public List<Task> findAll(){
        String sql = "select * from task";

        return jdbc.query(sql,(rs, rowNum)->{
            Task t = new Task();
            t.setId(rs.getLong("id"));
            t.setTitle(rs.getString("title"));
            t.setDescription(rs.getString("description"));
            t.setAssignTo(rs.getString("assignTo"));
            t.setDate(rs.getString("date"));
            t.setStatus(rs.getBoolean("status"));

            return t;
        });
     }

    public Task findById(Long id) throws TaskNotFoundException {
        String sql = "Select * from task where id = ?";

       try {
           return jdbc.queryForObject(sql,new Object[]{id},(rs, rowNum)->{
               Task t = new Task();
               t.setId(rs.getLong("id"));
               t.setTitle(rs.getString("title"));
               t.setDescription(rs.getString("description"));
               t.setAssignTo(rs.getString("assignTo"));
               t.setDate(rs.getString("date"));
               t.setStatus(rs.getBoolean("status"));

               return t;
           });
       }
       catch (EmptyResultDataAccessException e){
           throw new TaskNotFoundException("Task with ID " + id + " not found");
       }

    }

    public void updateT(Task t){
        String sql = "Update task set title =?, description =?, assignTo = ?, date =?, status =? where id = ?";
        int row = jdbc.update(sql,t.getTitle(),t.getDescription(),t.getAssignTo(),t.getDate(),t.isStatus(), t.getId());
        System.out.println(t.getTitle()+" "+ row);

    }

    public boolean isTitle(String s) {
        String sql = "select count(*) from task where title = ?";
        int count = jdbc.queryForObject(sql,Integer.class, s);
        return count > 0;
    }
}
