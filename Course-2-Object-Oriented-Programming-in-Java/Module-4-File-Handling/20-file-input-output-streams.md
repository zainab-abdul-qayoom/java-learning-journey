# Video: Working with File Input and Output Streams — Remember This

*(Mostly overlaps with note 18 — same File/FileWriter/BufferedWriter/FileReader/BufferedReader classes. This note captures what's new: the standard step-by-step pattern.)*

## The Standard File-Handling Pattern (memorize this workflow)
Every file read/write program in Java follows the same 5 steps:
1. **Import** the necessary classes
2. **Define** the class
3. **Start** in the `main` method
4. **Perform** the read or write operation (inside try-catch)
5. **Close** the reader/writer

## Quick Recap: Writing
```java
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

try {
    FileWriter writer = new FileWriter("output.txt");   // creates or overwrites
    BufferedWriter bufferedWriter = new BufferedWriter(writer);
    bufferedWriter.write("Hello, World!");
    bufferedWriter.newLine();
    bufferedWriter.close();
} catch (IOException e) {
    System.out.println(e.getMessage());
}
```

## Quick Recap: Reading
```java
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

try {
    FileReader reader = new FileReader("output.txt");
    BufferedReader bufferedReader = new BufferedReader(reader);
    String line;
    while ((line = bufferedReader.readLine()) != null) {
        System.out.println(line);
    }
    bufferedReader.close();
} catch (IOException e) {
    System.out.println(e.getMessage());
}
```

## Why File Handling Matters (recap)
- **Persistence** — data survives after the program closes
- **Sharing** — files can be shared between programs/users
- **Configuration** — apps use config files for settings across dev/test/prod environments

---

## 🧠 Extra — What matters most
- This video is essentially reinforcement of note 18 — if you're comfortable with that one, you already know this.
- The real takeaway: **the 5-step pattern (import → define → main → read/write → close) is the same every single time you do file I/O in Java.** Once this becomes muscle memory, file handling stops feeling new each time.
