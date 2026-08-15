# Video: Exploring Polymorphism — Remember This

## What is Polymorphism
- Objects share the **same interface** but behave **differently** based on their actual type
- Analogy: your fingerprint (one key) unlocks phone, marks attendance, authorizes payment — same "key," different roles depending on context

## Two Types of Polymorphism

### 1. Compile-Time Polymorphism (Method Overloading)
- Same method name, **different parameters** (number or type)
- Java decides which method to call **at compile time**
```java
class MathOperations {
    int add(int a, int b) {
        return a + b;
    }
    int add(int a, int b, int c) {
        return a + b + c;
    }
    double add(double a, double b) {
        return a + b;
    }
}
```
```java
MathOperations m = new MathOperations();
m.add(2, 3);        // calls int version
m.add(2, 3, 4);      // calls 3-param version
m.add(2.5, 3.5);     // calls double version
```

### 2. Runtime Polymorphism (Method Overriding)
- Subclass provides its **own version** of a method from the superclass
- Java decides which version to run **at runtime**, based on the actual object type — not the reference type
```java
class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Cat meows");
    }
}
```
```java
Animal myAnimal = new Dog();
myAnimal.sound();    // prints "Dog barks" — NOT "Animal makes a sound"

myAnimal = new Cat();
myAnimal.sound();    // prints "Cat meows"
```
👉 Even though `myAnimal` is declared as type `Animal`, Java runs the method based on the **actual object** (`Dog` or `Cat`), not the declared reference type.

## Virtual Methods
- Any method that **can be overridden** is called a "virtual method"
- **All non-static methods in Java are virtual by default**
- This is exactly what makes runtime polymorphism possible

## Why Polymorphism Matters
- **Code reusability** — write generic code that works with different object types
- **Decoupling** — separates the interface from the implementation
- **Dynamic behavior** — method behavior can change at runtime
- Widely used in **framework development** and large systems

---

## 🧠 Extra — What matters most
- **Overloading = compile-time, same class, different parameters.**
  **Overriding = runtime, subclass changes parent's method.**
  This distinction is asked in almost every Java interview — know it cold.
- The `Animal myAnimal = new Dog();` pattern is called **"programming to an interface"** — very common in real frameworks (Spring, etc.) and worth understanding deeply, not just memorizing.
- This video directly builds on last video's "method overriding" section — inheritance sets it up, polymorphism is why it matters.
