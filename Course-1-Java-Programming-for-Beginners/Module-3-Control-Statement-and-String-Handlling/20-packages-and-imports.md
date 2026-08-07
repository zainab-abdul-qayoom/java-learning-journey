# Video: Using Packages and Imports — Remember This

## What is a Package
- A **namespace** that groups related classes/interfaces together
- Prevents naming conflicts (same class name can exist in different packages)
- Organizes code into folder-like structure

## Creating a Package
```java
package shapes;

public class Circle {
    private double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    double area() {
        return Math.PI * radius * radius;
    }
}
```
- Naming convention: reverse domain (e.g. `com.example.myapp`) — ensures uniqueness

## Importing Classes
```java
import shapes.Circle;    // import one class
import shapes.*;         // import all classes in the package (avoid — see below)
```

## Common Built-in Java Packages
| Package | Contains |
|---|---|
| `java.lang` | String, Math, System — **auto-imported, no need to write it** |
| `java.util` | ArrayList, HashMap, Date — collections & data structures |
| `java.io` | File, InputStream, BufferedReader — file/data handling |
| `java.net` | Socket, URL — networking |
| `java.sql` | Connection, Statement — database access |
| `java.time` | LocalDate, LocalTime — modern date/time handling |

## Best Practices
- Import only what you need — **avoid `import package.*`**
- Keep imports organized and remove unused ones
- Use reverse-domain naming for your own packages

---

## 🧠 Extra — What matters most
- `java.lang` is the only package you never need to import manually — it's automatic.
- `java.util.ArrayList` and `java.util.HashMap` are things you'll use constantly in real projects — good to recognize now.
- Wildcard imports (`import shapes.*`) work but are considered bad practice in real jobs — import specific classes instead for cleaner code.
