# Video: Understanding Inheritance in Java — Remember This

## What is Inheritance
- One class (**child/subclass**) derives properties & methods from another (**parent/superclass**)
- Promotes **code reuse** — no need to rewrite existing code
- Analogy: a smartphone inherits calling/texting from "Phone," adds its own features (apps, sensors)

## Key Terms
- **Superclass** — the parent, whose properties/methods are inherited
- **Subclass** — the child, inherits from superclass
- **extends** — keyword used to inherit

## Basic Example
```java
class Animal {
    String name;
    void eat() {
        System.out.println(name + " is eating");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println(name + " is barking");
    }
}
```
```java
Dog myDog = new Dog();
myDog.name = "Buddy";
myDog.eat();    // inherited from Animal
myDog.bark();   // defined in Dog
```

## Important Rule
- Subclass inherits **public** and **protected** members
- Subclass does **NOT** inherit **private** members

## Types of Inheritance
| Type | Meaning |
|---|---|
| **Single** | one class inherits from one superclass |
| **Multilevel** | chain — `Puppy extends Dog extends Animal` |
| **Hierarchical** | multiple subclasses from one superclass — `Dog` and `Cat` both extend `Animal` |
| **Multiple** | one class inherits from 2+ superclasses — **NOT supported directly in Java** (ambiguity), but achievable via **interfaces** |

## Method Overriding (subclass changes parent's behavior)
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
```
```java
Animal myDog = new Dog();
myDog.sound();   // prints "Dog barks" — even though declared as Animal!
```
This is called **runtime polymorphism** — comes up big in the next video.

## Real-World Uses
- Game dev — characters share base properties, unique abilities
- UI components — buttons/textboxes share behavior, implement specifics
- Data models — consistency across entities, unique fields per type

---

## 🧠 Extra — What matters most
- **Java doesn't support multiple inheritance directly** (to avoid ambiguity — if two parents had the same method, which one wins?) — but you CAN achieve similar flexibility using **interfaces**. This is a very common interview question.
- The last example (`Animal myDog = new Dog();` calling the Dog's overridden method) is a classic exam/interview trick — it shows Java uses the **actual object type** at runtime, not the declared type.
- Method overriding here connects directly to Polymorphism (your next video) — this is the mechanism that makes polymorphism work.
