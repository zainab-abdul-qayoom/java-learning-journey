# Glossary: Control Structures and String Handling — Remember This

*(Condensed + grouped — focuses on what you'll actually use.)*

## String Methods (recap — you already know these from labs)
- `.length()`, `.charAt()`, `.equals()`, `.substring()`, `.concat()`, `.split()`, `.replace()`, `.trim()`, `.toUpperCase()`, `.toLowerCase()`
- **String literal** — created with `""`, stored in string pool
- **Immutable** — Strings can't be changed after creation

## Control Structures
- `if-else` — conditional execution
- `switch` — multiple paths based on one variable
- `Loop` — repeats code (`for`, `while`, `do-while`)
- `break` — exits loop/switch
- `continue` — skips to next iteration

## Methods
- **Method** — code block that does a task, inside a class
- **Instance method** — needs an object to call
- **Static method** — belongs to class, no object needed
- **Parameters / Arguments** — inputs a method takes
- **Return type** — what data type the method gives back
- **Overloading** — same method name, different parameters
- **Method signature** — name + parameter list (defines uniqueness)

## OOP (recap — going deeper in next course)
- **Class / Object / Constructor**
- **Inheritance / Polymorphism / Encapsulation / Abstraction**
- **Interface** — contract of methods a class must implement
- **this** — current object

## Exceptions (Module 4 preview)
- **Exception** — runtime error
- **try-catch** — handle errors
- **finally** — always runs after try-catch
- **throw / throws** — manually raise / declare possible exceptions

## Packages
- `java.lang` — core (auto-imported)
- `java.util` — ArrayList, HashMap, collections
- `java.io` — file/input-output handling
- `java.net` — networking
- `java.sql` — database
- `java.time` — dates/times (modern, Java 8+)

## Good to Recognize (not urgent — advanced/rare for beginners)
- **Generics** — type-safe collections
- **Lambda** — short anonymous functions (Java 8+)
- **Stream** — functional-style data processing
- **Optional** — safely handle null values
- **Thread / synchronized / volatile** — concurrency (multi-threading)
- **Reflection / Serialization** — advanced runtime features
- **Record** — compact immutable class (Java 14+)
- **var** — type inference for local variables (Java 10+)

---

## 🧠 Extra — What matters most
- Focus your energy on: **String methods, loops, if/switch, method basics, and OOP terms** — these are used daily.
- Terms like Generics, Lambda, Stream, Reflection are **intermediate/advanced** — good to recognize the names now, but you'll properly learn them later (often in the OOP or a Java 8+ features course).
- `throw` vs `throws` — `throw` actually raises the exception, `throws` just warns "this method might throw one." Common mixup.
