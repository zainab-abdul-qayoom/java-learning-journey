# Module 4 Glossary (Grouped for Revision)

Reorganized from alphabetical into categories so related terms sit together. Definitions are paraphrased for quick recall, not word-for-word from the source.

## Big picture hierarchy
- **Throwable** — the root class. Everything that can be thrown in Java comes from here.
- **Error** — serious, unrecoverable problems (JVM-level, memory, stack). Not meant to be caught by your code.
- **Exception** — problems your app might reasonably want to catch and recover from.
- **Exception hierarchy** — the overall tree structure showing how Error and Exception (and their subtypes) all trace back to Throwable.

## Checked vs unchecked (the core split)
- **Checked exception** — compiler forces you to catch it or declare `throws`, or the code won't compile.
- **Unchecked exception** — compiler doesn't care, code compiles either way, only fails at runtime.
- **Custom exception** — your own exception class, made by extending `Exception` (checked) or `RuntimeException` (unchecked).

## Checked exceptions you'll see by name
- **ClassNotFoundException** — code tries to load a class by name and can't find it.
- **CloneNotSupportedException** — you call `.clone()` on an object whose class doesn't properly implement `Cloneable`.
- **EOFException** — code hits an unexpected end-of-file while reading input.
- **InterruptedException** — a thread gets interrupted while it's sleeping or waiting.

## Unchecked (runtime) exceptions you'll see by name
- **ArithmeticException** — bad math, classic case is dividing by zero.
- **ArrayIndexOutOfBoundsException** — you access an array index that doesn't exist.
- **IndexOutOfBoundsException** — the general parent exception for out-of-range index problems (arrays and lists both fall under this idea).
- **StringIndexOutOfBoundsException** — same idea as above, but specifically for invalid positions in a String.
- **NullPointerException** — you call a method or access a field on something that's null.
- **NumberFormatException** — you try to convert a string into a number, but the string isn't actually numeric (e.g. `Integer.parseInt("two")`).
- **ClassCastException** — you try to cast an object to a type it isn't compatible with.
- **IllegalArgumentException** — a method receives an argument that doesn't make sense for what it's supposed to do.
- **IllegalStateException** — a method gets called at a point where the object isn't in the right state for it.
- **IllegalThreadStateException** — a thread-specific version of the above, thread is in the wrong state for the operation being requested.
- **InputMismatchException** — input doesn't match the type your code expected (common with Scanner).
- **NegativeArraySizeException** — code tries to create an array with a negative length.
- **ConcurrentModificationException** — a collection gets modified while something is actively iterating over it.
- **Access control exception** — an operation is blocked because of insufficient permissions.
- **Abstract method error** — code tries to directly call an abstract method (should never happen if the code compiled correctly, usually signals a mismatch between compiled classes).

## Errors (JVM-level, not for your try-catch)
- **OutOfMemoryError** — the JVM's heap is full.
- **StackOverflowError** — the call stack got too deep, classic cause is infinite or runaway recursion.
- **AssertionError** — an assert statement failed (used in debugging/testing).

## try-catch-finally mechanics
- **Try block** — where you put code that might throw an exception.
- **Catch block** — where you handle a specific exception type if it happens.
- **Finally block** — runs no matter what, whether an exception happened or not.
- **Nested try block** — a try-catch inside another try-catch, for handling something more specific inside a broader attempt.
- **Multi-catch block** — one catch block that handles more than one exception type at once (separated by `|`).
- **Default exception handler** — what Java falls back to if nothing in your code catches the exception: it prints the stack trace and the program stops.

## Throwing exceptions yourself
- **Throw keyword** — actually raises an exception right now, in the code.
- **Throws keyword** — goes in a method signature to warn callers "this method might throw X."
- **Exception chaining** — when one exception is the underlying cause of another, and Java keeps track of that original cause instead of losing it.

## Threading-related (shows up alongside exceptions in this module)
- **Deadlock** — two or more threads are stuck forever, each waiting on a resource the other is holding.
- **Synchronized block** — restricts a section of code so only one thread can run it at a time, used to prevent race conditions.

## Loops and control flow (carried over from earlier modules, still relevant here)
- **For loop** — runs a fixed number of times.
- **Do-while loop** — runs the body at least once, checks the condition after.
- **Infinite loop** — a loop with no valid exit condition, runs forever.
- **Break statement** — exits a loop or switch immediately.
- **Continue statement** — skips the rest of the current iteration and moves to the next one.
- **Recursion** — a method that calls itself to break a problem into smaller pieces.
- **Logical error** — code runs and compiles fine but produces the wrong result. Not an exception, this is a plain bug in your logic.

## Fast recall trick for the quiz
If a term ends in "Exception" and it's about arrays, strings, math, null, casting, or bad input format, it's almost always unchecked (runtime).
If it's about files, classes not found, cloning, or threads waiting/interrupted, it's usually checked.
