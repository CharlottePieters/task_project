package be.ucll.task_project.service;

import be.ucll.task_project.domain.Task;

import java.util.ArrayList;

public interface TaskService {

    public ArrayList<Task> getTasks();

    public Task getTask(int id) throws IllegalArgumentException;

}
