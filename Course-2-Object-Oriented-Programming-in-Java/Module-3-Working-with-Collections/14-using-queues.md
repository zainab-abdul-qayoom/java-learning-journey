# Video: Using Queues in Java — Remember This

## What is a Queue
- Follows **FIFO** — First In, First Out
- Two main operations:
  - **enqueue** — add item to the **back**
  - **dequeue** — remove item from the **front**
- Can only access the **front element** — no random access like arrays

## Basic Example
```java
import java.util.LinkedList;
import java.util.Queue;

Queue<String> queue = new LinkedList<>();
queue.offer("Apple");     // enqueue
queue.offer("Banana");
queue.offer("Cherry");
System.out.println(queue);          // [Apple, Banana, Cherry]

queue.poll();              // dequeue — removes "Apple" (front)
System.out.println(queue);          // [Banana, Cherry]
```

## Key Methods
| Method | Action |
|---|---|
| `.offer(item)` | enqueue — adds to back |
| `.poll()` | dequeue — removes & returns front item |

## Real Example: Customer Service Line
```java
Queue<String> customerQueue = new LinkedList<>();
customerQueue.offer("Customer1");
customerQueue.offer("Customer2");
customerQueue.offer("Customer3");

customerQueue.poll();   // serves Customer1, removes them
// Queue now: [Customer2, Customer3]
```
👉 First customer to arrive = first one served — classic FIFO in action.

## Real-World Use Cases
- **Task scheduling** — OS processes tasks in order of arrival
- **Print spooling** — print jobs processed in order
- **Breadth-First Search (BFS)** — explores graph nodes layer by layer
- **Real-time data streams** — chat servers, stock trading platforms

---

## 🧠 Extra — What matters most
- **FIFO is the one word to remember** — first in, first out. Compare mentally to a real line at a store.
- Queue is built on top of `LinkedList` in this example — that connects directly to what you learned two videos ago (LinkedList is efficient for adding/removing from ends, which is exactly what a queue needs).
- **BFS (Breadth-First Search)** is a preview of your future DSA course — queues are the core data structure behind it. Good to plant that connection now.
- Don't confuse Queue (FIFO) with Stack (LIFO — Last In First Out) — Stack wasn't covered in this video but often gets compared to Queue in interviews.
