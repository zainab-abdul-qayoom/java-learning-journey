# Course-Level Glossary (Grouped for Revision)

Full course glossary reorganized into categories. Module 4's exception-specific terms are already covered in `30-glossary-module4.md`, this file adds everything else from across the whole course, plus a few advanced terms the glossary included as a preview of what's coming in later courses.

## Java platform basics
- **JVM (Java Virtual Machine)** — executes Java bytecode, gives Java its "write once, run anywhere" ability.
- **JDK (Java Development Kit)** — full toolkit for building Java apps, includes the compiler.
- **JRE (Java Runtime Environment)** — just what's needed to run (not build) Java apps.
- **Bytecode** — the platform-independent code the compiler produces, run by the JVM.
- **ClassLoader** — part of the JRE that loads classes into memory as needed.
- **Garbage collection** — Java automatically freeing up memory that's no longer in use.
- **Heap memory** — where objects live once created.
- **Stack memory** — where method calls and local variables live temporarily.
- **Entry point** — the `main` method, where a Java program starts running.
- **Main class** — the class containing that `main` method.
- **JAR (Java Archive)** — a packaged bundle of compiled classes and resources.
- **Module** — Java 9+ feature for organizing large codebases into clear dependency units.

## Variables, types, and casting
- **Primitive data type** — a basic built-in type like `int`, `char`, `float`, `boolean`.
- **Variable** — a named container for a value.
- **Local variable** — only exists inside the method or block where it's declared.
- **Static variable** — belongs to the class itself, shared across all instances.
- **Wrapper class** — an object version of a primitive type (e.g. `Integer` wraps `int`).
- **Autoboxing** — Java automatically converting a primitive into its wrapper class.
- **Casting / type casting** — converting one data type into another.
- **Explicit casting** — a conversion you have to write out yourself, Java won't do it silently.
- **var** — Java 10+ keyword letting the compiler infer a local variable's type.
- **Immutable / immutable object** — can't be changed after creation (Strings are the classic example).
- **Mutable object** — can be changed after creation.

