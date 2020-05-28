package be.ucll.task_project.service;

import be.ucll.task_project.domain.ParentTask;
import be.ucll.task_project.domain.SubTask;

import java.util.HashMap;

public interface TaskService {

    HashMap<String, ParentTask> getTasks();

    ParentTask getTask(String id) throws IllegalArgumentException;

    void addTask(ParentTask task);

    void editTask(String id, ParentTask newTask);

    void addSubTask(ParentTask parent, SubTask subTask);
}
