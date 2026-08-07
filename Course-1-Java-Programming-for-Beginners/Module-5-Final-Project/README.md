# Final Project: Grocery Shopping Cart

A console-based grocery shopping application built as the final project for this module, applying custom exception handling to a real interactive program instead of an isolated exercise.

## What it does

The program simulates a simple grocery store checkout:

- Displays a fixed catalog of 10 items with prices (Mango, Apple, Milk, Bread, Noodles, Pasta, Guava, Carrot, Tomato, Potato)
- Lets the user repeatedly type an item name and quantity to add to their cart
- Calculates a running total bill as items are added
- Lets the user type `finish` to close out a cart and see the final total
- After finishing a cart, lets the user start a new cart or type `exit` to quit the program entirely

## Concepts demonstrated

**Custom checked exception**
`ItemNotFoundException` extends `Exception` and is thrown whenever the user types an item name that isn't in the catalog. This is a textbook use case for a custom exception: a business rule ("this item must exist") that has nothing to do with a language-level error, so it deserves its own exception type rather than reusing a generic one.

**Catch block ordering**
The specific exception (`ItemNotFoundException`) is caught before the generic one (`Exception`). If the order were reversed, the generic catch would intercept the custom exception first and it would never fire as intended, catch blocks are always checked top to bottom, most specific first.

**Handling bad user input safely**
When the user types a non-numeric quantity, `Scanner.nextInt()` throws `InputMismatchException` without consuming the invalid input from the buffer. The generic catch block calls `sc.nextLine()` to clear that leftover input, preventing the program from getting stuck in an infinite error loop on the same bad entry.

**Nested loop structure for a real interactive flow**
An inner loop handles adding items to a single cart until the user finishes. An outer loop lets the user start a brand new cart afterward, or exit the whole program. This mirrors how a real checkout system would let a cashier serve multiple customers in one session.

## How to run

```
javac GroceryShopping.java
java GroceryShopping
```

Follow the prompts to add items by name and quantity, type `finish` to see your total, then either press Enter to start a new cart or type `exit` to close the program.

## Possible improvements

- Reject negative or zero quantities before adding them to the bill
- Add a dedicated `catch (InputMismatchException e)` block for a more specific error message on bad quantity input
- Let the user view the full catalog and prices before typing an item name
