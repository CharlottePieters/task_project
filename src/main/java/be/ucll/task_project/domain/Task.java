package be.ucll.task_project.domain;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Task {
    private int id;
    private String title;
    private String description;
    private Date date;

    public Task(){}

    public Task(String title, Date date){
        this.setTitle(title);
        this.setDate(date);
        this.setDescription("This task has no description.");
    }

    public Task(String title, String date, String time) throws ParseException {
        this.setTitle(title);
        this.setDate(date, time);
        this.setDescription("This task has no description.");
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDate(String date,  String time) throws ParseException {  //date in ”dd/mm/yyyy” format; time in ”hh:mm” format
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date dateAsDate = dateFormat.parse(date + " " + time);
        this.date = dateAsDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
