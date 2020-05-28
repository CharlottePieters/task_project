package be.ucll.task_project.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ParentTask extends Task {
    private ArrayList<SubTask> subTasks;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime date;

    public ParentTask(){}

    public ParentTask(String title, LocalDateTime date){
        this.setTitle(title);
        this.setDate(date);
    }

    public ParentTask(String title, String description, LocalDateTime date){
        this.setTitle(title);
        this.setDescription(description);
        this.setDate(date);
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
