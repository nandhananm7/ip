public class Event extends Task{
    private String from;
    private String to;

    public Event(String description, String from, String to){
        super(description);
        this.from = from;
        this.to = to;
    }

    @Override
    public String getDescription() {
        return "[E]" + super.getDescription() + " (from: " + from + " to: " + to + ")";
    }
}
