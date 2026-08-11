# Video: Using Classes and Objects in Java — Remember This

## Class = Blueprint
```java
public class Car {
    String color;
    String model;
    int year;

    void displayInfo() {
        System.out.println(color + " " + model + " " + year);
    }
}
```

## Object = Instance of a Class
```java
Car myCar = new Car();       // declaration + instantiation
myCar.color = "Red";         // initialization
myCar.model = "Sedan";
myCar.year = 2024;
myCar.displayInfo();         // method call
```
- **Declaration** — `Car myCar` (reference variable)
- **Instantiation** — `new Car()` (creates the actual object in memory)
- **Initialization** — assigning values to attributes

## Subclass (Inheritance recap)
```java
class Animal { }
class Dog extends Animal {
    void bark() { }
}
```
- `extends` — subclass inherits from superclass (parent)
- Subclass gets parent's features + can add its own

---

## Access Modifiers (control WHO can see/use something)
| Modifier | Accessible From |
|---|---|
| `public` | Anywhere — any class, any package |
| `private` | Only within the same class |
| `protected` | Same package + subclasses (even in other packages) |
| *(default — no keyword)* | Only within the same package |

```java
public String model;      // accessible everywhere
private String color;     // hidden, only this class can touch it
protected int year;       // package + subclasses
String owner;              // default — package only
```

## Non-Access Modifiers (add extra behavior, not about visibility)
| Modifier | Meaning |
|---|---|
| `static` | Belongs to the class, not the object — shared across all instances, no object needed to access |
| `final` | Value can't change / method can't be overridden / class can't be extended |
| `abstract` | Class can't be instantiated directly, must be extended; abstract method has no body, subclass MUST implement it |

```java
static int totalCars;                 // shared counter across all Car objects
final int maxSpeed = 200;             // can't be changed

abstract class Shape {
    abstract void draw();             // no body — subclass must implement
}
class Circle extends Shape {
    void draw() {
        System.out.println("Drawing Circle");
    }
}
```

---

## 🧠 Extra — What matters most
- **`private` is the default good habit** — keep data private, expose access through public methods (this IS encapsulation, next video goes deep on it).
- **static** = shared across ALL objects (like a counter that tracks total objects created) — very common interview question: "what's the difference between static and instance variables?"
- **abstract class vs interface** confusion is common — for now just remember: abstract class = can't be instantiated, must be extended, and forces subclasses to implement certain methods.
- Access modifiers order (most to least restrictive): **private → default → protected → public**
