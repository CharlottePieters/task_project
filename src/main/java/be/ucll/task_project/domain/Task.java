package be.ucll.task_project.domain;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Task {
    private String title;
    private Date date;

    public Task(){}

    public Task(String title, Date date){
        this.setTitle(title);
        this.setDate(date);
    }

    public Task(String title, String date, String time) throws ParseException {
        this.setTitle(title);
        this.setDate(date, time);
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
}
