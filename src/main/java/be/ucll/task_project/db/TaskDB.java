package be.ucll.task_project.db;

import be.ucll.task_project.domain.Task;
import be.ucll.task_project.service.TaskService;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.UUID;

@Repository
public class TaskDB implements Serializable, TaskService {
    private HashMap<String, Task> tasks;

    public TaskDB() throws ParseException {
        this.tasks = new HashMap<String, Task>();
        this.addTask("Task 1", LocalDateTime.now());
        this.addTask("Task 2", LocalDateTime.now());
        this.addTask("Task 3", LocalDateTime.now());
    }

    public TaskDB(HashMap<String, Task> tasks){
        this.setTasks(tasks);
    }

    @Override
    public HashMap<String, Task> getTasks() {
        return tasks;
    }

    public void setTasks(HashMap<String, Task> tasks) {
        this.tasks = tasks;
    }

    private void addTask(String title, LocalDateTime date) throws ParseException {
        Task task = new Task(title, date);
        String uniqueID = UUID.randomUUID().toString();
        task.setId(uniqueID);
        this.tasks.put(uniqueID, task);
    }

    @Override
    public Task getTask(String id) throws IllegalArgumentException{
        if (this.tasks.containsKey(id)){
            return this.tasks.get(id);
        }
        else {
            throw new IllegalArgumentException("There is no task with this id.");
        }
    }

    @Override
    public void addTask(Task task){
        if (task.getId() == null){
            String uniqueID = UUID.randomUUID().toString();
            task.setId(uniqueID);
        }
        this.tasks.put(task.getId(), task);
    }

    @Override
    public void editTask(String id, Task newTask){
        this.tasks.put(id, newTask);
    }
}
