# Video: Using Encapsulation in Java — Remember This

## What is Encapsulation
- Bundling **data (attributes)** + **methods** together into one class
- **Restricts direct access** to data — only accessible through specific methods
- Analogy: a coffee machine — you press buttons (methods), you don't touch the internal wiring (private data)

## Why It Matters
- **Control** — data accessed/modified only in the right way
- **Flexibility** — change internal code without breaking other parts
- **Security** — protects sensitive data from unauthorized access

## The Standard Pattern: Private Fields + Getters/Setters
```java
public class Person {
    private String name;
    private int age;

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter
    public String getName() {
        return name;
    }

    // Setter (with validation)
    public void setAge(int age) {
        if (age < 0) {
            System.out.println("Age cannot be negative");
        } else {
            this.age = age;
        }
    }
}
```

**Usage:**
```java
Person p = new Person("Alice", 30);
p.getName();        // read value
p.setAge(-5);        // triggers validation error, blocks invalid data
```

## Real-World Uses
- **Banking** — hides sensitive account data, prevents unauthorized access
- **APIs** — expose only necessary methods, hide internal complexity
- **Thermostat/systems** — manage internal state, simple interface for the user
- **Cars** — complex engine logic hidden, user just calls `startEngine()`

---

## 🧠 Extra — What matters most
- **This is THE most practical OOP concept you'll actually use daily.** Private fields + public getters/setters is the standard way to write Java classes in real jobs.
- **Setters are where you put validation logic** — this is the real reason encapsulation matters, not just "hiding data" but **controlling what values are allowed**.
- One-line interview answer: *"Encapsulation means keeping data private and only allowing controlled access through public getter/setter methods — it protects data integrity and hides implementation details."*
- This connects directly to the `private` access modifier you learned last video — encapsulation is basically "using access modifiers properly."
