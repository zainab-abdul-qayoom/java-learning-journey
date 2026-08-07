# Checked vs Runtime Exceptions

## The one-line difference
Checked = Java checks it before your code even compiles.
Runtime (unchecked) = Java doesn't check it. Code compiles fine, it only blows up while running.

You already saw both in the lab: ArrayIndexOutOfBoundsException, NumberFormatException, NullPointerException were all runtime. CloneNotSupportedException was checked.

## Checked exceptions

What they are: exceptions the compiler forces you to deal with. If you don't, you get a compile error, not a runtime crash.

How you must handle them: either
- wrap in try-catch, or
- add `throws ExceptionName` to the method signature

What they represent: recoverable problems that come from outside your code's logic. Things like:
- a file not existing
- a database connection dropping
- a network call failing

Example from the video:

```java
File file = new File("nonexistentfile.txt");
try {
    Scanner sc = new Scanner(file);
} catch (FileNotFoundException e) {
    System.out.println("File not found.");
}
```

The file might genuinely not be there for reasons that have nothing to do with a bug in your code. That's the signature trait of a checked exception: it's a real-world condition, not a mistake in your program.

Common checked exceptions:
- `IOException` — file/network operations
- `FileNotFoundException` — missing file
- `ClassNotFoundException` — trying to load a class at runtime that isn't there

## Runtime (unchecked) exceptions

What they are: exceptions the compiler does NOT force you to handle. Code compiles whether you catch them or not.

What they represent: bugs or logic errors in your own code, not outside circumstances.

Example from the video:

```java
try {
    int result = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("Can't divide by zero.");
}
```

Dividing by zero is a mistake you made, not something that "just happens" from outside. That's the tell for a runtime exception.

Common runtime exceptions:
- `NullPointerException` — using an object reference that was never initialized
- `ArithmeticException` — invalid math, like divide by zero
- `ArrayIndexOutOfBoundsException` — accessing an index that doesn't exist

## Side-by-side

| | Checked | Runtime |
|---|---|---|
| Checked when | Compile time | Run time |
| Must you handle it | Yes, or compile error | No, optional |
| What it usually means | Something outside your code failed (file, network, DB) | A bug in your own code |
| Typical fix | try-catch or throws | Fix the logic |
| Examples | IOException, FileNotFoundException, ClassNotFoundException | NullPointerException, ArithmeticException, ArrayIndexOutOfBoundsException |

## Why Java bothers to split these into two categories

Checked exceptions exist to force discipline where failure is expected and recoverable:
- **Compile-time safety** — you can't ship code that ignores a known risk
- **Recoverable errors** — designed for things you can reasonably retry or work around
- **Clear API contracts** — a method's `throws` list tells you exactly what can go wrong when you call it
- **Defensive programming** — pushes you to think about failure paths up front

Runtime exceptions exist to keep the language usable without drowning every line in try-catch:
- **Simplicity** — you're not forced to handle every possible bug everywhere
- **Signals a programming error** — tells you to go fix the code, not just suppress the symptom
- **Performance** — no mandatory handling overhead in hot code paths
- **Control flow** — lets you build custom error signaling without cluttering normal logic

## The mental shortcut for quizzes
Ask yourself: "Is this failure caused by something outside my code (file, network, DB) or by a mistake inside my code (wrong index, null reference, bad math)?"
- Outside → checked
- Inside → runtime

That question alone will get you through almost every checked-vs-runtime question they throw at you.
