package be.ucll.task_project.domain;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public abstract class Task {
    private String id;

    @NotNull
    @NotEmpty
    private String title;

    private String description;

    public Task(){}

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
}
