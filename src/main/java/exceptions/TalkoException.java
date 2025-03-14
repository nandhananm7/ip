package exceptions;

/**
 * Exception class for handling errors specific to the Talko application.
 * A <code>TalkoException</code> is thrown when an invalid command is encountered
 * or when an error occurs during command execution.
 */
public class TalkoException extends Exception {
    public TalkoException(String message) {
        super(message);
    }
}