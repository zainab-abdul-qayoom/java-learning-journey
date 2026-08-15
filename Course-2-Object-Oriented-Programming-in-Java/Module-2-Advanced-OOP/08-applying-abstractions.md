# Video: Applying Abstractions in Java — Remember This

## What is Abstraction
- **Hiding complex details**, exposing only what's essential
- Analogy: tapping an app icon — you don't see how it fetches cloud data, you just get the result
- Achieved in Java through **interfaces** and **abstract classes**

---

## Interfaces
- A **contract** — defines WHAT methods a class must have, not HOW they work
- Methods are **abstract by default** (no body) — implementing class must provide the body
- All methods are **public by default**
- **Cannot have** instance fields or constructors
- **Supports multiple inheritance** — a class can implement several interfaces

```java
interface Animal {
    void sound();     // no body — just a signature
}

class Dog implements Animal {
    public void sound() {
        System.out.println("Dog barks");
    }
}

class Cat implements Animal {
    public void sound() {
        System.out.println("Cat meows");
    }
}
```
**Real use cases:** Payment interface (`CreditCardPayment`, `PayPalPayment`), button click handlers in UI apps.

---

## Abstract Classes
- **Cannot be instantiated directly**
- Can have **both** abstract methods (no body, must be implemented) AND concrete methods (already have a body, can be reused/overridden)
- **Single inheritance only** — a class can extend just ONE abstract class

```java
abstract class Shape {
    abstract void draw();          // abstract — must implement

    void display() {                // concrete — shared, ready to use
        System.out.println("Displaying shape");
    }
}

class Circle extends Shape {
    void draw() {
        System.out.println("Drawing Circle");
    }
}
```
**Real use case:** `Vehicle` abstract class with shared `start()`/`stop()` methods, but each subclass (`Car`, `Truck`) must define its own `fuelType()`.

---

## Interface vs Abstract Class (the big comparison — memorize this table)

| | Interface | Abstract Class |
|---|---|---|
| Fields | Only constants | Can have regular fields |
| Methods | All abstract (until Java 8 default/static) | Mix of abstract + concrete |
| Inheritance | Multiple (`implements` several) | Single (`extends` only one) |
| Constructors | No | Yes |
| Use case | Define a contract/capability | Share common base behavior |

---

## Why Abstraction Matters
- **Simplifies** complex systems
- **Code reusability** — shared logic in abstract classes
- **Flexibility** — implementation can change without affecting users, as long as the interface stays the same
- **Supports polymorphism** — objects treated as their parent type

---

## 🧠 Extra — What matters most
- **This interface vs abstract class table is one of THE most common Java interview questions.** Be able to explain it without hesitation.
- Simple rule of thumb: **"Use an interface when unrelated classes need to share a capability (like Payment). Use an abstract class when related classes share common code (like Vehicle types)."**
- Multiple inheritance isn't allowed with classes in Java (remember from the Inheritance video) — but interfaces are Java's workaround for that limitation.
- You already used `implements Cloneable` in Course 1's exception lab — that's a real example of implementing an interface, now you know the theory behind it.
