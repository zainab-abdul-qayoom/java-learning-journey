# Course-Level Coding Cheat Sheet: Java Programming for Beginners

One consolidated reference covering every topic in the course, code only. Detailed explanations for Module 3 and Module 4 topics live in their own numbered files, this is the fast end-to-end scan.

---

## Structuring Java Code and Comments

```java
System.out.println("Hello, World!"); // print to console

// single-line comment

/* multi-line comment
   spans several lines */

/**
 * Documentation comment (Javadoc style)
 * @param number The number to be squared
 * @return The square of the input number
 */
public int square(int number) {
    return number * number;
}
```

Package + folder structure:

```java
package com.example.myapp; // top of file

public class MyClass {
    // class code
}
```
Folder structure must mirror the package: `src/com/example/myapp/MyClass.java`

Imports:

```java
import java.util.List;
import java.util.ArrayList;
```

Typical project layout:

```
MyProject/
├── src/        (source code)
├── lib/        (external JARs)
├── resources/  (config, images)
├── doc/        (documentation)
└── test/       (test files)
```

---

## Exploring Data Types

Primitives:

```java
byte age = 25;                       // -128 to 127
short temperature = -5;              // -32,768 to 32,767
int population = 1000000;            // most common integer type
long distanceToMoon = 384400000L;    // large integers, note the L suffix
float price = 19.99f;                // decimals, ~7 digit precision, note the f suffix
double pi = 3.141592653589793;       // decimals, ~15 digit precision
char initial = 'A';                  // single character
boolean isLoggedIn = true;           // true/false
```

Reference types:

```java
String greeting = "Hello, World!";
int[] scores = {85, 90, 78, 92};

class Car {
    String color;
    int year;
    void displayInfo() {
        System.out.println("Color: " + color + ", Year: " + year);
    }
}

Car myCar = new Car();
myCar.color = "Red";
myCar.year = 2026;
myCar.displayInfo();

interface MyInterfaceClass {
    void methodExampleOne();
    void methodExampleTwo();
    void methodExampleThree();
}

enum DaysOfWeek {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
}
```

---

## Operators

Arithmetic (`a = 10, b = 5`):

```java
a + b   // 15
a - b   // 5
a * b   // 50
a / b   // 2
a % b   // 0
```

Relational:

```java
a == b   // false
a != b   // true
a > b    // true
a < b    // false
a >= b   // true
a <= b   // false
```

Logical (`x = true, y = false`):

```java
if (a > b && b < c) { ... }   // AND, both must be true
if (a > b || b < c) { ... }   // OR, either true
if (!(a > b)) { ... }         // NOT, negates
```

Assignment:

```java
a = 10;
a += 5;   // add and assign
a -= 2;   // subtract and assign
a *= 3;   // multiply and assign
a /= 2;   // divide and assign
a %= 4;   // modulus and assign
```

Ternary (shorthand if-else):

```java
int max = (a > b) ? a : b;
```

---

## Working with Arrays

```java
int[] numbers;                       // declare
numbers = new int[5];                // allocate
int[] numbers = new int[5];          // declare + allocate in one line
int[] numbers = {1, 2, 3, 4, 5};     // declare + initialize with values

numbers[0];         // access, index starts at 0
numbers[2] = 10;     // modify
numbers.length;      // get length

// standard for loop
for (int i = 0; i < numbers.length; i++) {
    System.out.println(numbers[i]);
}

// for-each loop
for (int number : numbers) {
    System.out.println(number);
}

// 2D array
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};
matrix[0][1]; // access row 0, column 1

// iterate a 2D array
for (int i = 0; i < matrix.length; i++) {
    for (int j = 0; j < matrix[i].length; j++) {
        System.out.print(matrix[i][j] + " ");
    }
    System.out.println();
}
```

---

## Conditional Statements

```java
if (number > 5) {
    System.out.println("The number is greater than 5.");
} else if (number == 5) {
    System.out.println("The number is equal to 5.");
} else {
    System.out.println("The number is less than 5.");
}

switch (day) {
    case 1: System.out.println("Monday"); break;
    case 2: System.out.println("Tuesday"); break;
    default: System.out.println("Weekend");
}
```

