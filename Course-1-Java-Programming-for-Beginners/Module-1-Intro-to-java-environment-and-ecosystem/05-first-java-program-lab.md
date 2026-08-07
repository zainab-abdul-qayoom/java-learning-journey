# Java Terminal Commands — Easy Guide

## Basic Commands (used in the lab)

| Command | What it does (easy explanation) |
|---|---|
| `touch MyFirstProgram.java` | Creates a new empty file named `MyFirstProgram.java` |
| `javac MyFirstProgram.java` | **Compiles** your code — converts `.java` (human code) into `.class` (bytecode Java understands) |
| `java MyFirstProgram` | **Runs** your program (no `.class` or `.java` extension needed here) |
| `mkdir foldername` | Creates a new folder |
| `mkdir -p a/b/c` | Creates nested folders in one go (a, then b inside a, then c inside b) |
| `cd foldername` | Moves you **into** that folder |
| `mv file destination` | Moves a file from one place to another |
| `rm filename` | Deletes a file |
| `javac -d classes src/File.java` | Compiles the file, but puts the output `.class` file inside the `classes` folder instead of next to the source |
| `export CLASSPATH=$CLASSPATH:/path` | Tells Java **where to look** for compiled `.class` files when running a program |

---

## Most Commonly Used (you'll use these 90% of the time)

```bash
javac FileName.java      # compile
java FileName             # run
mkdir foldername          # create folder
cd foldername              # go inside folder
ls                         # see what's inside current folder
pwd                        # show your current location/path
```

---

## 🧠 Extra — Good to Know
- `.java` = source code file (what you write)
- `.class` = compiled bytecode (what Java actually runs)
- Always compile before you run — if you change code, recompile again
- `CLASSPATH` errors are common — it just means Java doesn't know where your `.class` file is
