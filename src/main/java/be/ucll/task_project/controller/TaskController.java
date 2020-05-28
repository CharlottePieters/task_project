package be.ucll.task_project.controller;

import be.ucll.task_project.domain.ParentTask;
import be.ucll.task_project.domain.SubTask;
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
        model.addAttribute("task", new ParentTask());
        return "addTask";
    }

    @PostMapping("/tasks/new")
    public String addTask(@ModelAttribute @Valid ParentTask task, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "addTask";
        }
        else {
            service.addTask(task);
            return "redirect:/tasks";
        }
    }

    @GetMapping("tasks/edit/{id}")
    public String getEditForm(Model model, @PathVariable("id") String id){
        try{
            model.addAttribute("oldTask", this.service.getTask(id));
        }
        catch (Exception e){
            model.addAttribute("error", e.getMessage());
        }
        return "editTask";
    }

    @PostMapping("tasks/edit/{id}")
    public String editTask(@ModelAttribute("oldTask") @Valid ParentTask newTask, BindingResult bindingResult, @PathVariable("id") String id) {
        if (bindingResult.hasErrors()){
            return "editTask";
        }
        else {
            service.editTask(id, newTask);
            return "redirect:/tasks/{id}";
        }
    }

    @GetMapping("tasks/{id}/sub/create")
    public String getAddSubTask(Model model, @PathVariable("id") String id){
        try{
            model.addAttribute("parentTask", this.service.getTask(id));
            model.addAttribute("subTask", new SubTask());
        }
        catch (Exception e){
            model.addAttribute("error", e.getMessage());
        }
        return "addSubTask";
    }

    @PostMapping("tasks/{id}/sub/create")
    public String addSubTask(@ModelAttribute("subTask") @Valid SubTask subTask, BindingResult bindingresult, @PathVariable("id") String id, Model model){
        if (bindingresult.hasErrors()){
            model.addAttribute("parentTask", this.service.getTask(id)); //zodat parentTask niet ”vergeten” wordt
            return "addSubTask";
        }
        else {
            ParentTask parentTask = this.service.getTask(id);
            service.addSubTask(parentTask, subTask);
            return "redirect:/tasks/{id}";
        }
    }

    @GetMapping("/")
    public String getIndex(){
        return "index";
    }


}
