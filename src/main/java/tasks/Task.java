package tasks;

/**
 * Represents an abstract task with a description and completion status.
 */
public abstract class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Marks the task as done or not done.
     *
     * @param isDone True if the task is completed, false otherwise.
     */
    public void mark(boolean isDone) {
        this.isDone = isDone;
        System.out.println(isDone ? "Marked as Done!" : "Marked as Not Done!");
    }

    /**
     * Returns a status icon representing task completion.
     * "X" indicates the task is completed, while a space " " indicates it is not.
     *
     * @return A string representing the task's status.
     */
    public String getStatusIcon() {
        return (isDone ? "X" : " ");
    }

    /**
     * Gets the formatted task description, including its status icon.
     *
     * @return A formatted string representing the task.
     */
    public String getDescription() {
        return "[" + getStatusIcon()+ "] " + description;
    }

    /**
     * Converts the task into a file-friendly format for storage.
     *
     * @return A string representing the task in a storable format.
     */
    public abstract String toFileFormat();
}
