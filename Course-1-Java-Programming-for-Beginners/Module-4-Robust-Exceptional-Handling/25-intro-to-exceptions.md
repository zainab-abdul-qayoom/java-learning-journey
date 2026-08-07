# Video: An Introduction to Exceptions — Remember This

## What is an Exception
- An **event that disrupts** the normal flow of a program (error during execution)
- Examples: divide by zero, invalid array index, file not found

## Exception vs Error
| | Exception | Error |
|---|---|---|
| Meaning | Something the app **can** try to handle | Serious issue, **can't** recover from |
| Example | Bad user input, null reference | JVM out of memory, stack overflow |
| Action | Catch and handle | Usually outside programmer's control — don't try to catch |

## Checked Exceptions (compiler checks these — must handle)
- Must use try-catch OR declare with `throws`
- Examples: `IOException`, `SQLException`, `ClassNotFoundException`

## Unchecked Exceptions (compiler doesn't check — coding mistakes)
- Examples: `NullPointerException`, `ArrayIndexOutOfBoundsException`, `ArithmeticException`, `IllegalArgumentException`

## try-catch-finally
```java
try {
    int result = 10 / 0;      // risky code
} catch (ArithmeticException e) {
    System.out.println("Error: " + e.getMessage());
} finally {
    System.out.println("This always runs");  // cleanup
}
```
- **try** — code that might fail
- **catch** — handles the exception if it happens
- **finally** — always runs, error or not (used for cleanup)

## Custom Exception
```java
class MyCustomException extends Exception {
    public MyCustomException(String message) {
        super(message);
    }
}

// usage
throw new MyCustomException("Something went wrong");
```

---

## 🧠 Extra — What matters most
- **Checked vs Unchecked** is a top interview question:
  - Checked = compiler forces you to handle it (file/database stuff)
  - Unchecked = your own coding bugs (null, bad index, divide by zero)
- **NullPointerException** is the single most common runtime error in real Java code — get comfortable reading it.
- `finally` always runs — even if there's a `return` in the try block. Great for closing files/database connections.
