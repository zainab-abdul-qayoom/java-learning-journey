# MoodTracker — Full Beginner Walkthrough

This explains your project as if you're seeing Java for the first time. Read the
"OOP Concepts" section first — it explains the *vocabulary* your professor will
expect you to use when you present this. Then read the file-by-file walkthrough.

---

## Part 1: The Big Picture

Your program has **3 files**, and each one has **one job**:

| File | Job |
|---|---|
| `Mood.java` | Describes what a single "mood" *is* (a blueprint) |
| `InvalidMoodException.java` | A custom error message for one specific problem (duplicate moods) |
| `MoodTracker.java` | The actual program — shows the menu, reads what you type, runs everything |

Why 3 files instead of 1 giant file? Because in Java, this is the normal way to
organize a program. Each file matches one class, and each class has **one
responsibility**. This is a real OOP principle called **separation of concerns** —
your professor will like hearing that term. It also matches how the original
project asked for it: a `Mood` class, an exception class, and a runner class.

---

## Part 2: OOP Concepts You're Actually Using (in plain English)

### Class vs. Object
Think of `Mood` as a **cookie cutter**, not a cookie. The class `Mood` just
describes *what shape* a mood has (a name, a date, a time, notes). Every time you
write `new Mood(...)`, you're pressing the cutter into dough and making an
actual cookie — a real, individual mood. Each one of those is called an
**object** (or an **instance**).

So in your program:
```java
Mood moodToAdd = new Mood("Happy", moodDate, moodTime, "Great day");
```
`Mood` = the blueprint. `moodToAdd` = one specific mood object built from that blueprint.

### Encapsulation (hiding the data)
Look at `Mood.java`:
```java
private String name;
private LocalDate date;
```
`private` means: *nobody outside this class can touch these fields directly.*
If `MoodTracker.java` wants to know a mood's name, it can't do `mood.name` —
Java won't allow it. Instead it has to ask politely through a **getter method**:
```java
public String getName() { return name; }
```
This is called **encapsulation** — the data is "capsuled" inside the object, and
protected. Why bother? Because it stops other code from putting garbage into
your object by accident (like setting the date to `null` from some random place
in a 500-line program). All changes go through methods you control, like
`setNotes()`.

### Constructor Overloading
A **constructor** is a special method that runs when you create an object with
`new`. Your `Mood` class has **4 different constructors** — same method name
(`Mood`), but different sets of inputs:

```java
public Mood(String name)                                   // just a name
public Mood(String name, String notes)                     // name + notes
public Mood(String name, LocalDate date, LocalTime time)   // name + specific time
public Mood(String name, LocalDate date, LocalTime time, String notes) // everything
```

This is called **overloading** — same method name, different "shape" of inputs.
Java looks at *how many arguments you passed, and what type they are* to decide
which version to run. This lets the user create a mood in whatever way makes
sense (e.g., "just now, no notes" vs "a specific past date, with notes")
without you writing 4 separate class names.

