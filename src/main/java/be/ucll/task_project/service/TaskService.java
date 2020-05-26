package be.ucll.task_project.service;

import be.ucll.task_project.domain.Task;

import java.util.HashMap;

public interface TaskService {

    public HashMap<String, Task> getTasks();

    public Task getTask(String id) throws IllegalArgumentException;

    public void addTask(Task task);

    public void editTask(String id, Task newTask);

}
