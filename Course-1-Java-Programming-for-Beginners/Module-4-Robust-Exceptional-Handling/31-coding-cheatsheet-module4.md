# Coding Cheat Sheet: Module 4 — Robust Exception Handling

Fast lookup, code only. Full explanations live in files 25-30.

## Basic try-catch-finally

```java
try {
    // risky code
} catch (ExceptionType e) {
    // handle it
} finally {
    // always runs
}
```

## Divide-by-zero example

```java
try {
    int result = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("Error: Cannot divide by zero.");
} finally {
    System.out.println("This block executes regardless of an exception.");
}
```

## Custom exception

```java
class MyCustomException extends Exception {
    public MyCustomException(String message) {
        super(message);
    }
}

try {
    throw new MyCustomException("This is a custom exception message.");
} catch (MyCustomException e) {
    System.out.println(e.getMessage());
}
```

## Finally block, correct resource cleanup pattern

```java
FileReader file = null;
try {
    file = new FileReader("example.txt");
    // read
} catch (IOException e) {
    System.out.println("Error reading file: " + e.getMessage());
} finally {
    try {
        if (file != null) {
            file.close();
        }
    } catch (IOException e) {
        System.out.println("Error closing file: " + e.getMessage());
    }
}
```

Same pattern applies for DB connections:

```java
Connection connection = null;
try {
    connection = DriverManager.getConnection(url, user, password);
    // db ops
} catch (SQLException e) {
    System.out.println("Database error: " + e.getMessage());
} finally {
    try {
        if (connection != null) connection.close();
    } catch (SQLException e) {
        System.out.println("Error closing connection: " + e.getMessage());
    }
}
```

## Finally block anti-patterns (know these for quiz traps)

Exception thrown inside finally itself, masks the original one:

```java
finally {
    int x = 10 / 0; // suppresses whatever exception came before it
}
```

Return in finally overrides return in try/catch, always avoid this:

```java
static int testMethod() {
    try {
        return 1;
    } catch (Exception e) {
        return 2;
    } finally {
        return 3; // this wins, always. Method returns 3.
    }
}
```

## Multiple catch blocks

```java
try {
    System.out.println(numbers[5]); // ArrayIndexOutOfBoundsException
    int result = 10 / 0;            // ArithmeticException
} catch (ArrayIndexOutOfBoundsException e) {
    System.out.println("Error: Index out of bounds.");
} catch (ArithmeticException e) {
    System.out.println("Error: Division by zero.");
}
```

Only the first matching catch runs, order matters: specific exceptions before general ones.

## throws keyword (declaring, not handling)

```java
static void readFile(String fileName) throws IOException {
    FileReader file = new FileReader(fileName);
    BufferedReader fileInput = new BufferedReader(file);
    System.out.println(fileInput.readLine());
    fileInput.close();
}

// caller must handle it
try {
    readFile("nonexistentfile.txt");
} catch (IOException e) {
    System.out.println("Error: " + e.getMessage());
}
```

## Checked exception example (FileNotFoundException)

```java
try {
    File myFile = new File("nonexistentfile.txt");
    Scanner myReader = new Scanner(myFile);
    while (myReader.hasNextLine()) {
        System.out.println(myReader.nextLine());
    }
    myReader.close();
} catch (FileNotFoundException e) {
    System.out.println("An error occurred: " + e.getMessage());
}
```

## Runtime exception example (ArithmeticException)

```java
int numerator = 10;
int denominator = 0;
try {
    int result = numerator / denominator;
} catch (ArithmeticException e) {
    System.out.println("An error occurred: Cannot divide by zero.");
}
```

## Custom checked exception with throw + throws (from the lab)

```java
class StudentUnderAgeException extends Exception {
    public StudentUnderAgeException(String message) {
        super(message);
    }
}

public Student(String name, int age, String major) throws StudentUnderAgeException {
    if (age < 18) {
        throw new StudentUnderAgeException("Student age has to be 18 or more");
    }
    this.age = age;
}

// catching it
try {
    Student s = new Student("Ali", 16, "CS");
} catch (StudentUnderAgeException suae) {
    System.out.println(suae.getMessage());
}
```

## Cloneable + checked exception (from the lab)

```java
class Student implements Cloneable {
    public Student clone() throws CloneNotSupportedException {
        return (Student) super.clone();
    }
}

try {
    Student student2 = student1.clone();
} catch (CloneNotSupportedException cnse) {
    System.out.println("You can't clone this object!");
}
```

## Quick trap checklist before the quiz
- finally always runs, except program crash or forced termination (System.exit, etc.)
- return in finally silently overrides return in try/catch
- exception thrown inside finally suppresses an exception from try/catch
- catch blocks are checked top to bottom, most specific exception type first
- checked = compiler forces handling. unchecked = compiles fine, fails at runtime only
