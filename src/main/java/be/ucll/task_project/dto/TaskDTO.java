package be.ucll.task_project.dto;

import be.ucll.task_project.domain.SubTask;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class TaskDTO {
    private String id;

    @NotNull
    @NotEmpty
    private String title;

    private String description;

    //@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime date;

    private ArrayList<SubTask> subTasks;

    public TaskDTO(){
        this.subTasks = new ArrayList<>();

    }

    public TaskDTO(String title, LocalDateTime date){
        this.setTitle(title);
        this.setDate(date);
        this.subTasks = new ArrayList<>();

    }

    public TaskDTO(String title, String description, LocalDateTime date){
        this.setTitle(title);
        this.setDescription(description);
        this.setDate(date);
        this.subTasks = new ArrayList<>();

    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title.trim();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public ArrayList<SubTask> getSubTasks() {
        return subTasks;
    }

    public void setSubTasks(ArrayList<SubTask> subTasks) {
        this.subTasks = subTasks;
    }

    public void addSubTask(SubTask subTask){
        if (this.subTasks == null){
            this.subTasks = new ArrayList<SubTask>();
        }
        this.subTasks.add(subTask);
    }
}
