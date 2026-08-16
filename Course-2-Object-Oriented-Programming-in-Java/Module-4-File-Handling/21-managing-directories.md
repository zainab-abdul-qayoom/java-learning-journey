# Video: Managing Directories in Java — Remember This

## What is a Directory
- A **folder** — container for files and other folders
- Helps organize data in a clear, structured way

## Two Ways to Manage Directories: java.io vs java.nio

### java.io.File (traditional way)
```java
import java.io.File;

File dir = new File("MyDirectory");

// Create
if (!dir.exists()) {
    dir.mkdirs();   // creates dir + any missing parent dirs
}

// List contents
String[] contents = dir.list();
if (contents != null) {
    for (String name : contents) {
        System.out.println(name);
    }
}

// Delete (must be empty!)
if (dir.exists()) {
    boolean deleted = dir.delete();   // true if successful
}
```

### java.nio (New I/O — more modern, better performance)
```java
import java.nio.file.*;

Path path = Paths.get("MyDirectory");

try {
    Files.createDirectories(path);   // creates dir + parents
} catch (IOException e) {
    System.out.println("Error: " + e.getMessage());
}
```

---

## Key Methods (java.io)
| Method | Action |
|---|---|
| `mkdirs()` | creates directory + missing parent directories |
| `list()` | returns array of file/folder names inside — always check for `null` |
| `delete()` | deletes directory — **only works if empty**, returns true/false |
| `exists()` | check before creating/deleting |

## java.io vs java.nio
| | java.io | java.nio |
|---|---|---|
| Age | Traditional | Newer (NIO = New I/O) |
| Performance | Standard | Better, especially for large/frequent operations |
| Error handling | Basic | More advanced/flexible |

---

## Real-World Example: Document Management System
- Creates directories per category (reports, invoices, letters)
- Lists contents of a directory to browse files
- Deletes directories no longer needed (must be empty first)

---

## 🧠 Extra — What matters most
- **A directory must be EMPTY before you can delete it** — this is a common gotcha. If it has files, `delete()` returns `false` silently unless you check.
- Always check `.exists()` before creating or deleting — avoids errors/conflicts.
- Always check `list()` result for `null` before looping — prevents a `NullPointerException` if the directory is empty or doesn't exist (connects back to Course 1's exception handling).
- You don't need to master `java.nio` deeply yet — just recognize it exists as the "modern, better" alternative to `java.io` for file/directory work.
