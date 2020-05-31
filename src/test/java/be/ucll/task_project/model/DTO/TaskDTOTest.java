package be.ucll.task_project.model.DTO;

import be.ucll.task_project.domain.SubTask;
import be.ucll.task_project.domain.Task;
import be.ucll.task_project.dto.TaskDTO;
import be.ucll.task_project.service.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaskDTOTest {
    UUID id = UUID.randomUUID();

    @Test
    public void testSetUsername() {
        TaskDTO task = new TaskDTO();
        task.setId(id);

        assertNotNull(task.getId());
        assertEquals(id, task.getId());
    }


    @Test
    public void testSetTitle() {
        TaskDTO task = new TaskDTO();
        task.setTitle("title");

        assertNotNull(task.getTitle());
        assertEquals("title", task.getTitle());
    }

    @Test
    public void testGetTitle() {
        TaskDTO task = new TaskDTO();
        task.setTitle("title");
        String title = task.getTitle();

        assertNotNull(title);
        assertEquals("title", title);
    }

    @Test
    public void testSetDescription() {
        TaskDTO task = new TaskDTO();
        task.setDescription("description");

        assertNotNull(task.getDescription());
        assertEquals("description", task.getDescription());
    }

    @Test
    public void testGetDescription() {
        TaskDTO task = new TaskDTO();
        task.setDescription("description");
        String description = task.getDescription();

        assertNotNull(description);
        assertEquals("description", description);
    }

    @Test
    public void testSetDate() {
        TaskDTO task = new TaskDTO();
        task.setDate(LocalDateTime.of(2222, 02, 02, 22, 22));

        assertNotNull(task.getDate());
        assertEquals(LocalDateTime.of(2222, 02, 02, 22, 22), task.getDate());
    }

    @Test
    public void testGetDate() {
        TaskDTO task = new TaskDTO();
        task.setDate(LocalDateTime.of(2222, 02, 02, 22, 22));
        LocalDateTime date = task.getDate();

        assertNotNull(date);
        assertEquals(LocalDateTime.of(2222, 02, 02, 22, 22), date);
    }

    @Test
    public void testSetSubTasks() {
        TaskDTO task = new TaskDTO();
        List<SubTask> subTasks = new ArrayList<SubTask>();
        SubTask subTask = new SubTask();
        subTasks.add(subTask);
        task.setSubTasks(subTasks);

        assertNotNull(task.getSubTasks());
        assertFalse(task.getSubTasks().isEmpty());
        assertEquals(subTask, task.getSubTasks().get(0));
    }

	@Test
	public void testGetSubTasks() {
		TaskDTO task = new TaskDTO();
		List<SubTask> subTasks = new ArrayList<SubTask>();
		SubTask subTask = new SubTask();
		subTasks.add(subTask);
		task.setSubTasks(subTasks);
		List<SubTask> subTasksToTest = task.getSubTasks();

		assertNotNull(subTasksToTest);
		assertFalse(subTasksToTest.isEmpty());
		assertEquals(subTask, subTasksToTest.get(0));
	}

    @Test
    public void testAddSubTask() {
        TaskDTO task = new TaskDTO();
        SubTask subTask = new SubTask();
        task.addSubTask(subTask);

        assertNotNull(task.getSubTasks());
        assertFalse(task.getSubTasks().isEmpty());
        assertEquals(subTask, task.getSubTasks().get(0));
    }
}