Notice the first 3 constructors are lazy — they just call the 4th one for you:
```java
public Mood(String name) {
    this(name, LocalDate.now(), LocalTime.now(), "");
}
```
`this(...)` means "call another constructor in this same class." This avoids
repeating the same 4 lines of code in every constructor — a good habit called
**DRY** (Don't Repeat Yourself).

### Method Overriding (`equals`, `toString`, `hashCode`)
Every class in Java automatically comes with some built-in methods, including
`equals()` and `toString()`, but their default behavior is not useful for us.
By default, `equals()` just checks "is this literally the exact same object in
memory?" — it does NOT check "do these two moods have the same name/date/time?"

So we **override** it — meaning we replace Java's default version with our own:
```java
@Override
public boolean equals(Object obj) {
    ...
    return name.equalsIgnoreCase(other.name)
            && date.equals(other.date)
            && time.equals(other.time);
}
```
The `@Override` tag isn't required, but it's good practice — it tells Java
"I'm intentionally replacing a built-in method," and Java will yell at you with
an error if you typo the method name, which protects you from bugs.

`toString()` controls what shows up when you `System.out.println(someMood)`.
Without overriding it, printing a mood would show ugly text like
`Mood@1b6d3586`. With our override, it prints something readable:
`Mood: Happy | Date: 2026-08-20 | Time: 09:00 | Notes: Great day`.

`hashCode()` is a technical partner to `equals()` — Java's rule is: *if two
objects are equal, they must produce the same hashCode.* We don't strictly need
it for this project since we're not using hash-based collections
(`HashSet`, `HashMap`), but it's included so the class follows the rule
correctly, in case you ever store moods in one of those later.

### Inheritance (`extends`)
Look at `InvalidMoodException.java`:
```java
public class InvalidMoodException extends Exception {
```
`extends` means "InvalidMoodException **is a type of** Exception, and inherits
everything Exception can do." This is **inheritance** — one class building on
top of another. Because it extends `Exception`, Java lets you `throw` it and
`catch` it just like any real error, but it carries your own custom message:
`"This mood already exists in the tracker."`

### Custom Exceptions (why bother?)
Java already has generic exceptions, but a custom one like this makes your
code **self-documenting**. When you see:
```java
throw new InvalidMoodException();
```
you instantly know *what specifically* went wrong — a duplicate mood — instead
of a vague generic error. This is standard practice in real-world Java projects.

---

## Part 3: File-by-File Walkthrough

### `Mood.java` — the blueprint for one mood

```java
import java.time.LocalDate;
import java.time.LocalTime;
```
These `import` lines pull in Java's built-in date/time tools, so we don't have
to build our own date math from scratch.

```java
public class Mood {
    private String name;
    private LocalDate date;
    private LocalTime time;
    private String notes;
```
This declares the 4 pieces of data every mood object will carry. `private`
(as explained above) hides them from outside code.

The 4 constructors were already explained in Part 2.

```java
public String getName() { return name; }
public LocalDate getDate() { return date; }
public LocalTime getTime() { return time; }
public String getNotes() { return notes; }
public void setNotes(String notes) { this.notes = notes; }
```
These are **getters** (read a value) and one **setter** (change a value).
Notice there's no `setName`, `setDate`, or `setTime` — that's intentional. Once
a mood is created, its identity (name/date/time) shouldn't change; only the
notes can be edited later. This is a design decision, not an accident.

`equals()`, `hashCode()`, and `toString()` were explained above in Part 2.

---

### `InvalidMoodException.java` — a custom error

```java
public class InvalidMoodException extends Exception {
    public InvalidMoodException() {
        super("This mood already exists in the tracker.");
    }
```
`super(...)` calls the constructor of the parent class (`Exception`), passing
it the error message. This is how the message gets attached to the exception
object so that later, code can call `.getMessage()` on it and get that text back.

---

### `MoodTracker.java` — the actual running program

```java
static Scanner scanner = new Scanner(System.in);
```
A `Scanner` reads whatever the user types into the console. It's declared
`static` so that every method in this class can use the *same* Scanner object,
instead of each method trying to open its own connection to the keyboard
(which would cause bugs).

```java
public static void main(String[] args) {
```
Every Java program starts running from `main`. This is the entry point — the
very first code that executes when you run the program.

```java
ArrayList<Mood> moodsList = new ArrayList<>();
```
This creates an empty, growable list that can only hold `Mood` objects. Think
of it as a box that starts empty and can stretch to fit as many moods as the
user adds. The `<Mood>` part is called a **generic type** — it locks the list
so you can never accidentally put a `String` or a `Cat` object in there by mistake.

```java
boolean running = true;
while (running) {
    ...
}
```
This is the **main menu loop**. `while (running)` means: "keep repeating this
block over and over, as long as `running` is `true`." Every time through the
loop, it prints the menu and waits for the user to type a letter.

```java
switch (menuOption) {
    case "a":
        addMood(moodsList);
        break;
    ...
}
```
A `switch` statement is a cleaner way to write a long chain of `if / else if`.
Based on exactly what the user typed (`"a"`, `"d"`, `"e"`, etc.), it jumps to
the matching `case` and runs that code. `break` stops it from accidentally
"falling through" into the next case below it.

```java
case "Exit":
    System.out.println("Thank you for using the MoodTracker. Goodbye!");
    running = false;
    break;
```
This is the only place `running` gets set to `false`. Once that happens, the
`while (running)` loop notices on its next check and stops repeating — the
program falls out of the loop, hits `scanner.close()`, and `main` ends.

#### `addMood(moodsList)`
Walks the user through typing a mood name, whether it's for right now or a
custom date/time, and any notes. It builds a `Mood` object from what they
typed, then calls:
```java
if (isMoodValid(moodToAdd, moodsList)) {
    moodsList.add(moodToAdd);
```
`isMoodValid` loops through the existing list checking `.equals()` against
every mood already there. If it finds a match, it `throw`s the
`InvalidMoodException` — which immediately jumps out of the `try` block down
into the matching `catch`, skipping the `moodsList.add(...)` line entirely.
That's the whole point of exceptions: they interrupt normal flow the instant
something goes wrong, so you can't accidentally add a duplicate.

#### `deleteMoodMenu(moodsList)` and `deleteMoods(...)`
Asks for a date, then calls:
```java
return moodsList.removeIf(mood -> mood.getDate().equals(moodDate));
```
`removeIf` is a built-in ArrayList method: "go through every item, and remove
it if this condition is true." The part after the arrow (`->`) is called a
**lambda expression** — a short, throwaway function that just says "does this
mood's date match the one we're looking for?" It's the safe way to delete
while looping (a plain `for` loop that also calls `.remove()` on the same list
crashes the program in Java — that was one of the bugs in your original code).

#### `editMoodMenu(moodsList)` and `editMood(...)`
Asks for the mood's name/date/time (to *find* it) and new notes (to *change*
it). It builds a temporary `Mood` object purely as a "search key" — its notes
field is really the *new* notes you want applied. Then:
```java
for (Mood tempMood : moodsList) {
    if (tempMood.equals(moodToEdit)) {
        tempMood.setNotes(moodToEdit.getNotes());
        return true;
    }
}
```
It scans the real list for a mood that `.equals()` the search key (remember —
equals only checks name/date/time, not notes). Once found, it calls
`setNotes()` on the **real object already in the list**, updating it in place.

