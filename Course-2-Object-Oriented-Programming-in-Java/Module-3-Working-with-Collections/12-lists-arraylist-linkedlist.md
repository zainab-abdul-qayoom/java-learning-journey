# Video: Working with Lists: ArrayList and LinkedList — Remember This

## What is a List
- Stores **ordered** elements, **allows duplicates**, access by position (index)

## ArrayList
- Uses a **dynamic array** — contiguous memory
- Starts with **default capacity of 10**, grows automatically
- **Fast** random access (get by index)
- **Slower** to add/remove — has to shift/resize elements

```java
import java.util.ArrayList;

ArrayList<String> shoppingList = new ArrayList<>();
shoppingList.add("Milk");
shoppingList.add("Bread");
shoppingList.get(0);          // "Milk"
shoppingList.remove("Bread");
System.out.println(shoppingList);
```
**Best for:** shopping/contact lists, stack-like behavior, stable size with occasional reads

## LinkedList
- Uses a **doubly linked list** — each element (node) links to the next AND previous
- Starts **empty**
- **Fast** to add/remove (no shifting needed)
- **Slower** to access by index — has to traverse node by node

```java
import java.util.LinkedList;

LinkedList<String> animals = new LinkedList<>();
animals.add("Dog");
animals.add("Cat");
animals.get(0);
animals.remove("Cat");
System.out.println(animals);
```
**Best for:** queues, adding/removing from both ends, undo functionality, frequent insert/delete

---

## Decision Table
| Need | Use |
|---|---|
| Fast lookup by index, size doesn't change much | **ArrayList** |
| Frequent insert/delete, queue-like behavior | **LinkedList** |

---

## 🧠 Extra — What matters most
- **This is a top-tier interview question: "ArrayList vs LinkedList — when would you use each?"** Your one-line answer: *"ArrayList for fast reads, LinkedList for fast inserts/deletes."*
- Memory structure matters for WHY:
  - ArrayList = contiguous memory → index math is instant, but inserting means shifting everything after it
  - LinkedList = scattered nodes linked together → inserting is just relinking pointers (fast), but finding element #50 means walking through 50 nodes (slow)
- In real jobs, **ArrayList is used far more often** than LinkedList — default to ArrayList unless you specifically need frequent insertions/deletions.
