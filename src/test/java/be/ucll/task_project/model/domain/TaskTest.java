package be.ucll.task_project.model.domain;

import be.ucll.task_project.domain.SubTask;
import be.ucll.task_project.domain.Task;
import be.ucll.task_project.dto.SubTaskDTO;
import be.ucll.task_project.service.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaskTest {
    UUID id = UUID.randomUUID();


    @Test
    public void testSetId() {
        Task task = new Task();
        task.setId(id);

        assertNotNull(task.getId());
        assertEquals("id", task.getId());
    }



    @Test
    public void testSetTitle() {
        Task task = new Task();
        task.setTitle("title");

        assertNotNull(task.getTitle());
        assertEquals("title", task.getTitle());
    }

    @Test
    public void testSetDescription() {
        Task task = new Task();
        task.setDescription("description");

        assertNotNull(task.getDescription());
        assertEquals("description", task.getDescription());
    }

    @Test
    public void testSetDate() {
        Task task = new Task();
        task.setDate(LocalDateTime.of(2222, 02, 02, 22, 22));

        assertNotNull(task.getDate());
        assertEquals(LocalDateTime.of(2222, 02, 02, 22, 22), task.getDate());
    }

    @Test
    public void testSetSubTasks() {
        Task task = new Task();
        List<SubTask> subTasks = new ArrayList<SubTask>();
        SubTask subTask = new SubTask();
        subTasks.add(subTask);

        task.setSubTasks(subTasks);

        assertNotNull(task.getSubTasks());
        assertFalse(task.getSubTasks().isEmpty());
        assertEquals(subTask, task.getSubTasks().get(0));
    }

    @Test
    public void testAddSubTask() {
        Task task = new Task();
        task.setSubTasks(new ArrayList<SubTask>());
        SubTaskDTO subTaskDTO = new SubTaskDTO();
        SubTask subTask = new SubTask();
        subTask.setId(subTaskDTO.getId());
        task.addSubTask(subTask);

        assertFalse(task.getSubTasks().isEmpty());
        assertNotNull(task.getSubTasks().get(0));
        assertEquals(subTask, task.getSubTasks().get(0));
    }
}
