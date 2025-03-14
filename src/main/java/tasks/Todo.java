package tasks;

/**
 * Represents a Todo task, which is a simple task without additional details.
 */
public class Todo extends Task {
    public Todo(String description) {
        super(description);
    }

    /**
     * Retrieves the formatted description of the Todo task.
     *
     * @return A string representing the Todo task with its status.
     */
    @Override
    public String getDescription() {
        return "[T]" + super.getDescription();
    }

    /**
     * Converts the Todo task into a standardized file format for storage.
     *
     * @return A string representing the Todo task in a storable format.
     */
    @Override
    public String toFileFormat() {
        return "T | " + (isDone ? "1" : "0") + " | " + description;
    }
}
