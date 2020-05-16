package be.ucll.task_project.controller;

import be.ucll.task_project.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.Serializable;

@Controller
public class TaskController implements Serializable {
    private TaskService service;

    public TaskController(){}

    @Autowired
    public TaskController(TaskService taskService){
        this.service = taskService;
    }

    @RequestMapping("/tasks")
    @GetMapping
    public String getTasks(Model model){
        model.addAttribute("tasks", this.service.getTasks());
        return "tasks";
    }

    @RequestMapping("tasks/{id}")
    @GetMapping
    public String getTaskDetail(Model model, @PathVariable("id") Integer id){
        try{
            model.addAttribute("task", this.service.getTask(id));
        }
        catch (IllegalArgumentException e){
            model.addAttribute("error", e.getMessage());
        }
        return "taskDetail";
    }
}
