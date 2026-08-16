# Glossary: File Management — Remember This

*(Condensed + grouped — matches notes 18-21)*

## File Basics
- **File handling** — reading/writing files so data persists beyond program runtime
- **File class** — represents a file/directory path, doesn't perform operations itself
- **Import statement** — brings in `File` class from `java.io`
- **Class definition** — the class holding your file-handling code
- **main() method** — program entry point

## Character Streams (text files)
- **Character stream** — deals with text/character data
- **FileReader** — reads characters from a file
- **BufferedReader** — wraps FileReader, efficient line-by-line reading
- **FileWriter** — writes/creates/overwrites a file
- **BufferedWriter** — wraps FileWriter, efficient writing

## Byte Streams (binary files)
- **Byte stream** — reads/writes raw bytes, handles ANY data type (text, image, video)
- **InputStream** — abstract superclass for reading bytes
- **OutputStream** — abstract superclass for writing bytes
- **FileInputStream** — reads bytes from a file
- **FileOutputStream** — writes bytes to a file
- **BufferedInputStream / BufferedOutputStream** — buffer versions for performance

## Common Methods
- **write()** — writes data to a file
- **newline()** — adds a new line
- **close()** — saves data, releases resources
- **try block** — wraps risky read/write code for exception handling
- **Loop** — reads each line until no more remain

## Directories
- **Directories** — folders that store files/other folders
- **create directory** — makes a new folder
- **delete directory** — removes a folder (must be empty)
- **list directory** — views contents of a folder
- **mkdirs()** — creates directory + missing parent dirs (java.io)
- **list()** — returns array of file/folder names (java.io)
- **delete()** — removes directory, returns true/false (java.io)

## Java NIO (modern alternative)
- **Java NIO (New I/O)** — improved, more efficient way to handle files/directories
- **Paths.get()** — creates a Path object for a directory
- **Files.createDirectories()** — creates directory + parents (NIO version of mkdirs)

---

## 🧠 Extra — What matters most
- **Two-track rule to remember the whole module:** text files → character streams (Reader/Writer). Binary files → byte streams (InputStream/OutputStream). Directories → File class or NIO.
- The **5-step pattern** (import → define class → main → read/write in try-catch → close) applies to almost every term in this glossary — it's the skeleton behind all of Module 4.
- java.io = classic, java.nio = modern/better — you don't need to master NIO deeply yet, just recognize it exists and know one method (`Files.createDirectories()`).
