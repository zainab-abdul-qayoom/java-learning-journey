# Video: Working with Arrays — Remember This

## What is an Array
- Collection of elements, all **same type**, stored together
- Accessed using **index** (starts at 0)

## Declare & Initialize
```java
int[] numbers;                  // declare
numbers = new int[5];           // initialize (5 empty slots)

int[] numbers = new int[5];     // both in one line

int[] numbers = {1, 2, 3, 4, 5}; // declare + assign values directly
```

## Access & Modify
```java
numbers[0]     // first element
numbers[4]     // last element (if size 5)
numbers[2] = 10;   // change 3rd element's value
numbers.length     // gives size of array
```

## Loop Through an Array
```java
for (int i = 0; i < numbers.length; i++) {
    System.out.println(numbers[i]);
}
```
- Also can use **for-each loop** (enhanced for loop) — simpler when you don't need the index

## 2D Arrays (grid / matrix)
```java
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};

matrix[0][1]   // row 0, column 1 → value 2
```

**Nested loop to print all values:**
```java
for (int i = 0; i < matrix.length; i++) {        // rows
    for (int j = 0; j < matrix[i].length; j++) {  // columns
        System.out.print(matrix[i][j] + " ");
    }
    System.out.println();
}
```

---

## 🧠 Extra — What matters most
- **Index starts at 0** — always. Array of size 5 → valid indices are 0 to 4, not 1 to 5.
- `array.length` (no parentheses) — common beginner mistake is writing `array.length()` like a method.
- 2D arrays = "array of arrays" — outer loop = rows, inner loop = columns. This nested loop pattern comes up constantly, worth practicing by hand.