---

## Loops

```java
// for loop, known iteration count
for (int i = 1; i <= 5; i++) {
    System.out.println(i);
}

// while loop, unknown iteration count
int i = 1;
while (i <= 5) {
    System.out.println(i);
    i++;
}

// do-while, runs at least once
int j = 1;
do {
    System.out.println(j);
    j++;
} while (j <= 5);

// nested loops
for (int r = 1; r <= 10; r++) {
    for (int c = 1; c <= 10; c++) {
        System.out.print(r * c + "\t");
    }
    System.out.println();
}

// break, exits loop immediately
for (int num : numbers) {
    if (num > 5) break;
}

// continue, skips current iteration
for (int k = 1; k <= 10; k++) {
    if (k == 5) continue;
    System.out.println(k);
}
```

---

## Working with Strings

```java
String greeting = "Hello, World!";        // literal
String message = new String("Hello!");     // new keyword (rarely needed)

text.length();          // character count
word.charAt(0);          // access char at index, 0-based

String fullName = firstName + " " + lastName;      // + concatenation
String another = firstName.concat(" ").concat(lastName); // concat()

str1.equals(str2);       // content comparison, true/false

// strings are immutable, this creates a NEW string
original = original + " World";

phrase.substring(5, 16);   // extract from index 5 up to (not including) 16

text.toUpperCase();
text.toLowerCase();
"   Hello   ".trim();               // removes leading/trailing spaces
"I like cats.".replace("cats", "dogs");

"apple,banana,cherry".split(",");   // returns array
String.join(", ", colors);           // combines array into one string
```

---

## Packages and Imports

```java
package com.example.myapp;   // declare at top of file

public class MyClass { }

// in another file
import package_name.ClassName;   // import one class
import shapes.*;                  // import everything in a package
```

---

## Functions and Methods

```java
returnType functionName(paramType param1, paramType param2) {
    // code
    return value; // optional
}

public static int add(int a, int b) {
    return a + b;
}
int sum = add(5, 3);

public class Calculator {
    public int multiply(int x, int y) {
        return x * y;
    }
}
Calculator calc = new Calculator();
int product = calc.multiply(4, 5);

// method overloading, same name, different parameters
public void show(int number) { ... }
public void show(String text) { ... }

// scope
int x = 10;              // local, only inside this block
private int x;           // instance, accessible by all methods in the class
private static int count; // static, belongs to the class itself

public void printMessage() { ... }   // void, returns nothing
public void show() { ... }            // empty parameter list
```

---

## Exception Handling (Modules 4 & 5)

Full detail already in `Module-4-Robust-Exceptional-Handling/`. Quick recap:

```java
try {
    int result = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("Error: Cannot divide by zero.");
} finally {
    System.out.println("This block executes regardless of an exception.");
}

// custom exception
class MyCustomException extends Exception {
    public MyCustomException(String message) {
        super(message);
    }
}
throw new MyCustomException("This is a custom exception message.");

// multiple catch
try {
    System.out.println(numbers[5]);
    int result = 10 / 0;
} catch (ArrayIndexOutOfBoundsException e) {
    System.out.println("Error: Index out of bounds.");
} catch (ArithmeticException e) {
    System.out.println("Error: Division by zero.");
}

// throws keyword
static void readFile(String fileName) throws IOException {
    FileReader file = new FileReader(fileName);
    BufferedReader fileInput = new BufferedReader(file);
    System.out.println(fileInput.readLine());
    fileInput.close();
}

// checked exception (FileNotFoundException)
try {
    File myFile = new File("nonexistentfile.txt");
    Scanner myReader = new Scanner(myFile);
} catch (FileNotFoundException e) {
    System.out.println("An error occurred: " + e.getMessage());
}
```

---

## Quick end-to-end trap checklist
- Array/String indices start at 0
- `float` needs `f` suffix, `long` needs `L` suffix
- Strings are immutable, every "modification" makes a new string
- `finally` always runs, `return` inside `finally` overrides everything else
- Catch blocks run top to bottom, specific exception types before generic ones
- Checked exceptions must be handled or declared with `throws`, unchecked don't require either
