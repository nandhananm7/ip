package tasks;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event extends Task {
    private LocalDateTime from;
    private LocalDateTime to;

    /**
     * Represents an event task with a start and end time.
     * An Event task has a description, a start time, and an end time.
     */
    public Event(String description, String from, String to) {
        super(description);
        this.from = parseDateTime(from); // Parse start time
        this.to = parseDateTime(to); // Parse end time
    }

    /**
     * Parses a date-time string into a LocalDateTime object.
     *
     * @param time The date-time string in "yyyy-MM-dd HH:mm" format.
     * @return Parsed LocalDateTime object.
     */
    private LocalDateTime parseDateTime(String time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
        return LocalDateTime.parse(time, formatter);
    }

    /**
     * Formats a LocalDateTime object into a user-friendly string.
     *
     * @param dateTime The LocalDateTime object to format.
     * @return A formatted date-time string.
     */
    private String formatDateTime(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy, hh:mm a");
        return dateTime.format(formatter);
    }

    /**
     * Returns the formatted string representation of the event task.
     *
     * @return A string representation of the event task including its type, status, description, and time range.
     */
    @Override
    public String getDescription() {
        return "[E]" + super.getDescription() + " (from: " + formatDateTime(from) + " to: " + formatDateTime(to) + ")";
    }

    /**
     * Converts the event object into a standardized file format for storage.
     *
     * @return A formatted string representation of the event task for file storage.
     */
    @Override
    public String toFileFormat() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
        return "E | " + (isDone ? "1" : "0") + " | " + description + " | " + from.format(formatter) + " | " + to.format(formatter);
    }
}
