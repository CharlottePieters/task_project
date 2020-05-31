package be.ucll.task_project.dto;

import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public class SubTaskDTO {
    @NotNull
    @NotEmpty
    @GeneratedValue
    private UUID id;

    @NotNull
    @NotEmpty
    private String title;

    private String description;

    private TaskDTO parent;

    public SubTaskDTO(){
    }

    public SubTaskDTO(String title, String description){
        this.setTitle(title);
        this.setDescription(description);
    }

    public SubTaskDTO(String title, String description, TaskDTO parent){
        this.setTitle(title);
        this.setDescription(description);
        this.setParent(parent);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title.trim();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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
