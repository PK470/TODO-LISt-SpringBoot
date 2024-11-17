package com.ToDOList.TODO;

import com.ToDOList.TODO.model.Task;
import com.ToDOList.TODO.service.TodoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class TodoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(TodoApplication.class, args);
		/*Task task = new Task();

		// Set properties for the Task object
		task.setTitle("Complete To-Do List Project");
		task.setDescription("Implement all CRUD operations and test the API");
		task.setAssignTo("Alice");
		task.setDate("2024-11-17");
		task.setStatus(false);
		TodoService ts = context.getBean(TodoService.class);
		ts.addTask(task);*/
	}

}
