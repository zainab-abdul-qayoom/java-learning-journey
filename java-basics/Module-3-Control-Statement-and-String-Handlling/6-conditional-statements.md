# Video: Using Conditional Statements — Remember This

## if statement
```java
if (number > 5) {
    System.out.println("Greater than 5");
}
```
Runs only if condition is true.

## if-else statement
```java
if (number > 5) {
    System.out.println("Greater than 5");
} else {
    System.out.println("Not greater than 5");
}
```
Gives an alternative action if condition is false.

## if - else-if - else (multiple conditions)
```java
if (number > 5) {
    System.out.println("Greater than 5");
} else if (number == 5) {
    System.out.println("Equal to 5");
} else {
    System.out.println("Less than 5");
}
```

## switch statement
```java
switch (day) {
    case 1: System.out.println("Monday"); break;
    case 2: System.out.println("Tuesday"); break;
    default: System.out.println("Weekend");
}
```
- Checks one variable against multiple values
- Cleaner than many if-else when checking a single variable
- Always include `default` as a fallback

## Nested if (if inside if)
```java
if (age >= 18) {
    System.out.println("Adult");
    if (age >= 65) {
        System.out.println("Senior citizen");
    }
} else {
    System.out.println("Minor");
}
```

---

## 🧠 Extra — What matters most
- **Don't forget `break;`** in switch cases — without it, Java keeps running the next cases too ("fall-through"), which is a very common bug.
- Use **switch** when checking one variable against many fixed values (like days, menu options) — use **if-else** for ranges/complex conditions.
- Nested ifs = "if inside if" — used a lot for real-world rules (e.g. age checks, permission levels).
