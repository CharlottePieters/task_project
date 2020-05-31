package be.ucll.task_project.service;

import be.ucll.task_project.dto.TaskDTO;
import be.ucll.task_project.dto.SubTaskDTO;

import java.util.List;

public interface TaskService {

    List<TaskDTO> getTasks();

    TaskDTO getTask(String id) throws IllegalArgumentException;

    void addTask(TaskDTO task);

    void editTask(String id, TaskDTO newTask);

    void addSubTask(String parentId, SubTaskDTO subTask);

    void deleteTasks();

    void deleteTask(String id);
}
