# Glossary: Advanced OOP Concepts — Remember This

*(Condensed + grouped — matches notes 06-09)*

## Inheritance
- **Superclass** — parent class, properties/methods get inherited
- **Subclass** — child class, inherits from superclass
- **extends** — keyword to inherit from a superclass
- **Single inheritance** — one class, one superclass
- **Multilevel inheritance** — chain of inheritance (A → B → C)
- **Hierarchical inheritance** — multiple subclasses from one superclass
- **Multiple inheritance** — one class inheriting from 2+ superclasses (not directly supported in Java — use interfaces instead)
- **Code reusability** — main benefit of inheritance, avoids rewriting code
- **Hierarchical classification** — organizing classes via inheritance
- **Organized code** — structuring classes into logical hierarchies

## Polymorphism
- **Polymorphism** — same interface, different behavior
- **Compile-time polymorphism** — method overloading (same class, different parameters)
- **Runtime polymorphism** — method overriding (subclass changes parent's method)
- **Method overriding** — child provides its own version of a parent method
- **Virtual method** — any method that CAN be overridden (all non-static methods by default)
- **Dynamic method resolution** — Java decides which method to run at runtime
- **Decoupling** — separating interface usage from its implementation

## Abstraction
- **Abstraction** — hiding complexity, exposing only essentials
- **Interface** — contract of method signatures (no body), supports multiple inheritance
- **Method signature** — declaration without body (used in interfaces)
- **Abstract class** — mix of abstract + concrete methods, single inheritance only
- **Main class** — where abstract methods get implemented and concrete behavior gets used

## Inner Classes
- **Inner class** — class defined inside another class
- **Non-static inner class** — accesses both static + non-static outer members
- **Static nested class** — only accesses static members, no outer instance needed
- **Method-local inner class** — defined inside a method, only usable there
- **Anonymous inner class** — no name, used once (often for interfaces/subclasses on the fly)

---

## 🧠 Extra — What matters most
- This whole module comes down to 3 pillars: **Inheritance (reuse), Polymorphism (flexibility), Abstraction (simplicity)** — plus inner classes as an organizational tool.
- If asked to compare **compile-time vs runtime polymorphism** in an interview, this is a guaranteed question — know it cold (overloading = compile-time, overriding = runtime).
- **Virtual method** is a term you'll rarely say out loud in real code, but it's the *mechanism* behind why overriding works — good to understand conceptually even if you don't use the word daily.
