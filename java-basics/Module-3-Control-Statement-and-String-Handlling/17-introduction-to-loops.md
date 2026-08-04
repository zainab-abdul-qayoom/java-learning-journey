# Video: Introduction to Loops in Java — Remember This

## for loop (use when you know how many times to repeat)
```java
for (int i = 1; i <= 5; i++) {
    System.out.println(i);
}
```
- Parts: **initialization → condition → increment/decrement**

## while loop (use when iterations are unknown)
```java
int i = 1;
while (i <= 5) {
    System.out.println(i);
    i++;
}
```
- Checks condition **first**, then runs code

## do-while loop (runs at least once, always)
```java
int i = 1;
do {
    System.out.println(i);
    i++;
} while (i <= 5);
```
- Runs code **first**, checks condition **after**
- Even if condition is false immediately, it still runs once

## Nested loops (loop inside loop — used for grids/tables)
```java
for (int i = 1; i <= 10; i++) {
    for (int j = 1; j <= 10; j++) {
        System.out.print(i * j + "\t");
    }
    System.out.println();
}
```
Example: multiplication table

## break — exits loop completely
```java
if (num > 5) {
    break;
}
```

## continue — skips current iteration, keeps looping
```java
if (i == 5) {
    continue;   // skips printing 5, keeps going
}
```

---

## 🧠 Extra — What matters most
- **for** = known count, **while** = unknown count, **do-while** = must run at least once. This 3-way comparison is a common interview question.
- `break` vs `continue` mixup is common — `break` = stop completely, `continue` = skip just this round.
- Nested loops = same pattern as 2D arrays (outer = rows, inner = columns) — you already saw this in the arrays video, good to connect the dots.
