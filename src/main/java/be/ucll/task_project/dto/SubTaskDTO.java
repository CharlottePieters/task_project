package be.ucll.task_project.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public class SubTaskDTO {
    @NotNull
    @NotEmpty
    private String id;

    @NotNull
    @NotEmpty
    private String title;

    private String description;

    private TaskDTO parent;

    public SubTaskDTO(){
        this.setId();
    }

    public SubTaskDTO(String title, String description){
        this.setTitle(title);
        this.setDescription(description);
        this.setId();
    }

    public SubTaskDTO(String title, String description, TaskDTO parent){
        this.setTitle(title);
        this.setDescription(description);
        this.setParent(parent);
        this.setId();
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

    public void setId() {
        this.id = UUID.randomUUID().toString();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskDTO getParent() {
        return parent;
    }

    public void setParent(TaskDTO parent) {
        this.parent = parent;
    }
}
