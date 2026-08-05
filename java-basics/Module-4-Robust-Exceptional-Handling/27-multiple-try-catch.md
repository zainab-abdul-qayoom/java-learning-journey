# Video: Using Multiple Try Catch — Remember This

## What is Multiple Try-Catch
- Using **more than one catch block** to handle different exception types separately
- Useful when the same code could fail in different ways

```java
try {
    int[] arr = {1, 2, 3};
    System.out.println(arr[5]);   // could throw ArrayIndexOutOfBoundsException
    int x = 10 / 0;                // could throw ArithmeticException
} catch (ArrayIndexOutOfBoundsException e) {
    System.out.println("Invalid array index");
} catch (ArithmeticException e) {
    System.out.println("Math error: divide by zero");
}
```

## Why Use Multiple Catch Blocks
- **Clearer error handling** — each exception type handled on its own
- **Specific responses** — different message per error type
- **Better code organization**

## Common Real-World Uses
```java
// validating user input
try {
    int num = Integer.parseInt(userInput);
} catch (NumberFormatException e) {
    System.out.println("Invalid number entered");
}

// file handling
try {
    // read file
} catch (FileNotFoundException e) {
    System.out.println("File not found");
} catch (IOException e) {
    System.out.println("Error reading file");
}
```

## The `throws` Keyword
- Declares that a method **might** throw an exception — pushes responsibility to the caller
```java
returnType methodName(params) throws ExceptionType {
    // code that might throw
}
```
Example:
```java
void readFile() throws IOException {
    // risky file code
}

// caller MUST handle it
try {
    readFile();
} catch (IOException e) {
    System.out.println("Handle error here");
}
```

## Why Use `throws`
- **Separation of concerns** — method just focuses on its logic, doesn't have to handle everything itself
- Tells the **caller** "you're responsible for handling this"

---

## 🧠 Extra — What matters most
- `throw` vs `throws` — easy to confuse:
  - `throw` = actually raises an exception right now (`throw new Exception("msg")`)
  - `throws` = just a warning in the method signature ("this method might throw X")
- Order matters in multiple catch blocks — put **more specific exceptions first**, general ones (like `Exception`) last. Java checks top to bottom and stops at the first match.
- `NumberFormatException` is extremely common in real programs — happens whenever you try to convert bad input (like text) into a number.
