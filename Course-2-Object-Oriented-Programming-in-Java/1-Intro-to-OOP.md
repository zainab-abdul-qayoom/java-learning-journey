# Introduction to Object-Oriented Programming

## The core idea, using a car
A class is a blueprint. An object is one actual thing built from that blueprint.

Think of a red sports car. The car itself, with its specific color and speed, is an **object**. The general idea of "a car has a color, a speed, and can drive and honk" is the **class**, the template every car gets built from.

## Properties and methods
- **Properties** are the object's attributes, the data it holds. For a car: color, speed, model.
- **Methods** are the actions the object can perform. For a car: drive, honk, park.

Every object created from the same class shares the same set of properties and methods, but each object fills in its own values. Two Car objects can both have a `color` property, one red, one blue.

## The four pillars

### Inheritance
Creating new classes based on existing ones, like a family tree. A base `Car` class can have subclasses like `ElectricCar` or `SportsCar`. Those subclasses automatically get everything the parent `Car` class has, plus they can add their own extras.

Example: `ElectricCar` adds a `batteryLife` property that a regular `Car` doesn't have. `SportsCar` adds a `boost()` method for faster acceleration.

### Encapsulation
Bundling an object's data together with the methods that work on that data, inside one class, and hiding the internal details from the outside world.

Think of a TV remote. You press buttons to change the channel or adjust volume, you don't need to know how the TV processes the signal internally. The remote is the only interface you get, the internals stay hidden. That's encapsulation: expose only what's needed, hide the rest.

### Polymorphism
The same method name behaving differently depending on which object calls it.

Example: both a `Helicopter` and a `Rocket` might have a `fly()` method. Calling `fly()` on the helicopter makes it use rotor blades. Calling `fly()` on the rocket makes it fire engines into space. Same method name, completely different behavior, because the underlying object is different.

### Abstraction (implied throughout)
Focusing on what an object does rather than how it does it internally, this is really what makes encapsulation and polymorphism useful in the first place, you interact with a clean interface instead of the messy implementation.

## Worked example: an online bookstore

- `Book` class: properties like `title`, `author`, `price`. A method like `displayInfo()` shows the book's details, another method might `applyDiscount()` to reduce the price.
- `Customer` class: properties like `name`, `email`, `address`. Methods for creating an account or processing an order.
- **Inheritance in action**: an `EBook` class extends `Book`, inheriting title/author/price, and adds its own property like `fileFormat`.
- **Encapsulation in action**: sensitive data like a customer's password is kept private, only accessible through controlled methods, not exposed directly.
- **Polymorphism in action**: a shared `PaymentMethod` interface can be implemented by different classes like `CreditPayment` and `PayPalPayment`, letting a customer pick any payment option while the checkout code just calls the same method regardless of which one they chose.

## One-line recap for each pillar
- **Class vs Object**: blueprint vs the actual thing built from it.
- **Inheritance**: new classes reuse and extend existing ones.
- **Encapsulation**: hide internal details, expose only a clean interface.
- **Polymorphism**: same method name, different behavior depending on the object.
