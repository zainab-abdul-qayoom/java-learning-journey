# Final Project: Mood Tracker

A console-based mood journal built as the final project for this module,
applying core OOP principles (encapsulation, constructor overloading,
method overriding, custom exceptions) to a real interactive program
instead of an isolated exercise.

## What it does

The program lets a user keep a running journal of their moods over time:

- Add a mood — either for right now, or for a specific date/time entered
  by the user, with optional notes
- Edit the notes on a mood that's already been logged
- Delete every mood recorded on a given date
- Search either all moods on a given date, or one specific mood by
  name/date/time
- List every mood currently being tracked
- Export the full mood history to a `.txt` file

The menu loop keeps running until the user types `Exit`, so a single
session can add, edit, search, and export moods in any order.

## Concepts demonstrated

- **Encapsulation** `Mood`'s fields (`name`, `date`, `time`, `notes`) are
  all `private`. Other classes can only read them through getters, and
  only `notes` has a setter — a mood's identity (name/date/time) can't be
  changed once created, only its notes can be edited later. This is a
  deliberate design decision, not an accident.
- **Constructor overloading** `Mood` has 4 constructors with the same
  name but different parameter lists, so a mood can be created "just now,
  no notes," "just now, with notes," "specific date/time, no notes," or
  "everything specified." The first three all forward to the fourth via
  `this(...)`, so the actual field-setting logic exists in exactly one
  place (DRY).
- **Method overriding** `equals()`, `hashCode()`, and `toString()` are
  all overridden on `Mood`. Overriding `equals()` is what makes two moods
  count as "the same" by name + date + time (Java's default `equals()`
  only checks object identity), which is what powers edit/delete/search
  and duplicate detection.
- **Custom checked exception** `InvalidMoodException extends Exception`
  is thrown when a user tries to add a mood that's a duplicate (same
  name, date, and time as one already logged). Like `ItemNotFoundException`
  in the Grocery Shopping project, this turns a business rule ("no
  duplicate moods") into a self-documenting exception type instead of a
  generic one.
- **Safe deletion while iterating** `deleteMoods()` uses
  `ArrayList.removeIf()` rather than a `for-each` loop calling
  `.remove()` — modifying a list while a `for-each` loop is walking
  through it throws a `ConcurrentModificationException` in Java.
- **Try-with-resources for file I/O** `writeMoodsToFile()` opens its
  `PrintWriter`/`FileWriter` inside a `try (...)` block, so the file is
  guaranteed to close automatically even if an error happens mid-write.

## How to run

```bash
javac *.java
java MoodTracker
```

Follow the prompts: type a menu letter (`a`, `d`, `e`, `s`, `M`, or `w`)
and press Enter, then answer whatever the program asks for (mood name,
date in `MM/dd/yyyy`, time in `HH:mm:ss`, notes, etc.). Type `Exit` to
quit.

## Possible improvements

- Let the user delete or search by mood name alone, not just by exact
  date/time
- Persist moods between runs by loading from the exported `.txt` file on
  startup, instead of starting with an empty list every time
- Validate that a custom date/time isn't set in the future
- Add a dedicated summary option (e.g., how many times each mood was
  logged) using a `HashMap<String, Integer>`
