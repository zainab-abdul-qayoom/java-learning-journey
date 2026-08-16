# Video: Exploring Sets: HashSet and TreeSet — Remember This

## What is a Set
- Stores **unique elements only** — no duplicates allowed

## HashSet
- Uses a **hash table** — fast operations (constant time: O(1))
- **No specific order**
- Allows **one null** element
- No duplicates

```java
import java.util.HashSet;

HashSet<String> fruits = new HashSet<>();
fruits.add("Apple");
fruits.add("Banana");
fruits.add("Banana");     // ignored — duplicate
fruits.contains("Apple"); // true
fruits.remove("Cherry");
System.out.println(fruits);   // order not guaranteed
```
**Best for:** unique user IDs, inventory tracking, removing duplicates — when speed matters, order doesn't

## TreeSet
- Uses a **red-black tree** — maintains **sorted order** automatically
- **Logarithmic time** performance (O(log n)) — slower than HashSet
- Does **NOT allow null**
- No duplicates

```java
import java.util.TreeSet;

TreeSet<Integer> numbers = new TreeSet<>();
numbers.add(5);
numbers.add(3);
numbers.add(3);          // ignored — duplicate
numbers.add(8);
System.out.println(numbers);   // [3, 5, 8] — sorted ascending automatically
numbers.contains(5);           // true
numbers.remove(8);
```
**Best for:** sorted data (names, dates), leaderboards, range queries, rankings

---

## HashSet vs TreeSet Comparison
| | HashSet | TreeSet |
|---|---|---|
| Order | None | Sorted (ascending) |
| Speed | Fast — O(1) | Slower — O(log n) |
| Null allowed | Yes (one) | No |
| Underlying structure | Hash table | Red-black tree |
| Use when | Speed matters, order doesn't | Sorting matters, some slowness OK |

---

## 🧠 Extra — What matters most
- Simple decision rule: **"Do I need sorted data?"** → Yes = TreeSet. No, just need speed + uniqueness = HashSet.
- Real examples to anchor this: **HashSet** = checking if a player already collected an item (fast lookup, order doesn't matter). **TreeSet** = leaderboard scores (must stay sorted).
- Both Set types share the core rule: **no duplicates** — that's the whole reason Sets exist as a data structure, distinct from Lists.
- `O(1)` vs `O(log n)` — you don't need to fully master Big-O notation yet, just recognize HashSet is generally faster than TreeSet for basic operations.
