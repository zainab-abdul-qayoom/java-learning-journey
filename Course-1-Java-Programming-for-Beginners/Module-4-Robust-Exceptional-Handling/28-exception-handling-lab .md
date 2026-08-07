# Lab: Exception Handling Practice — Remember This (Extra Simple — Was Hard)

This lab has 4 parts. Let's go one at a time, slowly.

---

## PART 1: See exceptions happen (unhandled)

You built a program with a string array of size 5. Without any try-catch, three things can go wrong:

| What you did | What breaks | Why |
|---|---|---|
| Ask for index 7 | `ArrayIndexOutOfBoundsException` | Array only has 5 slots (0-4) |
| Type "two" instead of a number | `NumberFormatException` | `Integer.parseInt("two")` can't convert text to a number |
| Ask for length of an empty slot | `NullPointerException` | That slot has no string yet — it's `null`, and you can't call `.length()` on nothing |

👉 **Simple takeaway:** without try-catch, ANY of these mistakes crashes the whole program immediately.

---

## PART 2: Fix it with try-catch

Same program, but now wrapped in try-catch so it doesn't crash:

```java
try {
    int retIdx = Integer.parseInt(scanner.nextLine());
    System.out.println(strArr[retIdx]);
} catch (NumberFormatException e) {
    System.out.println("Invalid input! Please enter a valid integer.");
} catch (ArrayIndexOutOfBoundsException e) {
    System.out.println("Invalid index!");
} catch (NullPointerException e) {
    System.out.println("No string exists at that index!");
}
```

👉 **Simple takeaway:** Same 3 problems, but now instead of crashing, the program prints a friendly message and **keeps running**. That's the whole point of try-catch — nothing more complicated than that.

---

## PART 3: Checked Exception (the confusing "Cloneable" part)

This part introduces **new vocabulary** — let's define each word simply first:

- **Cloneable** — a Java "label" (interface) that says "this class is allowed to be copied"
- **`clone()`** — a method that makes a copy of an object
- **`CloneNotSupportedException`** — a **checked exception**. Checked means: **Java forces you to handle it, or your code won't even compile.**

```java
class Student implements Cloneable {
    ...
    public Student clone() throws CloneNotSupportedException {
        return (Student) super.clone();
    }
}
```

Why does `clone()` say `throws CloneNotSupportedException`? Because cloning **could theoretically fail**, so Java forces you to acknowledge that risk.

**What happens if you don't handle it?** Your code **won't compile at all**:
```
error: unreported exception CloneNotSupportedException; must be caught or declared to be thrown
```

**The fix — wrap the call in try-catch:**
```java
try {
    Student student2 = student1.clone();
} catch (CloneNotSupportedException cnse) {
    System.out.println("You can't clone this object!");
}
```

👉 **Simple takeaway:** Checked exceptions are Java's way of saying *"this specific thing is risky enough that I won't even let you compile until you promise to handle it."* Unchecked exceptions (Part 1 & 2) don't have this rule — code compiles fine, they only crash at runtime.

---

## PART 4: Creating your OWN exception (Custom Exception)

This is simpler than it looks. A custom exception is just a small class:

```java
public class StudentUnderAgeException extends Exception {
    public StudentUnderAgeException(String message) {
        super(message);
    }
}
```

Read this literally:
- `extends Exception` → "I am creating my own type of checked exception"
- `super(message)` → "pass my error message up to the built-in Exception class so it knows what to say"

**Using it — inside the constructor:**
```java
public Student(String name, int age, String major) throws StudentUnderAgeException {
    if (age < 18) {
        throw new StudentUnderAgeException("Student age has to be 18 or more");
    }
    this.age = age;
}
```
- `throws StudentUnderAgeException` in the constructor signature = "creating a Student **might** throw this error"
- `throw new StudentUnderAgeException(...)` = "actually raise the error right now, because age < 18"

**Catching it, same as any other exception:**
```java
} catch (StudentUnderAgeException suae) {
    System.out.println(suae.getMessage());   // prints your custom message
}
```

👉 **Simple takeaway:** A custom exception is just: (1) a tiny class that extends `Exception`, (2) you `throw` it manually when your own rule is broken (like age < 18), (3) you catch it like any other exception.

---

## PART 5: Practice Exercise — Name Validation (same pattern repeated)

Exactly the same idea as the age exception, just checking name format instead:

```java
class InvalidNameException extends Exception {
    public InvalidNameException(String message) {
        super(message);
    }
}
```
```java
if (name.matches("^[a-zA-Z' -]+$") == false) {
    throw new InvalidNameException("Invalid name!");
}
```
`.matches("^[a-zA-Z' -]+$")` is a **regex** (pattern) that means: "only letters, apostrophes, spaces, and hyphens allowed" — don't worry about memorizing regex syntax now, just know `.matches()` checks if a string fits a pattern.

---

## 🧠 Extra — What matters most (since this was hard)

**The whole lab boils down to 3 ideas, nothing more:**
1. **Unhandled exceptions crash your program.** try-catch stops the crash.
2. **Checked exceptions** (like `CloneNotSupportedException`) are exceptions so serious that **Java won't even compile your code** unless you handle them — this is different from the exceptions you saw in Part 1/2 (those are unchecked — they compile fine, only fail at runtime).
3. **Custom exceptions** are just small classes you write yourself (`extends Exception`), which you `throw` manually when YOUR OWN business rule is broken (like "age must be 18+"). Everything else about them works exactly like built-in exceptions.

**If you only remember one sentence:** *"Checked = compiler forces me to handle it. Unchecked = my own bug, compiler doesn't care. Custom = I made my own checked exception for my own rule."*

**Suggestion:** Don't worry about typing this whole lab perfectly from memory. Just be able to explain the 3 ideas above in your own words — that's what actually gets tested in quizzes/interviews, not the exact syntax.
