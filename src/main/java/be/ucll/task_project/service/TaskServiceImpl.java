package be.ucll.task_project.service;

import be.ucll.task_project.domain.SubTask;
import be.ucll.task_project.domain.Task;
import be.ucll.task_project.dto.TaskDTO;
import be.ucll.task_project.dto.SubTaskDTO;
import be.ucll.task_project.repository.TaskRepository;
import be.ucll.task_project.repository.SubTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final SubTaskRepository subTaskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository, SubTaskRepository subTaskRepository) {
        this.taskRepository = taskRepository;
        this.subTaskRepository = subTaskRepository;
    }

    @Override
    public HashMap<String, TaskDTO> getTasks() {
        return (HashMap<String, TaskDTO>) taskRepository.findAll().stream().map(t -> {
            TaskDTO dto = new TaskDTO();
            dto.setId(t.getId());
            dto.setTitle(t.getTitle());
            dto.setDescription(t.getDescription());
            dto.setDate(t.getDate());
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public TaskDTO getTask(String id) throws IllegalArgumentException {
        return this.getTasks().get(id);
    }

    @Override
    public void addTask(TaskDTO taskDTO) {
        Task task = new Task();
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setDate(taskDTO.getDate());
        task.setSubTasks(new ArrayList<SubTask>());
        taskRepository.save(task);
    }

    @Override
    public void editTask(String id, TaskDTO newTask) {
        for (Task oldTask : taskRepository.findAll()) {
            if (oldTask.getId() == id){
                oldTask.setTitle(newTask.getTitle());
                oldTask.setDescription(newTask.getDescription());
                oldTask.setDate(newTask.getDate());
                oldTask.setSubTasks(newTask.getSubTasks());
                taskRepository.save(oldTask);
            }
        }

    }


    @Override
    public void addSubTask(TaskDTO parentDTO, SubTaskDTO subTask) {
        for (Task parent : taskRepository.findAll()){
            if (parent.getId() == parentDTO.getId()){
                parent.addSubTask(subTask);
                taskRepository.save(parent);
            }
        }

    }

   /* public void deleteTasks() {
        taskRepository.deleteAll();
    }

    public void deleteTask(String id) {
        for (Task task : taskRepository.findAll()) {
            if (task.getId() == id) {
                taskRepository.delete(task);
            }
        }
    }*/
}
