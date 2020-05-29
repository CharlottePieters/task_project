package be.ucll.task_project.repository;

import be.ucll.task_project.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
