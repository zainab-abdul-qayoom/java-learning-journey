# Video: Formatting Dates in Java — Remember This

## The Tool
- **DateTimeFormatter** — the class used to format dates in the `java.time` package
- Formatting = turning a date object into a **string** that follows a chosen pattern

## Common Format Patterns
| Pattern | Example |
|---|---|
| Day, Month, Year | 15-05-1990 |
| Year, Month, Day | 1990-05-15 |
| Month, Day, Year | 05-15-1990 |
| Full weekday, short month, day, full year | Tuesday, May 15th, 1990 |

## Basic Usage Pattern
```java
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

LocalDate today = LocalDate.now();
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy");
String formattedDate = today.format(formatter);
System.out.println("Formatted Date: " + formattedDate);
```

## Real Example — Formatting a Birthdate
```java
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

Scanner scanner = new Scanner(System.in);

System.out.print("Enter your name: ");
String name = scanner.nextLine();

System.out.print("Enter your birthdate (yyyy-mm-dd): ");
String input = scanner.nextLine();
LocalDate birthdate = LocalDate.parse(input);

DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMM d'th', yyyy");
String formatted = birthdate.format(formatter);

System.out.println("Hello " + name + ", your birthdate is " + formatted);

scanner.close();
```
Input: `John Doe`, `1990-05-15`
Output: `Hello John Doe, your birthdate is Tuesday, May 15th, 1990`

## Why Formatting Matters
- **User interfaces** — dates need to be shown in a way people can read easily
- **Databases** — many databases require a specific date format to store dates correctly
- **Logging** — formatted timestamps make it easier to trace what happened and when

---

## 🧠 Extra — What matters most
- Two steps, always: **1) create a DateTimeFormatter with a pattern → 2) call .format() on the date object**
- `LocalDate.parse(string)` turns user input into a real date object you can work with — this is the reverse of formatting
- The pattern letters are worth memorizing loosely: `yyyy` = year, `MM`/`MMM` = month, `dd`/`d` = day, `EEEE` = full weekday name
- Same DateTimeFormatter approach works for LocalTime, LocalDateTime, and ZonedDateTime too — not just LocalDate
