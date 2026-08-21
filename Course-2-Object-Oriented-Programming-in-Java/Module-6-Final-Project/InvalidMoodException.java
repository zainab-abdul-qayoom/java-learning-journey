/**
 * Thrown when the user tries to add a mood that already exists
 * (same name, date, and time as one already in the list).
 */
public class InvalidMoodException extends Exception {
    public InvalidMoodException() {
        super("This mood already exists in the tracker.");
    }

    public InvalidMoodException(String message) {
        super(message);
    }
}
