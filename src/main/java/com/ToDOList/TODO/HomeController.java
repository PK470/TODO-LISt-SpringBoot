package com.ToDOList.TODO;

import com.ToDOList.TODO.model.Task;
import com.ToDOList.TODO.repository.TaskNotFoundException;
import com.ToDOList.TODO.repository.TodoRepository;
import com.ToDOList.TODO.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class HomeController {

    public TodoService getTodoService() {
        return todoService;
    }
    @Autowired
    public void setTodoService(TodoService todoService) {
        this.todoService = todoService;
    }

    private TodoService todoService;
    @Autowired
    private TodoRepository todoRepository;
    @RequestMapping("/")
    public String home(){
        return "home";
    }

    @RequestMapping("/add")
    public String addtask(){
        return "addTask";
    }



    @PostMapping("/add-task")
    public String addTask(@ModelAttribute Task task, RedirectAttributes redirectAttributes) {
        if(todoService.getByTitle(task.getTitle())) {
            redirectAttributes.addFlashAttribute("error", "Task already exists");
            redirectAttributes.addFlashAttribute("task", task);
            return "redirect:/add";
        }


        todoRepository.save(task);
        return "redirect:/";  // Redirect to the home page after saving
    }

    @RequestMapping("/list")
    public String getAllTask(Model model){

        List<Task> tasks = todoRepository.findAll();
        System.out.println(tasks.size());
        model.addAttribute("tasks", tasks);
        return "allTask";

    }
    @GetMapping("/list/{id}")
    public String getTask(@PathVariable Long id, Model model) {
        System.out.println(12);
        Task task = null;
        try {
            task = todoService.getTaskById(id);
        } catch (TaskNotFoundException e) {
            return "redirect:/";
        }
        model.addAttribute("task", task);
        return "taskDetail";
    }
    @RequestMapping(value={"/list/","/update/"})
    public String no_id(){
        return "redirect:/";
        }

    @GetMapping ("/update/{id}")
    public String updateTask(@PathVariable Long id, Model model){
        System.out.println(id);
        if(id == null){
            return "redirect:/";
        }
        Task task;
        try {
            task = todoService.getTaskById(id);
        } catch (TaskNotFoundException e) {
            return "/";
        }
        model.addAttribute("task",task);
        return "update";
    }
    @PostMapping("/updateTask")
    public String update(Task task){
        todoService.updateTask(task);

        return "redirect:/";
    }

}
