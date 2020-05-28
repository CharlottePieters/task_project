package be.ucll.task_project.domain;


public class SubTask extends Task {
    private ParentTask parent;

    public SubTask(){}

    public SubTask(String title, String description){
        this.setTitle(title);
        this.setDescription(description);
    }

    public SubTask(String title, String description, ParentTask parent){
        this.setTitle(title);
        this.setDescription(description);
        this.setParent(parent);
    }

    public ParentTask getParent() {
        return parent;
    }

    public void setParent(ParentTask parent) {
        this.parent = parent;
    }
}
