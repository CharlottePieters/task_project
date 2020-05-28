package be.ucll.task_project.db;

import be.ucll.task_project.domain.ParentTask;
import be.ucll.task_project.domain.SubTask;
import be.ucll.task_project.service.TaskService;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.UUID;

@Repository
public class TaskDB implements Serializable, TaskService {
    private HashMap<String, ParentTask> tasks;

    public TaskDB() {
        this.tasks = new HashMap<String, ParentTask>();
        this.addTask("Task 1", LocalDateTime.now());
        this.addTask("Task 2", LocalDateTime.now());
        this.addTask("Task 3", LocalDateTime.now());
    }

    public TaskDB(HashMap<String, ParentTask> tasks){
        this.setTasks(tasks);
    }

    @Override
    public HashMap<String, ParentTask> getTasks() {
        return tasks;
    }

    public void setTasks(HashMap<String, ParentTask> tasks) {
        this.tasks = tasks;
    }

    private void addTask(String title, LocalDateTime date) { //enkel voor vooraf toegevoegde taken
        ParentTask task = new ParentTask(title, date);
        String uniqueID = UUID.randomUUID().toString();
        task.setId(uniqueID);
        this.tasks.put(uniqueID, task);
    }

    @Override
    public ParentTask getTask(String id) throws IllegalArgumentException{
        if (this.tasks.containsKey(id)){
            return this.tasks.get(id);
        }
        else {
            throw new IllegalArgumentException("There is no task with this id.");
        }
    }

    @Override
    public void addTask(ParentTask task){
        if (task.getId() == null){
            String uniqueID = UUID.randomUUID().toString();
            task.setId(uniqueID);
        }
        this.tasks.put(task.getId(), task);
    }

    @Override
    public void editTask(String id, ParentTask newTask){
        ParentTask oldTask = this.getTask(id);
        oldTask.setTitle(newTask.getTitle());
        oldTask.setDescription(newTask.getDescription());
        oldTask.setDate(newTask.getDate());
    }

    @Override
    public void addSubTask(ParentTask parent, SubTask subTask){
        subTask.setParent(parent);
        parent.addSubTask(subTask);
    }
}
