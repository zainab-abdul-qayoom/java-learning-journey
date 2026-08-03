# Lab: Explore Data Types — Remember This

## What This Lab Does
- Creates a project with `src`, `classes`, `test` folders (same pattern as your first lab)
- Writes one Java file that prints an example of each primitive data type
- Second file shows **casting** (double → int)

## Commands Used (same pattern every time)
```bash
mkdir -p my_datatypes_proj/src my_datatypes_proj/classes my_datatypes_proj/test
touch src/DataTypes.java
javac -d classes src/DataTypes.java
export CLASSPATH=$CLASSPATH:/path/to/classes
java DataTypes
```

## Key Code Example (all primitive types in one place)
```java
byte b = 125;
short points = 3000;
int population = 4358000;
long age_in_milliseconds = 788923800000l;   // ends with l
char keyboard_input = 'a';
boolean isLabCompleted = false;
float house_value = 4000000.58f;             // ends with f
double pi = 3.14159265359;
```

## Casting (double → int)
```java
double area_circle = 78.53981634d;
System.out.println((int) area_circle);   // prints 78 — decimal part is dropped
```
- **Casting** = converting one data type to another
- `(int)` in front of a double **removes** the decimal part (doesn't round, just cuts it off)

---

## 🧠 Extra — What matters most
- Casting `double → int` **truncates**, it does NOT round. `78.99` becomes `78`, not `79`. This is a classic interview trap question.
- `l` for long and `f` for float are required — Java throws a compile error without them on large/decimal literals.
- This lab is basically a template — you'll reuse this exact folder/compile/run pattern for every future lab.
