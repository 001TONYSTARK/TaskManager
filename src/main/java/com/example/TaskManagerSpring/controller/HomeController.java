package com.example.TaskManagerSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.TaskManagerSpring.model.Task;
import com.example.TaskManagerSpring.service.TaskService;

@Controller

public class HomeController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks")
  
    public String home(Model model) {
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "tasks"; // This will return tasks.html
    }
    
    @PostMapping("/tasks/add")
    public String createTask(Task task) {
        taskService.createTask(task);
        return "redirect:/tasks";
    }

    
   
}
