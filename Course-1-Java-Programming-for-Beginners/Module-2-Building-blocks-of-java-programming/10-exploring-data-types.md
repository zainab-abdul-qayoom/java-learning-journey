# Video: Exploring Data Types in Java — Remember This

## Two Categories
- **Primitive** — fixed size, holds actual value, can't be null
- **Reference** — stores memory address pointing to the actual data (objects)

## Primitive Data Types (8 total — memorize this list)
| Type | Use | Example |
|---|---|---|
| `byte` | small numbers (-128 to 127) | `byte age = 25;` |
| `short` | small range (-32,768 to 32,767) | `short temp = -5;` |
| `int` | most used, whole numbers | `int population = 1000000;` |
| `long` | very large numbers | `long dist = 384400000L;` |
| `float` | decimals, less precision | `float price = 19.99F;` |
| `double` | decimals, more precision | `double pi = 3.14159;` |
| `char` | single character | `char initial = 'A';` |
| `boolean` | true/false | `boolean loggedIn = true;` |

## Reference Data Types
- **String** — text ("Hello World!")
- **Array** — collection of same-type values (index starts at 0)
- **Class** — blueprint for creating objects
- **Interface** — contract of methods a class must implement (no code inside, just method names)
- **Enum** — fixed set of named values (e.g. days of week)

## Quick Rule of Thumb
- Whole numbers → `int`
- Decimals → `double`
- Text → `String`
- Yes/No → `boolean`

---

## 🧠 Extra — What matters most
- **int vs double vs float vs long** confusion is a common interview/coding question — know when to use which (above table covers it).
- `L` after long numbers and `F` after float numbers are **required syntax** — forgetting them causes compile errors.
- **Arrays start at index 0** — this trips up almost every beginner at some point.
- Interfaces will matter a LOT in your next course (OOP) — this is just the intro.
