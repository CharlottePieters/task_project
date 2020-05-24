package be.ucll.task_project.controller;

import be.ucll.task_project.domain.Task;
import be.ucll.task_project.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
        try{
            model.addAttribute("task", this.service.getTask(id));
        }
        catch (Exception e){
            model.addAttribute("error", e.getMessage());
        }
        return "taskDetail";
    }

    @GetMapping("/tasks/new")
    public String getCreateForm(Model model) {
        model.addAttribute("task", new Task());
        return "addTask";
    }

    @PostMapping("/tasks/new")
    public String addTask(@ModelAttribute @Valid Task task, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "addTask";
        }
        else {
            service.addTask(task);
            return "redirect:/tasks";
        }

    }

}
