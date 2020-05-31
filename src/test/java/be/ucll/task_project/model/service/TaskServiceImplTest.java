package be.ucll.task_project.model.service;


import be.ucll.task_project.domain.SubTask;
import be.ucll.task_project.domain.Task;
import be.ucll.task_project.dto.TaskDTO;
import be.ucll.task_project.service.TaskServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class TaskServiceImplTest {
	UUID id = UUID.randomUUID();

	@Autowired
	private TaskServiceImpl service;

	@BeforeEach
	public void setUpTaskDTO(){
		TaskDTO taskDTO = new TaskDTO();
		taskDTO.setId(id);
		taskDTO.setTitle("title");
		taskDTO.setDescription("description");
		taskDTO.setDate(LocalDateTime.of(2222, 02, 02, 22, 22));
		taskDTO.setSubTasks(new ArrayList<SubTask>());
		service.addTask(taskDTO);
	}

	@AfterEach
	public void cleanUp(){
		service.deleteTasks();
	}

	@Test
	public void testGetTasks() {
		List<TaskDTO> tasks = service.getTasks();

		assertNotNull(tasks);
		assertFalse(tasks.isEmpty());
		assertEquals(1, tasks.size());
		assertNotNull(tasks.get(0));
	}

	@Test
	public void testGetTask() {
		TaskDTO task = service.getTask(id);

		assertNotNull(task);
		assertEquals( "title", task.getTitle());
		assertEquals("description", task.getDescription());
		assertEquals(LocalDateTime.of(2222, 02, 02, 22, 22), task.getDate());
	}

	@Test
	public void testAddTask() {
		assertNotNull(this.service.getTasks());
		assertFalse(this.service.getTasks().isEmpty());
		assertEquals("id", this.service.getTask(id).getId());
		assertEquals("title", this.service.getTask(id).getTitle());
		assertEquals("description", this.service.getTask(id).getDescription());
		assertEquals(LocalDateTime.of(2222, 02, 02, 22, 22), this.service.getTask(id).getDate());
	}

	@Test
	public void testEditTask() {
		TaskDTO newTask = new TaskDTO();
		newTask.setTitle("newTitle");
		newTask.setDescription("newDescription");
		newTask.setDate(LocalDateTime.of(2222, 02, 12, 10, 12));
		service.editTask(id, newTask);

		TaskDTO adaptedTask = this.service.getTask(id);
		assertNotNull(adaptedTask);
		assertEquals("newTitle", adaptedTask.getTitle());
		assertEquals("newDescription", adaptedTask.getDescription());
		assertEquals(LocalDateTime.of(2222, 02, 12, 10, 12), adaptedTask.getDate());
	}
}
