# Video: Using Inner Classes in Java — Remember This

## What is an Inner Class
- A class defined **inside another class**
- Can directly access the outer class's members (variables/methods)
- Used to logically group classes that only make sense inside their outer class

## Basic Example
```java
class OuterClass {
    int outerVariable = 10;

    class InnerClass {
        void display() {
            System.out.println("Outer variable: " + outerVariable);
        }
    }
}
```
**Using it:**
```java
OuterClass outer = new OuterClass();
OuterClass.InnerClass inner = outer.new InnerClass();
inner.display();   // "Outer variable: 10"
```
👉 You need an **outer object first**, then create the inner object from it.

---

## 4 Types of Inner Classes

### 1. Non-static Inner Class (most common)
- Can access **both** static and non-static members of outer class
- Needs an outer class instance to exist (shown above)

### 2. Static Nested Class
- Declared with `static` keyword
- **Cannot** access non-static members of outer class directly
- **No outer instance needed** — create it directly:
```java
class OuterClass {
    static int staticVar = 20;

    static class StaticNestedClass {
        void show() {
            System.out.println("Static var: " + staticVar);
        }
    }
}
```
```java
OuterClass.StaticNestedClass nested = new OuterClass.StaticNestedClass();
nested.show();
```

### 3. Method-Local Inner Class
- Defined **inside a method** — only usable within that method
```java
void myMethod() {
    class MethodLocalInner {
        void display() {
            System.out.println("Inside Method Local Inner Class");
        }
    }
    MethodLocalInner inner = new MethodLocalInner();
    inner.display();
}
```

### 4. Anonymous Inner Class
- **No name** — used once, on the spot, usually to implement an interface quickly
```java
interface Greeting {
    void greet();
}

Greeting greeting = new Greeting() {
    public void greet() {
        System.out.println("Hello from Anonymous Inner Class!");
    }
};
greeting.greet();
```

---

## Real Example: Library and Book
```java
class Library {
    String libraryName = "City Library";

    class Book {
        String title, author;
        void displayBookInfo() {
            System.out.println("Library: " + libraryName + ", Book: " + title + " by " + author);
        }
    }
}
```
The `Book` inner class can access `libraryName` directly because it's inside `Library`.

## When Inner Classes Are Useful
- Encapsulation — hides implementation details
- Logical grouping — classes only relevant to their outer class
- Direct access to outer class members (no need to pass them around)
- **GUI event handling** — anonymous inner classes are common here
- Data structures — nodes in trees/linked lists

---

## 🧠 Extra — What matters most
- **Non-static vs static nested class is the key distinction to remember:** non-static needs an outer object and can see everything; static nested is independent and can only see static members.
- Anonymous inner classes are genuinely used a lot in real Java, especially for quick one-off interface implementations (like event listeners) — this is a preview of what Lambdas do more elegantly (you'll likely see that in a later course).
- Don't worry about memorizing all 4 types equally — **non-static and anonymous** are the two you'll actually encounter most in real code.
