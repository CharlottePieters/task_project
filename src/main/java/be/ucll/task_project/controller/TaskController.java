package be.ucll.task_project.controller;

import be.ucll.task_project.domain.Task;
import be.ucll.task_project.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

@Controller
public class TaskController implements Serializable {
    private TaskService service;

    public TaskController(){}

    @Autowired
    public TaskController(TaskService taskService){
        this.service = taskService;
    }

    @GetMapping("/tasks")
    public String getTasks(Model model){
        model.addAttribute("tasks", this.service.getTasks());
        return "tasks";
    }

    @GetMapping("tasks/{id}")
    public String getTaskDetail(Model model, @PathVariable("id") String id){
        System.out.println("We zitten in de methode!");
        try{
            System.out.println("We zitten in de TRY");
            model.addAttribute("task", this.service.getTask(id));
        }
        catch (Exception e){
            System.out.println("We zitten in de CATCH");
            model.addAttribute("error", e.getMessage());
        }
        return "taskDetail";
    }

    @PostMapping("tasks/new")
    public String addTask(@ModelAttribute Task task, Model model){
        service.addTask(task);
        return this.getTasks(model);
    }

}
