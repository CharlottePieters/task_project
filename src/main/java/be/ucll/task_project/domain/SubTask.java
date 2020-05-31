package be.ucll.task_project.domain;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
public class SubTask {
    @NotNull
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    private String title;

    private String description;

    @ManyToOne
    private Task parent;

    public SubTask(){}

    public SubTask(String title, String description){
        this.setTitle(title);
        this.setDescription(description);
    }

    public SubTask(String title, String description, Task parent){
        this.setTitle(title);
        this.setDescription(description);
        this.setParent(parent);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Task getParent() {
        return parent;
    }

    public void setParent(Task parent) {
        this.parent = parent;
    }
}
