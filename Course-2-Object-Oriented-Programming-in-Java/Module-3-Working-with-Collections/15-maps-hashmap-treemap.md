# Video: Using Maps: HashMap and TreeMap — Remember This

## What is a Map
- Stores **key-value pairs**
- Multiple keys can point to the same value (like nicknames pointing to one phone number)

## HashMap
- Uses a **hash table** — very fast lookups, average time O(1) (nearly constant)
- **No guaranteed order**
- Allows **one null key**, multiple null values

```java
import java.util.HashMap;

HashMap<String, Integer> ages = new HashMap<>();
ages.put("Alice", 30);
ages.put("Bob", 25);

ages.get("Alice");                // 30
ages.containsKey("Bob");          // true
ages.remove("Bob");

for (String key : ages.keySet()) {
    System.out.println(key + ": " + ages.get(key));
}
```
**Best for:** fast lookups, counting things (word frequency), dictionaries, large datasets where order doesn't matter

## TreeMap
- Uses a **red-black tree** — keeps keys in **sorted order**
- Average time O(log n) — slower than HashMap
- Does **NOT allow null keys**

```java
import java.util.TreeMap;

TreeMap<String, Integer> scores = new TreeMap<>();
scores.put("Charlie", 90);
scores.put("Alice", 95);
scores.put("Bob", 88);

// iterates in sorted key order: Alice, Bob, Charlie
for (String key : scores.keySet()) {
    System.out.println(key + ": " + scores.get(key));
}
```
**Best for:** sorted lists, leaderboards, priority queues, range queries, finding min/max key

---

## Key Methods (same for both)
| Method | Action |
|---|---|
| `.put(key, value)` | add/update entry |
| `.get(key)` | retrieve value |
| `.containsKey(key)` | check if key exists |
| `.remove(key)` | delete entry |
| `.keySet()` | get all keys (for iterating) |

---

## HashMap vs TreeMap Comparison
| | HashMap | TreeMap |
|---|---|---|
| Order | None | Sorted by key |
| Speed | Fast — O(1) | Slower — O(log n) |
| Null key | 1 allowed | Not allowed |
| Memory | Less | More |
| Use when | Speed, order doesn't matter | Order matters |

---

## 🧠 Extra — What matters most
- **This mirrors the HashSet vs TreeSet pattern exactly** — same trade-off (speed vs order), just with key-value pairs instead of single values. If you understood Sets, Maps are the same logic.
- `HashMap` is genuinely one of the **most-used data structures in real Java jobs** — word counting, caching, lookups, grouping data. Get comfortable with `.put()`/`.get()`.
- One-line interview answer: *"HashMap = fast, unordered. TreeMap = slower, but keeps keys sorted."*
- You're about to do the **Phonebook Lab using HashMap** next — that'll make this concrete with a real project.
