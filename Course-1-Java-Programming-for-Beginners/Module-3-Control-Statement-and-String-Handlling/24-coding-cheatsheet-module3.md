# Coding Cheatsheet: Control Structures & String Handling — Quick Reference

*(Pure code reference — full explanations already in notes 16-21)*

## Conditionals
```java
if (number > 5) { }
else if (number == 5) { }
else { }

switch (day) {
    case 1: System.out.println("Monday"); break;
    default: System.out.println("Weekend");
}
```

## Loops
```java
for (int i = 1; i <= 5; i++) { }

while (i <= 5) { i++; }

do { i++; } while (i <= 5);

for (int num : numbers) {          // for-each
    if (num > 5) { break; }
}
```

## Strings
```java
String s = "Hello";                 // literal
String s2 = new String("Hello");    // object

s.length()
s.charAt(0)
s.equals(s2)
s.substring(5, 16)
s.toUpperCase() / s.toLowerCase()
s.trim()
s.replace("cats", "dogs")
s.split(",")                        // → array
String.join(", ", arrayOfStrings)   // combine array → string
s1 + s2  or  s1.concat(s2)          // combine
```

## Packages & Imports
```java
package com.example.myapp;          // top of file

import package_name.ClassName;      // specific class
import shapes.*;                    // everything (avoid in real code)
```

## Methods
```java
returnType methodName(paramType param) {
    return value;
}

// example
public int multiply(int x, int y) {
    return x * y;
}

// overloading — same name, different params
public void show(int number) { }
public void show(String text) { }

// void = no return value
public void printMessage() { }
```

## Scope
```java
int x = 10;              // local — only inside this block
private int x;           // instance — accessible by all methods in class
private static int x;    // static — belongs to class itself
```

---

## 🧠 Quick memory check before your quiz
- Can you write a for loop from scratch without looking? ✅ practice this
- Do you know `.equals()` vs `==` for strings? ✅ very likely to be tested
- Can you explain overloading in one sentence? ✅ same name, different parameters
