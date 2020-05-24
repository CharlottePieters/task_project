package be.ucll.task_project.domain;


import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

public class Task {
    private String id;
    private String title;
    private String description;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime date;

    public Task(){}

    public Task(String title, LocalDateTime date){
        this.setTitle(title);
        this.setDate(date);
        this.setDescription("This task has no description.");
    }

    public Task(String title, String description, LocalDateTime date){
        this.setTitle(title);
        this.setDescription(description);
        this.setDate(date);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title.trim();
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
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
        if (description == null){
            this.description = "This task has no description.";
        }
        else {
            if (description.trim().isEmpty()){
                this.description = "This task has no description.";
            }
            else{
                this.description = description;
            }
        }
    }
}
