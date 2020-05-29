package be.ucll.task_project.service;

import be.ucll.task_project.dto.TaskDTO;
import be.ucll.task_project.dto.SubTaskDTO;

import java.util.HashMap;

public interface TaskService {

    HashMap<String, TaskDTO> getTasks();

    TaskDTO getTask(String id) throws IllegalArgumentException;

    void addTask(TaskDTO task);

    void editTask(String id, TaskDTO newTask);

    void addSubTask(TaskDTO parent, SubTaskDTO subTask);
}
