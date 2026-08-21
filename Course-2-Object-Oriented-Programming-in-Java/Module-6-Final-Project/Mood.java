import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A single mood entry: what the mood was, when it happened, and optional notes.
 */
public class Mood {
    private String name;
    private LocalDate date;
    private LocalTime time;
    private String notes;

    // Constructor 1: just a name -> uses right-now as the date/time, no notes.
    public Mood(String name) {
        this(name, LocalDate.now(), LocalTime.now(), "");
    }

    // Constructor 2: name + notes -> uses right-now as the date/time.
    public Mood(String name, String notes) {
        this(name, LocalDate.now(), LocalTime.now(), notes);
    }

    // Constructor 3: name + a specific date/time, no notes.
    public Mood(String name, LocalDate date, LocalTime time) {
        this(name, date, time, "");
    }

    // Constructor 4 (the "master" one): every other constructor forwards to this.
    public Mood(String name, LocalDate date, LocalTime time, String notes) {
        this.name = name;
        this.date = date;
        this.time = time;
        this.notes = notes;
    }

    // Simple getters so other classes can read the private fields.
    public String getName() { return name; }
    public LocalDate getDate() { return date; }
    public LocalTime getTime() { return time; }
    public String getNotes() { return notes; }

    // Setter so editMood() can update notes without creating a new object.
    public void setNotes(String notes) { this.notes = notes; }

    /**
     * Two Mood objects count as "the same mood" if they share a name, date, and time.
     * This is what lets us find/delete/edit a mood the user describes from the menu.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Mood)) return false;
        Mood other = (Mood) obj;
        return name.equalsIgnoreCase(other.name)
                && date.equals(other.date)
                && time.equals(other.time);
    }

    // Needed alongside equals() so Mood objects behave correctly in collections.
    @Override
    public int hashCode() {
        return (name.toLowerCase() + date + time).hashCode();
    }

    // Controls how a Mood prints with System.out.println(mood).
    @Override
    public String toString() {
        String base = "Mood: " + name + " | Date: " + date + " | Time: " + time;
        return notes.isEmpty() ? base : base + " | Notes: " + notes;
    }
}
