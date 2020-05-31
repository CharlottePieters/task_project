package be.ucll.task_project.service;

import be.ucll.task_project.domain.SubTask;
import be.ucll.task_project.domain.Task;
import be.ucll.task_project.dto.TaskDTO;
import be.ucll.task_project.dto.SubTaskDTO;
import be.ucll.task_project.repository.TaskRepository;
import be.ucll.task_project.repository.SubTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public List<TaskDTO> getTasks() {
        return taskRepository.findAll().stream().map(t -> {
            TaskDTO dto = new TaskDTO();
            dto.setId(t.getId());
            dto.setTitle(t.getTitle());
            dto.setDescription(t.getDescription());
            dto.setDate(t.getDate());
            dto.setSubTasks(t.getSubTasks());
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public TaskDTO getTask(String id) throws IllegalArgumentException {
        TaskDTO taskDTO = new TaskDTO();
        for (Task task : taskRepository.findAll()) {
            if (task.getId().equals(id)) {
                System.out.println("Subtasks grabbing from repo: " + task.getSubTasks().size());
                taskDTO.setId(id);
                taskDTO.setTitle(task.getTitle());
                taskDTO.setDescription(task.getDescription());
                taskDTO.setDate(task.getDate());
                taskDTO.setSubTasks(task.getSubTasks());
            }
        }
        return taskDTO;
    }


        /*TaskDTO taskDTO = new TaskDTO();
        for(TaskDTO task : this.getTasks()){
            if (id.equals(task.getId())){
                taskDTO = task;
            }
            else {
                throw new IllegalArgumentException("There is no task with this ID");
            }
        }
        return taskDTO;*/

    @Override
    public void addTask(TaskDTO taskDTO) {
        Task task = new Task();
        task.setId(taskDTO.getId());
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setDate(taskDTO.getDate());
        task.setSubTasks(taskDTO.getSubTasks());
        taskRepository.save(task);
    }

    @Override
    public void editTask(String id, TaskDTO newTask) {
        for (Task oldTask : taskRepository.findAll()) {
            if (oldTask.getId().equals(id)){
                oldTask.setTitle(newTask.getTitle());
                oldTask.setDescription(newTask.getDescription());
                oldTask.setDate(newTask.getDate());
                oldTask.setSubTasks(newTask.getSubTasks());
                taskRepository.save(oldTask);
            }
        }

    }


    @Override
    public void addSubTask(String id, SubTaskDTO subTaskDTO) {
        SubTask subTask = new SubTask();
        subTask.setId(subTaskDTO.getId());
        subTask.setTitle(subTaskDTO.getTitle());
        subTask.setDescription(subTaskDTO.getDescription());

        for (Task parent : taskRepository.findAll()){
            if (parent.getId().equals(id)){
                subTask.setParent(parent);
                System.out.println("Voor adding: " + parent.getSubTasks().size());
                parent.addSubTask(subTask);
                System.out.println("Na adding: " + parent.getSubTasks().size());
                subTaskRepository.save(subTask);
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
