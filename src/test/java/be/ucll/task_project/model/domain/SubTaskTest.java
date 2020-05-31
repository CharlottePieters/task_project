package be.ucll.task_project.model.domain;

import be.ucll.task_project.domain.SubTask;
import be.ucll.task_project.domain.Task;
import be.ucll.task_project.service.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class SubTaskTest {
	UUID id = UUID.randomUUID();


	@Test
	public void testSetID() {
		SubTask subTask = new SubTask();
		subTask.setId(id);

		assertNotNull(subTask.getId());
		assertEquals("id", subTask.getId());
	}

	@Test
	public void testSetTitle() {
		SubTask subTask = new SubTask();
		subTask.setTitle("title");

		assertNotNull(subTask.getTitle());
		assertEquals("title", subTask.getTitle());
	}
	@Test
	public void testSetDescription() {
		SubTask subTask = new SubTask();
		subTask.setDescription("description");

		assertNotNull(subTask.getDescription());
		assertEquals("description", subTask.getDescription());
	}

	@Test
	public void testSetParent() {
		SubTask subTask = new SubTask();
		Task parent = new Task();
		subTask.setParent(parent);

		assertNotNull(subTask.getParent());
		assertEquals(parent.getId(), subTask.getParent().getId());
	}
}
