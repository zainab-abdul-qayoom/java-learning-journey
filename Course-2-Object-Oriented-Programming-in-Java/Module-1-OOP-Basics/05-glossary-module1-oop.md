# Glossary: OOP Basics in Java — Remember This

*(Condensed + grouped — matches what you've already covered in notes 01-04)*

## Class & Object Basics
- **Class** — blueprint for creating objects
- **Object** — instance of a class, represents a real-world entity
- **Properties** — characteristics/attributes of an object
- **Methods** — actions an object can perform

## Object Creation Steps
- **Declaration** — defines a reference variable (`Car myCar`)
- **Instantiation** — creates the actual object (`new Car()`)
- **Initialization** — assigns values to attributes
- **Method call** — invoking a method on the object

## Constructors
- **Constructor** — initializes an object's attributes when created
- **Default constructor** — auto-provided by Java if no constructor is written
- **No-arg constructor** — constructor with no parameters, sets default values
- **Parameterized constructor** — accepts values to customize initialization

## Access Modifiers (visibility control)
- **Public** — accessible from anywhere
- **Private** — accessible only within same class
- **Protected** — same package + subclasses
- **Default** — same package only (no keyword needed)

## Non-Access Modifiers (behavior, not visibility)
- **Static** — belongs to class, not instance; no object needed to access
- **Final** — value/method/class can't be changed, overridden, or extended
- **Abstract** — class can't be instantiated, must be extended; abstract method has no body, subclass must implement it

## Core OOP Concepts
- **Encapsulation** — bundling data + methods, restricting direct access
- **Data hiding** — keeping data private, preventing unauthorized access
- **Getter method** — reads a private value
- **Setter method** — modifies a value, often with validation
- **Inheritance** — creating new classes from existing ones
- **Subclass** — inherits from a superclass, can add/modify features
- **Polymorphism** — same interface, different behavior per object type

## Security Note (recognize, not urgent)
- **Buffer overflow** — a vulnerability where a program writes more data than a buffer can hold. *(Not directly related to constructors — just a general security term that appeared in this glossary.)*

---

## 🧠 Extra — What matters most
- The 4 object creation steps (**declare → instantiate → initialize → call**) is a good mental checklist any time you're unsure how object creation works.
- **Encapsulation = private fields + public getters/setters** — if you remember this one line, most of this glossary makes sense in context.
- Don't worry about "buffer overflow" — it's a general security concept, not something you'll use in day-to-day Java coding as a beginner.
