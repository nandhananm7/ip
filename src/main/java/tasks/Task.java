package tasks;

public abstract class Task {
    protected String description;
    protected boolean isDone;

    //constructor
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    //sets the task to completed
    public void mark(boolean isDone) {
        this.isDone = isDone;
        System.out.println(isDone ? "Marked as Done!" : "Marked as Not Done!");
    }

    //UI representation of completing a task
    public String getStatusIcon() {
        return (isDone ? "X" : " ");
    }

    //Get the description of the task
    public String getDescription() {
        return "[" + getStatusIcon()+ "] " + description;
    }

    public abstract String toFileFormat();
}