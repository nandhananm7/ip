package tasks;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents a task with a specific deadline.
 * A <code>Deadline</code> object stores a task description and a due date/time.
 */
public class Deadline extends Task {
    private LocalDateTime by;

    public Deadline(String description, String by) {
        super(description);
        this.by = parseDateTime(by); // Parse date string to LocalDateTime
    }

    /**
     * Parses a date-time string into a <code>LocalDateTime</code> object.
     *
     * @param by The date-time string in the format "yyyy-MM-dd HHmm".
     * @return A <code>LocalDateTime</code> object representing the parsed date and time.
     */
    private LocalDateTime parseDateTime(String by) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
        return LocalDateTime.parse(by, formatter);
    }

    /**
     * Formats a <code>LocalDateTime</code> object into a human-readable string.
     *
     * @param dateTime The <code>LocalDateTime</code> object to format.
     * @return A string representing the formatted date and time.
     */
    private String formatDateTime(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy, hh:mm a");
        return dateTime.format(formatter);
    }


    /**
     * Returns a string representation of the deadline task.
     *
     * @return A string containing the task type, status, description, and formatted deadline.
     */
    @Override
    public String getDescription() {
        return "[D]" + super.getDescription() + " (by: " + formatDateTime(by) + ")";
    }

    /**
     * Converts the deadline task into a file-friendly format.
     *
     * @return A string representation of the deadline task for storage.
     */
    @Override
    public String toFileFormat() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
        return "D | " + (isDone ? "1" : "0") + " | " + description + " | " + by.format(formatter);
    }
}
