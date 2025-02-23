package tasks;

public class Deadline extends Task{
    private String by;

    public Deadline(String description, String by){
        super(description);
        this.by = by;
    }

    @Override
    public String getDescription() {
        return "[D]" + super.getDescription() + " (by: " + by + ")";
    }

    @Override
    public String toFileFormat() {
        return "D | " + (isDone ? "1" : "0") + " | " + description + " | " + by;
    }
}
