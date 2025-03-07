package tasks;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event extends Task {
    private LocalDateTime from;
    private LocalDateTime to;

    public Event(String description, String from, String to) {
        super(description);
        this.from = parseDateTime(from); // Parse start time
        this.to = parseDateTime(to); // Parse end time
    }

    private LocalDateTime parseDateTime(String time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
        return LocalDateTime.parse(time, formatter);
    }

    private String formatDateTime(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy, hh:mm a");
        return dateTime.format(formatter);
    }

    //get the description of the event
    @Override
    public String getDescription() {
        return "[E]" + super.getDescription() + " (from: " + formatDateTime(from) + " to: " + formatDateTime(to) + ")";
    }

    //convert user input to a standardized file format
    @Override
    public String toFileFormat() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
        return "E | " + (isDone ? "1" : "0") + " | " + description + " | " + from.format(formatter) + " | " + to.format(formatter);
    }
}
