# Video: Introduction to Operators in Java — Remember This

## Arithmetic Operators (basic math)
| Operator | Meaning | Example (a=10, b=5) |
|---|---|---|
| `+` | addition | `a+b` = 15 |
| `-` | subtraction | `a-b` = 5 |
| `*` | multiplication | `a*b` = 50 |
| `/` | division | `a/b` = 2 |
| `%` | modulus (remainder) | `a%b` = 0 |

## Relational Operators (compare values → return true/false)
| Operator | Meaning |
|---|---|
| `==` | equal to |
| `!=` | not equal to |
| `>` | greater than |
| `<` | less than |
| `>=` | greater than or equal |
| `<=` | less than or equal |

Example (a=10, b=5): `a==b` → false, `a!=b` → true, `a>b` → true

## Logical Operators (combine conditions)
| Operator | Meaning |
|---|---|
| `&&` | AND — true only if both are true |
| `\|\|` | OR — true if at least one is true |
| `!` | NOT — flips true/false |

---

## 🧠 Extra — What matters most
- `==` is comparison, `=` is assignment — mixing these up is the #1 beginner bug.
- `%` (modulus) is used constantly in real coding (checking even/odd: `if (num % 2 == 0)`).
- `&&` and `||` short-circuit — if the first condition already decides the result, Java won't even check the second one. (Good to know, not urgent now.)