## Classes, objects, and OOP fundamentals
(You'll go deeper on these in Course 2, this is the vocabulary preview.)
- **Class** — the blueprint for creating objects.
- **Object** — an actual instance created from a class, holding real data.
- **Object instantiation** — the act of creating that instance with `new`.
- **Class attribute** — a variable declared inside a class to hold object data.
- **Constructor** — special method that runs when an object is created, to set it up.
- **Method** — a block of code inside a class that performs a task.
- **Instance method** — requires an actual object to call it.
- **Static method** — belongs to the class itself, callable without creating an object.
- **Method signature** — a method's name plus its parameter list, what uniquely identifies it.
- **Method overloading** — multiple methods, same name, different parameter lists.
- **Method overriding** — a subclass redefining a method that its parent class already has.
- **this keyword** — refers to the current object instance from inside its own class.
- **new keyword** — used to actually create an object.
- **Encapsulation / data encapsulation** — keeping an object's internal data private and controlling access through methods.
- **Data hiding** — the specific practice of making fields private so outside code can't touch them directly.
- **Abstraction** — hiding implementation detail, exposing only what's needed to use something.
- **Inheritance** — a class taking on properties and behavior from a parent class.
- **extends keyword** — used by a class to inherit from another.
- **Parent class / Child class** — the class being inherited from / the class doing the inheriting.
- **Polymorphism** — the same method call behaving differently depending on the actual object type.
- **Dynamic binding** — deciding which method implementation to run at runtime, not compile time, what makes polymorphism work.
- **Abstract class** — can't be instantiated directly, may contain abstract methods.
- **Abstract method** — declared but has no body, subclasses must implement it.
- **Interface** — a contract of method signatures a class agrees to implement.
- **implements keyword** — used by a class to fulfill an interface's contract.
- **Nested class** — a class defined inside another class.
- **final class** — cannot be extended by any subclass.
- **final keyword** — also used for constants and preventing method overriding.
- **super keyword** — refers to the parent class from inside a subclass.

## Access and scope
- **Access modifier** — controls visibility: `public`, `private`, `protected`.
- **Public access modifier** — accessible from anywhere.
- **Private access modifier** — accessible only within the same class.
- **Scope** — where in the program a variable or method can actually be used.

## Arrays and collections
- **Array** — a fixed-size collection of same-type elements.
- **ArrayList** — a resizable list implementation, unlike a plain array.
- **List** — a collection interface that keeps order and allows duplicates.
- **HashMap** — stores key-value pairs for fast lookup by key.
- **Deque** — a double-ended queue, insert/remove from either end.
- **Iterator** — an object that lets you step through a collection's elements one at a time.
- **Generics / Generic class** — lets a class or method work with different types safely, without casting everywhere.
- **Comparable** — interface for defining an object's natural sort order.
- **Comparator** — interface for defining a custom sort order.

## Strings
- **String** — an immutable sequence of characters.
- **String literal** — creating a string by just writing text in double quotes.
- **charAt** — get the character at a specific index.
- **length method** — get how many characters are in a string.
- **substring** — extract a portion of a string.
- **split** — break a string apart into an array based on a delimiter.
- **join** — combine array elements back into a single string.
- **replace** — swap out a character or substring for another.
- **trim** — strip whitespace from both ends.
- **toUpperCase / toLowerCase** — change case.
- **equals method** — compare string (or object) content for equality.
- **Concatenation** — joining two or more strings together.

## Control flow
- **if-else** — branch based on a condition.
- **switch** — branch across multiple possible values of one variable.
- **for loop** — repeat a fixed number of times.
- **while loop** — repeat while a condition holds.
- **do-while loop** — same as while, but guarantees at least one run.
- **Infinite loop** — a loop that never meets its exit condition.
- **Break statement** — exits a loop or switch immediately.
- **Continue statement** — skips to the next iteration.
- **Loop** — general term for any repeating control structure.
- **Recursion** — a method calling itself to break a problem down.
- **Logical error** — code that runs fine but gives a wrong result, not an exception.

## I/O and utility packages
- **java.io** — package for input/output operations.
- **java.lang** — Java's core built-in classes, always available.
- **java.net** — networking capabilities.
- **java.sql** — database connectivity.
- **java.time** — modern date/time handling (Java 8+).
- **java.util** — utility classes, data structures, algorithms.
- **JDBC** — API specifically for talking to databases.
- **Scanner class** — reads input from the user.
- **nextInt / nextLine methods** — Scanner methods for reading an integer or a full line.
- **BufferedReader** — efficient reading of text input streams.
- **InputStream / OutputStream** — reading/writing raw byte streams.
- **File** — represents a file or directory path.
- **Serialization / Deserialization** — converting an object to a byte stream and back, for saving or transmitting it.

## Comments and documentation
- **Comment** — non-executed note in code, for humans.
- **Single-line comment** — starts with `//`.
- **Multi-line comment** — wrapped in `/* */`.
- **Documentation comment** — special `/** */` format used by tools like Javadoc.
- **Clarity, Collaboration, Maintenance** — the three benefits comments provide: easier understanding, easier teamwork, easier future edits.

## Concurrency (preview vocabulary)
- **Thread** — a lightweight unit of execution that can run concurrently with others.
- **Multithreading** — running multiple threads at once.
- **Synchronized block / synchronized keyword** — restricts a section of code to one thread at a time.
- **Deadlock** — two or more threads stuck forever waiting on each other.
- **volatile** — ensures a variable is always read fresh from main memory, not a cached copy.

## Newer Java features (preview vocabulary)
- **Lambda expression** — compact syntax for writing anonymous functions.
- **Stream** — sequence of elements supporting chained, functional-style operations.
- **Optional** — container type for safely handling potentially-null values.
- **Record** — compact syntax (Java 14+) for simple immutable data classes.
- **Annotation** — metadata tag that gives the compiler or runtime extra information.
- **Reflection** — a program inspecting or modifying its own structure at runtime.
- **REST** — an architecture style for web services using HTTP.

## Errors and misc
- **Applet** — an old-style Java program meant to run inside a browser, largely obsolete now.
- **Random class** — generates random numbers.
- **Math class** — provides functions like `sqrt`, `pow`, `abs`.
- **Source file naming** — each public class must live in its own file, named exactly after the class.
