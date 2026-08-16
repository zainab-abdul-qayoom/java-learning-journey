# Video: An Introduction to Java File Handling — Remember This

## Why File Handling Matters
- Lets you **read from** and **write to** files, so data survives after the program closes
- Uses classes from the **java.io** package
- Used for: saving data long-term, sharing data between programs, reading config files

## The File Class
- Represents a file/directory **path**
- Can check if a file exists, create/delete files — but **does NOT create the file itself**
```java
import java.io.File;

File myFile = new File("example.txt");
if (myFile.exists()) {
    System.out.println("File Exists");
} else {
    System.out.println("File Does Not Exist");
}
```

## Writing to a File
```java
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

try {
    FileWriter fw = new FileWriter("example.txt");   // creates or overwrites file
    BufferedWriter bw = new BufferedWriter(fw);        // wraps for efficiency
    bw.write("Hello, file!");
    bw.newLine();
    bw.close();                                          // saves & releases resources
} catch (IOException e) {
    System.out.println("Error writing file: " + e.getMessage());
}
```

## Reading from a File
```java
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

try {
    FileReader fr = new FileReader("example.txt");
    BufferedReader br = new BufferedReader(fr);   // wraps for efficient line reading

    String line;
    while ((line = br.readLine()) != null) {
        System.out.println(line);
    }
    br.close();
} catch (IOException e) {
    System.out.println("Error reading file: " + e.getMessage());
}
```

---

## Class Comparison
| Class | Purpose |
|---|---|
| **File** | Represents a path — manages files/directories, doesn't do actual read/write |
| **FileWriter** | Basic writing — simple text output |
| **BufferedWriter** | Wraps FileWriter — more efficient for large data |
| **FileReader** | Basic reading — character streams |
| **BufferedReader** | Wraps FileReader — efficient line-by-line reading |

---

## 🧠 Extra — What matters most
- **Always close your reader/writer** (`.close()`) — this releases the file so other programs/parts of your code can use it. This connects directly to why `finally` exists (Course 1) — closing files is the classic real-world use case.
- **Buffered classes always wrap the basic ones** — `BufferedReader(FileReader)` / `BufferedWriter(FileWriter)`. Remember this pairing pattern; it shows up in almost every file-handling example.
- `IOException` is a **checked exception** (remember from Course 1) — that's why file operations are always wrapped in try-catch, Java forces it.
- One-line takeaway: *"File represents the path, Reader/Writer handle the actual data, Buffered versions make it faster."*
