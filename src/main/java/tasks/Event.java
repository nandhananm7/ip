package tasks;

public class Event extends Task{
    private String from;
    private String to;

    public Event(String description, String from, String to){
        super(description);
        this.from = from;
        this.to = to;
    }

    //get the description of the event
    @Override
    public String getDescription() {
        return "[E]" + super.getDescription() + " (from: " + from + " to: " + to + ")";
    }

    //convert user input to a standardized file format
    @Override
    public String toFileFormat() {
        return "E | " + (isDone ? "1" : "0") + " | " + description + " | " + from + " | " + to;
    }
}
