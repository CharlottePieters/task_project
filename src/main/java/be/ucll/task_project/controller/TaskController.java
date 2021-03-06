package be.ucll.task_project.controller;

import be.ucll.task_project.dto.TaskDTO;
import be.ucll.task_project.dto.SubTaskDTO;
import be.ucll.task_project.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.UUID;

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
    public String getTaskDetail(Model model, @PathVariable("id") UUID id){
        try{
            TaskDTO taskDTO = this.service.getTask(id);
            System.out.println("Subtasks in getTaskDetail: " + taskDTO.getSubTasks().size());
            model.addAttribute("task", taskDTO);
        }
        catch (Exception e){
            model.addAttribute("error", e.getMessage());
        }
        return "taskDetail";
    }

    @GetMapping("/tasks/new")
    public String getCreateForm(Model model) {
        model.addAttribute("task", new TaskDTO());
        return "addTask";
    }

    @PostMapping("/tasks/new")
    public String addTask(@ModelAttribute("task") @Valid TaskDTO task, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            System.out.println("ERROR: " + bindingResult.getAllErrors());
            return "addTask";
        }
        else {
            service.addTask(task);
            return "redirect:/tasks";
        }
    }

    @GetMapping("tasks/edit/{id}")
    public String getEditForm(Model model, @PathVariable("id") UUID id){
        try{
            model.addAttribute("oldTask", this.service.getTask(id));
        }
        catch (Exception e){
            model.addAttribute("error", e.getMessage());
        }
        return "editTask";
    }

    @PostMapping("tasks/edit/{id}")
    public String editTask(@ModelAttribute("oldTask") @Valid TaskDTO newTask, BindingResult bindingResult, @PathVariable("id") UUID id) {
        if (bindingResult.hasErrors()){
            return "editTask";
        }
        else {
            service.editTask(id, newTask);
            return "redirect:/tasks/{id}";
        }
    }

    @GetMapping("tasks/{id}/sub/create")
    public String getAddSubTask(Model model, @PathVariable("id") UUID id){
        try{
            model.addAttribute("parentTask", this.service.getTask(id));
            model.addAttribute("subTask", new SubTaskDTO());
        }
        catch (Exception e){
            model.addAttribute("error", e.getMessage());
        }
        return "addSubTask";
    }

    @PostMapping("tasks/{id}/sub/create")
    public String addSubTask(@ModelAttribute("subTask") @Valid SubTaskDTO subTask, BindingResult bindingresult, @PathVariable("id") UUID id, Model model){
        if (bindingresult.hasErrors()){
            model.addAttribute("parentTask", this.service.getTask(id)); //zodat parentTask niet ”vergeten” wordt
            return "addSubTask";
        }
        else {
            service.addSubTask(id, subTask);
            System.out.println("Subtasks after adding to repo: " + this.service.getTask(id).getSubTasks().size());
            return "redirect:/tasks/{id}";
        }
    }

    @GetMapping("/")
    public String getIndex(){
        return "index";
    }


}
