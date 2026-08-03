# Video: Using Advanced Operators in Java — Remember This

## Assignment Operators (shortcut math + assign)
| Operator | Meaning | Example (a=10) |
|---|---|---|
| `=` | assign value | `a = 10` |
| `+=` | add & update | `a += 5` → a=15 |
| `-=` | subtract & update | `a -= 2` → a=8 |
| `*=` | multiply & update | `a *= 3` → a=30 |
| `/=` | divide & update | `a /= 2` → a=5 |
| `%=` | modulus & update | `a %= 4` → a=2 |

## Unary Operators (work on single value)
| Operator | Meaning | Example (a=10) |
|---|---|---|
| `+a` | unary plus (no real change) | 10 |
| `-a` | unary minus (flips sign) | -10 |
| `a++` | increment (+1) | 11 |
| `a--` | decrement (-1) | 9 |

## Ternary Operator (shortcut for if-else)
```java
max = (a > b) ? a : b;
```
- If condition true → first value
- If condition false → second value

Example: `a=10, b=20` → `(a>b) ? a : b` → since false, `max = 20`

## Bitwise & Shift Operators (just recognize — advanced/rare for beginners)
- Work with binary data, used in low-level tasks (performance, cryptography, hardware)

---

## 🧠 Extra — What matters most
- **Ternary operator is very commonly used in real code** — cleaner than writing full if-else for simple checks. Worth practicing.
- `+=`, `-=`, etc. are used constantly — they save typing and are considered "clean code" style.
- Bitwise/shift operators are rarely needed as a beginner — just know they exist, don't stress over them now.
