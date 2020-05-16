package be.ucll.task_project.db;

import be.ucll.task_project.domain.Task;
import be.ucll.task_project.service.TaskService;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

@Repository
public class TaskDB implements Serializable, TaskService {
    private ArrayList<Task> tasks;

    public TaskDB() throws ParseException {
        this.tasks = new ArrayList<Task>();
        this.addTask("Task 1", "20/03/2020", "22:00");
        this.addTask("Task 2", "21/03/2020", "18:00");
        this.addTask("Task 3", "27/03/2020", "17:00");
    }

    public TaskDB(ArrayList<Task> tasks){
        this.setTasks(tasks);
    }

    @Override
    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    private void addTask(Task task){
        this.tasks.add(task);
    }
    private void addTask(String title, String date, String time) throws ParseException { //date in ”dd/mm/yyyy” format; time in ”hh:mm” format
        Task task = new Task(title, date, time);
        this.tasks.add(task);
    }
}
