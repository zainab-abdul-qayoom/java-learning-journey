# Video: Introduction to Object-Oriented Programming — Remember This

## Class vs Object (the foundation of everything in this course)
- **Class** = blueprint (e.g. "Car" — defines what all cars have)
- **Object** = a specific instance made from that blueprint (e.g. "your red sports car")

## Properties (attributes)
- The **characteristics** of an object
- Example: a car has `color`, `speed`, `model`

## Methods (behaviors)
- The **actions** an object can perform
- Example: a car can `drive()`, `honk()`, `park()`

## The 4 Pillars of OOP (memorize these cold — this whole course builds on them)

### 1. Inheritance
- New classes are built from existing ones (like a family tree)
- Subclass gets properties/methods from parent, plus its own extras
- Example: `ElectricCar` inherits from `Car`, adds `batteryLife`

### 2. Encapsulation
- Bundling data + methods together, hiding internal details
- Only expose what's necessary ("interact through the remote, not the TV's wiring")
- Example: private data (like a password), accessed only through controlled methods

### 3. Polymorphism
- Same method name, different behavior depending on the object
- Example: `fly()` on a helicopter (uses rotors) vs `fly()` on a rocket (uses engines) — same interface, different actions

### 4. Abstraction (implied — will get its own video soon)
- Hiding complex implementation, showing only what's needed

## Real Example: Online Bookstore
- **Book class** — properties: title, author, price. Methods: `displayInfo()`, `applyDiscount()`
- **Customer class** — properties: name, email, address. Methods: `createAccount()`, `processOrder()`
- **Inheritance** — `EBook` extends `Book`, adds `fileFormat`
- **Encapsulation** — passwords kept private, accessed via controlled methods
- **Polymorphism** — `PaymentMethod` interface implemented by `CreditPayment` and `PayPal`

---

## 🧠 Extra — What matters most
- **This entire course is built around the 4 pillars above.** If you get comfortable explaining each one with a simple example (car, TV remote, bookstore), you're set for most interview questions on OOP.
- One-line definitions to memorize:
  - *Inheritance* = reuse code from a parent class
  - *Encapsulation* = hide internal details, expose only what's needed
  - *Polymorphism* = same method, different behavior per object type
  - *Abstraction* = hide complexity, show only essentials
- You already saw hints of these in Course 1 (Module 2/3 mentioned class, constructor, this, extends) — this course goes deep on each one.
