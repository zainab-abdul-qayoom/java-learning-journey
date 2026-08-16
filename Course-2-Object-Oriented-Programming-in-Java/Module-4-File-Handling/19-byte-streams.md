# Video: Using Byte Streams in Java — Remember This

## What is a Byte Stream
- Reads/writes **raw bytes** — works with ANY data type (text, images, video)
- Analogy: a conveyor belt moving raw materials

## Key Classes
| Class | Purpose |
|---|---|
| **InputStream** | abstract superclass — for reading bytes |
| **OutputStream** | abstract superclass — for writing bytes |
| **FileInputStream** | reads bytes from a file |
| **FileOutputStream** | writes bytes to a file |
| **BufferedInputStream / BufferedOutputStream** | wrap the above for better performance |

## Reading with FileInputStream
```java
import java.io.FileInputStream;

FileInputStream fis = new FileInputStream("example.bin");
int byteData;
while ((byteData = fis.read()) != -1) {   // -1 = end of file
    System.out.print((char) byteData);
}
fis.close();
```

## Writing with FileOutputStream
```java
import java.io.FileOutputStream;

FileOutputStream fos = new FileOutputStream("example.bin");
fos.write(65);   // writes one byte
fos.close();
```

## Copying a File (byte by byte)
```java
FileInputStream fis = new FileInputStream("input.txt");
FileOutputStream fos = new FileOutputStream("output.txt");

int byteData;
while ((byteData = fis.read()) != -1) {
    fos.write(byteData);
}
fis.close();
fos.close();
```

---

## Byte Streams vs Character Streams (important comparison)
| | Byte Streams | Character Streams |
|---|---|---|
| Handles | Raw binary data | Text/characters |
| Base classes | InputStream, OutputStream | Reader, Writer |
| Common subclasses | FileInputStream, FileOutputStream | FileReader, FileWriter |
| Encoding | None — raw bytes | Uses character encoding |
| Best for | Images, audio, video, binary files | Text files |

---

## Real-World Uses
- Reading/writing binary files (images, videos)
- Network programming (sending/receiving binary data over sockets)
- Serialization (converting objects into byte format)
- Multimedia processing

---

## 🧠 Extra — What matters most
- **Simple rule: text file → character stream (Reader/Writer). Binary file (image, video, etc.) → byte stream (InputStream/OutputStream).** This is THE core takeaway and a common quiz question.
- `read()` returning `-1` means "end of file" — same pattern you'll see across many Java I/O classes, worth remembering.
- This connects directly to last video — FileReader/BufferedReader (character streams, text) vs FileInputStream/FileOutputStream (byte streams, binary) are the two "modes" of file handling in Java.
