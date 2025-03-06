package tasks;

public class Deadline extends Task{
    private String by;

    public Deadline(String description, String by){
        super(description);
        this.by = by;
    }

    //get the description of the deadline
    @Override
    public String getDescription() {
        return "[D]" + super.getDescription() + " (by: " + by + ")";
    }

    //convert user input to a standardized file format
    @Override
    public String toFileFormat() {
        return "D | " + (isDone ? "1" : "0") + " | " + description + " | " + by;
    }
}
