# Lab: Create Custom Functions and Methods — Remember This

## What This Lab Builds
An Area Calculator — user picks a shape, enters values, gets the area/volume calculated using custom methods.

## Key Code Pattern
```java
private static float pi = 3.142f;

private static float circle(float radius) {
    return (pi * radius * radius);
}
```
- **private** — method only usable inside this class
- **static** — no need to create an object to call it (belongs to the class itself)

## Taking User Input
```java
Scanner scanner = new Scanner(System.in);
int choice = Integer.parseInt(scanner.nextLine());       // string → int
float radius = Float.parseFloat(scanner.nextLine());     // string → float
```

## Menu Pattern (while loop + if-else)
```java
while (true) {
    // show menu
    // read choice
    if (choice == 1) { ... }
    else if (choice == 2) { ... }
    else {
        System.out.println("Invalid choice");
        break;   // exits the loop
    }
}
```
This is a common **beginner project pattern**: infinite loop + menu + break to exit.

## Calling a Method
```java
circle(radius)   // calls the method, passes radius as parameter
```

---

## 🧠 Extra — What matters most
- **`private static`** combo is very common for helper methods that don't need an object — you'll see this pattern constantly.
- `Scanner` + `parseInt`/`parseFloat` is the standard way to get numeric input from users — memorize this pattern, you'll reuse it in almost every console program.
- The **menu + while(true) + break** structure is a classic beginner project template — good to be comfortable writing this from scratch.
- Practice exercise adds sphere/cube/cuboid volume — same pattern, just new formulas. Good practice to try writing it yourself before looking at the answer.
