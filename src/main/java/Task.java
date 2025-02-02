public class Task {
    protected String description;
    protected boolean isDone;

    //constructor
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public void mark(boolean isDone) {
        this.isDone = isDone;
        System.out.println(isDone ? "Marked as Done!" : "Marked as Not Done!");
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " ");
    }

    public String getDescription() {
        return description;
    }
}