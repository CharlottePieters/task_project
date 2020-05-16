package be.ucll.task_project.controller;

import be.ucll.task_project.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.Serializable;

@Controller
@RequestMapping("/tasks")
public class TaskController implements Serializable {
    private TaskService service;

    public TaskController(){}

    @Autowired
    public TaskController(TaskService taskService){
        this.service = taskService;
    }

    @GetMapping
    public String getTasks(Model model){
        model.addAttribute("tasks", this.service.getTasks());
        return "tasks";
    }
}
