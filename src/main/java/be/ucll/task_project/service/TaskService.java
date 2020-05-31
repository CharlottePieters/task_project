package be.ucll.task_project.service;

import be.ucll.task_project.dto.TaskDTO;
import be.ucll.task_project.dto.SubTaskDTO;

import java.util.List;
import java.util.UUID;

public interface TaskService {

    List<TaskDTO> getTasks();

    TaskDTO getTask(UUID id) throws IllegalArgumentException;

    void addTask(TaskDTO task);

    void editTask(UUID id, TaskDTO newTask);

    void addSubTask(UUID parentId, SubTaskDTO subTask);

    void deleteTasks();

    void deleteTask(UUID id);
}
