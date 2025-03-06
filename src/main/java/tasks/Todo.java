package tasks;

public class Todo extends Task {
    public Todo(String description) {
        super(description);
    }

    //retrieve description of the to do
    @Override
    public String getDescription() {
        return "[T]" + super.getDescription();
    }

    //convert user input to a standardized file format
    @Override
    public String toFileFormat() {
        return "T | " + (isDone ? "1" : "0") + " | " + description;
    }
}
