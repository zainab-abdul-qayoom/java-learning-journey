# Glossary: Working with Collections in Java — Remember This

*(Condensed + grouped — matches notes 11-16)*

## The Framework
- **Collection** — group of objects that store, retrieve, manipulate, communicate data
- **Java Collections Framework (JCF)** — the set of classes/interfaces for working with collections

## Lists
- **List** — ordered, allows duplicates
- **ArrayList** — dynamic array, fast random access, slow to add/remove in middle
- **LinkedList** — doubly linked list, fast add/remove, slow index access

## Sets
- **Set** — unordered, NO duplicates
- **HashSet** — no order, allows null, fast (O(1))
- **TreeSet** — sorted order, no null allowed, slower (O(log n))

## Maps
- **Map** — unordered key-value pairs, unique keys
- **HashMap** — no guaranteed order, allows null values, fast
- **TreeMap** — sorted by key, no null keys allowed, slower

## Map/Set Common Methods
- **put()** — add an entry (Map)
- **get()** — retrieve a value
- **remove()** — delete an entry
- **containsKey()** — check if a key exists
- **keySet()** — iterate over all keys

## Queues
- **Queue** — collection with enqueue/dequeue operations
- **Enqueue** — add item to the back
- **Dequeue** — remove item from the front
- **FIFO (First-In-First-Out)** — first added = first removed

## Real-World / Algorithm Terms
- **Print spooling** — print jobs processed in queue order
- **Breadth-First Search (BFS)** — traverses a graph/tree level by level, uses a queue internally

---

## 🧠 Extra — What matters most
- This whole module boils down to **3 core structures**: List (ordered, duplicates OK), Set (unique only), Map (key-value pairs) — plus Queue as a special FIFO-access pattern.
- **put/get/remove/containsKey/keySet** are the 5 methods you'll type constantly in real Java code — make sure these are muscle memory before the quiz.
- BFS appearing here is a nice bridge — you'll meet it again properly in your future DSA course, and now you already know it's built on a Queue.
