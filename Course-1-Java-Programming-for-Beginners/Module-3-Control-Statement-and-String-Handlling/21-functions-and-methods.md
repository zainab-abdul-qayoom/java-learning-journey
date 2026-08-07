# Video: Implementing Functions and Methods — Remember This

## Function vs Method (key distinction — asked in interviews)
- **Function** — standalone block of code, not tied to a class (rare in Java, more common in other languages)
- **Method** — a function that belongs to a class, tied to objects, can access instance variables

## Structure (same for both)
```
returnType methodName(parameters) {
    // code
    return value; // optional
}
```

## Example: Simple Function/Method
```java
int add(int a, int b) {
    return a + b;
}
```
Called as: `int sum = add(5, 3);` → sum = 8

## Method Inside a Class
```java
class Calculator {
    int multiply(int a, int b) {
        return a * b;
    }
}
```
Called as: `Calculator c = new Calculator(); c.multiply(2, 3);`

## Parameters vs Return Value
- **Parameter** — input value the method expects (e.g. `String name, int age`)
- **Return value** — the output the method gives back (specified by return type)

## void Method (no return value)
```java
void printMessage() {
    System.out.println("Hello World");
}
```

## Method Overloading (same name, different parameters)
```java
void show(int num) { ... }
void show(String text) { ... }
```
Java picks the right one based on what you pass in.

## Scope
- **Local scope** — variable only accessible inside its own method/block
- **Static scope** — belongs to the class, accessible throughout the class

---

## 🧠 Extra — What matters most
- **Method overloading** is a very common interview topic — remember: same name, different parameter list (type or count).
- `void` = no return value. If a method has a return type (int, String, etc.), it **must** return something matching that type.
- In real Java code, you'll almost always write **methods** (inside classes), not standalone functions — this connects directly to OOP, your next course.