#### `searchMoodMenu`, `searchMoods`, `searchMood`
Two different search modes: search everything on a given date
(`searchMoods`, plural — loops and prints every match), or search for one
exact mood by name+date+time (`searchMood`, singular — stops at the first match).

#### `printAllMoods`
Just loops through the whole list and prints every mood. If the list is
empty, it says so instead of printing nothing silently — that's a small but
important usability touch (never leave the user guessing if something worked).

#### `writeMoodsToFile`
```java
try (java.io.PrintWriter writer = new java.io.PrintWriter(new java.io.FileWriter(fileName))) {
    for (Mood mood : moodsList) {
        writer.println(mood);
    }
}
```
This is called a **try-with-resources** block. `PrintWriter`/`FileWriter` open
a connection to a file on your computer's disk. Files are a limited resource —
if you forget to close them, your program can leak memory or lock the file so
nothing else can use it. Writing `try (...)` tells Java: "automatically close
this file the moment we're done with it, even if something goes wrong halfway
through." That's much safer than manually remembering to call `.close()`.

---

## Part 4: Bugs From the Original Code (in case you're asked)

If your professor asks "what was wrong with the starting code," here's your list:

1. **Code floating outside methods** — big chunks of logic were written directly
   inside the class body, not inside any method. Java requires all executable
   code to live inside a method (or constructor). This alone would stop the
   file from compiling at all.
2. **`scanner` used but never declared** — nothing ever created a `Scanner` object.
3. **`Mood` and `InvalidMoodException` classes were referenced everywhere but
   never defined** — like calling a phone number that was never assigned to anyone.
4. **Menu options had comments instead of code** (`//add code to add mood`) —
   so pressing any key would do nothing.
5. **`searchMood` (singular) was called but never existed** — only
   `searchMoods` (plural) was written.
6. **Deleting while looping with `for-each`** — calling `.remove()` on a list
   while a `for (Mood m : moodsList)` loop is walking through it throws a
   `ConcurrentModificationException` at runtime. Fixed using `removeIf()`.
7. **The `'w'` (write to file) menu option had zero code behind it.**

---

## Quick Glossary (for your presentation)

- **Class** — a blueprint describing what data and behavior something has.
- **Object / Instance** — one real "thing" built from a class using `new`.
- **Field** — a piece of data stored inside an object (e.g., `name`, `date`).
- **Method** — a chunk of behavior/code attached to a class.
- **Constructor** — special method that runs when an object is created.
- **Overloading** — multiple methods/constructors with the same name but
  different parameters.
- **Overriding** — replacing a built-in method (like `equals`) with your own version.
- **Encapsulation** — hiding fields as `private` and only exposing controlled
  access through getters/setters.
- **Inheritance** — one class (`InvalidMoodException`) building on another (`Exception`) using `extends`.
- **Exception** — an object representing "something went wrong," which can be
  `thrown` and `caught` to interrupt normal program flow safely.
