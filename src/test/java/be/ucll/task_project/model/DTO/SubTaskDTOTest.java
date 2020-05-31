package be.ucll.task_project.model.DTO;

import be.ucll.task_project.domain.SubTask;
import be.ucll.task_project.dto.SubTaskDTO;
import be.ucll.task_project.service.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class SubTaskDTOTest {
    UUID id = UUID.randomUUID();


    @Test
    public void testSetId() {
        SubTaskDTO subTask = new SubTaskDTO();
        subTask.setId(id);

        assertNotNull(subTask.getId());
        assertEquals(id, subTask.getId());
    }

    @Test
    public void testSetTitle() {
        SubTaskDTO subTask = new SubTaskDTO();
        subTask.setTitle("title");

        assertNotNull(subTask.getTitle());
        assertEquals("title", subTask.getTitle());
    }

	@Test
	public void testGetTitle() {
		SubTaskDTO subTask = new SubTaskDTO();
		subTask.setTitle("title");
		String title = subTask.getTitle();

        assertNotNull(title);
        assertEquals("title", title);
	}

    @Test
    public void testSetDescription() {
        SubTaskDTO subTask = new SubTaskDTO();
        subTask.setDescription("description");

        assertNotNull(subTask.getDescription());
        assertEquals("description", subTask.getDescription());
    }

    @Test
    public void testGetDescription() {
        SubTaskDTO subTask = new SubTaskDTO();
        subTask.setDescription("description");
        String description = subTask.getDescription();

        assertNotNull(description);
        assertEquals("description", description);
    }
}
