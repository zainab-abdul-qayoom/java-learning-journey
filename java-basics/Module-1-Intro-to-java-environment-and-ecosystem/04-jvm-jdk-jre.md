# Video: JVM, JDK, JRE Explained — Remember This

## JVM (Java Virtual Machine)
- Converts **bytecode → machine code** (JIT compilation)
- Makes Java **platform independent**
- Handles **garbage collection** (auto memory cleanup)
- Analogy: a **translator** between human code and machine

## JDK (Java Development Kit)
- For **developers** — has everything to write, compile, run Java
- Contains: JRE + Javac compiler + debugger + APIs
- Analogy: a **carpenter's full toolbox**

## JRE (Java Runtime Environment)
- For **running** Java apps only (no coding tools)
- Contains: JVM + core libraries
- Analogy: a **fully furnished room** (ready to use, can't renovate)

## Relationship (draw this if asked in interview)
```
JDK ⊃ JRE ⊃ JVM
(JDK contains JRE, JRE contains JVM)
```

## Quick Flow
`.java file` → compiled by **javac** → bytecode → run by **JVM** → machine code

---

## 🧠 Extra — What matters most as a developer
- **This is a top 3 most-asked Java interview question.** Be able to explain JDK vs JRE vs JVM in one line each without hesitating.
- One-line answer to memorize:
  *"JDK is for developing, JRE is for running, JVM is the engine inside both that actually executes the code."*
- When you install Java to code (not just run apps), you install **JDK** — this trips up beginners.
