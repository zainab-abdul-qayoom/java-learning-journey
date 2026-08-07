# Lab: Working with Strings — Remember This

## String Literal vs String Object (important gotcha)
```java
String s1 = "Hello World";              // literal — stored in String pool
String s2 = new String("Hello World");  // object — new memory on heap
String s3 = "Hello World";              // literal — reuses same pool memory as s1
```
```java
s1 == s2   // false (different memory)
s1 == s3   // true  (both literals, same pool memory)
```
**Rule:** `==` compares memory location, not content. Use `.equals()` for content comparison — always.

## Length & Characters
```java
s1.length()               // number of characters
s1.toCharArray()          // convert string to char array
strArr[0]                 // first character
strArr[strArr.length-1]   // last character
s1.indexOf('T')           // index of first occurrence (-1 if not found)
```

## Comparing Strings
```java
s1.equals(s2)            // exact match, case-sensitive
s1.equalsIgnoreCase(s3)  // match ignoring case
s1.toLowerCase()         // convert to lowercase
s1.toUpperCase()         // convert to uppercase
s1.strip()               // removes leading/trailing whitespace
s1.matches(regex)        // checks against a pattern (regex)
```

## Concatenation & Substring
```java
s1.concat(s2)          // joins two strings (same as s1 + s2)
s1.substring(0, 10)    // characters from index 0 to 9 (end excluded)
s1.substring(7)        // from index 7 to end of string
```

---

## 🧠 Extra — What matters most
- **`==` vs `.equals()` for Strings is THE most common Java beginner mistake and interview question.** Always compare string content with `.equals()`.
- `.substring(start, end)` — end index is **not included**. `substring(7,10)` gives characters at index 7, 8, 9 only.
- `.strip()` is very useful for cleaning real-world data (form inputs, file data) — you'll use it a lot in practice.
- **Practice tip:** Try writing the Practice Exercise code yourself before checking the answer — this lab format repeats in every module.
