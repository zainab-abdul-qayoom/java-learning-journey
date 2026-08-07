# Video: Working with Strings in Java — Remember This

## Creating a String
```java
String s1 = "Hello, World!";           // literal (common way)
String s2 = new String("Hello, World!"); // object way (rarely needed)
```

## Common String Methods
| Method | What it does | Example |
|---|---|---|
| `.length()` | count characters | `"Java".length()` → 4 |
| `.charAt(i)` | get character at index | `"Java".charAt(0)` → 'J' |
| `+` or `.concat()` | join strings | `"a" + "b"` → "ab" |
| `.equals()` | compare content (case-sensitive) | `"Hi".equals("Hi")` → true |
| `.substring(start, end)` | extract part (end not included) | `"Programming".substring(0,4)` → "Prog" |
| `.split(delimiter)` | break into array | `"a,b,c".split(",")` → [a, b, c] |
| `String.join(sep, arr)` | combine array into one string | `"Red, Green, Blue"` |
| `.toUpperCase()` / `.toLowerCase()` | change case | |
| `.trim()` | remove extra spaces at start/end | |
| `.replace()` | replace characters/substring | |

## Important Concept: Strings are Immutable
- Once created, a string **cannot be changed**
- Any "modification" actually creates a **new** string
```java
String a = "Hello";
a = a + " World";  // creates a NEW string, doesn't change original
```

---

## 🧠 Extra — What matters most
- **`.equals()` vs `==`** — always use `.equals()` to compare string *content*. `==` checks memory reference, not the actual text — classic Java trap question.
- **Immutability** is a favorite interview topic: *"Strings are immutable in Java — every change creates a new object instead of modifying the original."*
- `.substring(start, end)` — end index is **excluded**, easy to get off-by-one errors here.
