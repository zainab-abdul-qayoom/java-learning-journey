# Glossary: Java Environment & Ecosystem — Remember This

*(Simplified + grouped so it's easier to revise. Full official glossary has more, but these are the ones that actually matter.)*

## Core Java Engine
- **JVM** — runs Java bytecode, gives platform independence
- **JDK** — full toolkit to build + run Java apps
- **JRE** — environment to just run Java apps
- **Bytecode** — compiled Java code the JVM understands
- **ClassLoader** — loads classes into memory when needed
- **Garbage collection** — auto-cleans unused memory
- **Heap memory** — where objects live
- **Stack memory** — where method calls/local variables live

## OOP Concepts (important — repeats in every course)
- **Class** — blueprint for objects
- **Object** — instance of a class
- **Constructor** — special method that initializes an object
- **Inheritance** — child class gets features from parent (`extends`)
- **Polymorphism** — same method, different behavior
- **Encapsulation / Data hiding** — keep data private, access via methods
- **Abstract class/method** — can't be used directly, must be implemented by subclass
- **Interface** — blueprint of methods a class must implement
- **Overloading** — same method name, different parameters
- **Overriding** — subclass redefines parent's method
- **Static method** — belongs to class, not object

## Data & Variables
- **Primitive data type** — basic types: int, char, float, boolean
- **Variable** — named storage for data
- **Array** — fixed-size list of same-type values
- **String** — sequence of characters (immutable in Java)
- **Wrapper class** — object version of a primitive (e.g. Integer for int)
- **Casting** — converting one data type to another
- **Immutable vs Mutable** — can't change after creation vs can change

## Control Flow
- **if-else** — conditional execution
- **for / while / do-while loop** — repeat code
- **break** — exit loop early
- **continue** — skip to next loop iteration

## Exceptions (important — full module coming later)
- **Exception** — error that disrupts normal program flow
- **try-catch** — handle errors
- **finally block** — always runs, error or not
- **Checked exception** — must be handled/declared
- **NullPointerException** — trying to use a null object (very common bug)

## Collections (used a lot in real code)
- **List** — ordered collection, allows duplicates
- **HashMap** — key-value pair storage
- **Iterator** — used to loop through a collection

## Misc (good to recognize, not urgent to memorize)
- **Package** — groups related classes
- **Import statement** — brings in a package/class
- **Multithreading** — multiple tasks running at once
- **Thread** — a single unit of execution
- **JAR** — packaged Java app file

---

## 🧠 Extra — What matters most
- Don't try to memorize all 70+ terms from the real glossary — the ones above cover **90% of real interview + coding usage**.
- Focus hardest on: **JVM/JDK/JRE, OOP terms, try-catch, and List/HashMap** — these show up constantly.
- Terms like Applet, Reflection, Serialization are **rarely used in real beginner-level jobs** — just recognize them, don't stress over them.
