# Video: Introduction to the Java Collections Framework — Remember This

## What is a Collection
- A **group of objects**
- Java Collections Framework (JCF) = set of classes/interfaces to store, retrieve, and manipulate groups of data

## The 3 Main Collection Types
| Type | Ordered? | Duplicates? | Common Implementations |
|---|---|---|---|
| **List** | Yes (maintains order) | Allowed | `ArrayList`, `LinkedList` |
| **Set** | No | NOT allowed | `HashSet`, `TreeSet` |
| **Map** | No (key-value pairs) | Keys must be unique | `HashMap`, `TreeMap` |

---

## Lists

### ArrayList (dynamic array)
- Fast **random access** (get by index)
- Slower when adding/removing from the **middle**
```java
List<String> fruits = new ArrayList<>();
fruits.add("Apple");
fruits.add("Banana");
fruits.add("Cherry");
System.out.println(fruits);              // [Apple, Banana, Cherry]
String first = fruits.get(0);            // "Apple"
```

### LinkedList (doubly linked list)
- Fast **add/remove** anywhere
- Slower for accessing by index
```java
LinkedList<String> animals = new LinkedList<>();
animals.add("Dog");
animals.add("Cat");
animals.add("Elephant");
System.out.println(animals);             // [Dog, Cat, Elephant]
```

---

## Sets
### HashSet
- No guaranteed order, **allows null**, no duplicates
```java
HashSet<String> colors = new HashSet<>();
colors.add("Red");
colors.add("Green");
colors.add("Blue");
colors.add("Red");        // ignored — already exists
System.out.println(colors);   // order not guaranteed
```

### TreeSet
- Maintains **sorted order**, does **NOT allow null**

---

## Maps
### HashMap (key-value pairs)
- No guaranteed order, allows null
```java
HashMap<String, Integer> ageMap = new HashMap<>();
ageMap.put("Alice", 30);
ageMap.put("Bob", 25);
ageMap.put("Charlie", 35);

System.out.println(ageMap);                    // {Alice=30, Bob=25, Charlie=35}
int aliceAge = ageMap.get("Alice");              // 30
```

### TreeMap
- Maintains keys in **sorted order**, allows null

---

## 🧠 Extra — What matters most
- **ArrayList vs LinkedList** is a classic interview question:
  - ArrayList = fast to **read** (get by index), slow to insert/delete in the middle
  - LinkedList = fast to **insert/delete**, slow to read by index
- **List = ordered + duplicates OK. Set = no duplicates. Map = key-value, unique keys.** This one-line summary answers most quiz questions about which collection to use.
- `HashMap`/`HashSet` = fast but unordered. `TreeMap`/`TreeSet` = sorted but slightly slower. Pick based on whether you need order.
- These collections will basically **replace plain arrays** in most of your real coding from here on — arrays are fixed-size, these grow/shrink dynamically.
