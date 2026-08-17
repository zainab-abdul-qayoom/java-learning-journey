# Video: Parsing Dates from Strings — Remember This

## What Parsing Means
- **Parsing** = analyzing a string of text to extract meaningful information, converting raw data into a structured format the system can use
- Example: typing `21 02 2030` is just text until parsing recognizes it as a day, month, and year
- **DateTimeFormatter** does double duty — it defines patterns for both **parsing** (string to date) and **formatting** (date to string)

## Basic Usage Pattern
```java
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

String dateString = "2030-02-21";
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
LocalDate date = LocalDate.parse(dateString, formatter);
System.out.println("Parsed Date: " + date);
```

## Customizing the Pattern
```java
String dateString = "21/02/2030";
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
LocalDate date = LocalDate.parse(dateString, formatter);
System.out.println("Parsed Date: " + date);
```
- The pattern must match the exact shape of the input string
- To parse both date and time together, use `LocalDateTime.parse()` instead of `LocalDate.parse()`

## Extracting a Date from a Sentence
```java
String sentence = "The event will happen on 2030-02-21.";
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

int startIndex = sentence.indexOf("on ") + 3;
int endIndex = sentence.indexOf(".");
String extracted = sentence.substring(startIndex, endIndex);

try {
    LocalDate date = LocalDate.parse(extracted, formatter);
    System.out.println("Extracted Date: " + date);
} catch (Exception e) {
    System.out.println("Could not parse date.");
}
```
- `substring()` locates the keyword (like "on") and pulls out the text up to a delimiter (like a period)
- Wrap parsing in a try-catch since invalid text will cause parsing to fail

## Extracting Multiple Dates from a String
```java
String text = "2030-02-21, 2030-03-15 and 2030-04-01";
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

String[] parts = text.split(",|and");

for (String part : parts) {
    try {
        LocalDate date = LocalDate.parse(part.trim(), formatter);
        System.out.println("Parsed Date: " + date);
    } catch (Exception e) {
        System.out.println("Invalid date: " + part.trim());
    }
}
```
- `split()` breaks the string using delimiters like commas and the word "and"
- Each part is trimmed and parsed individually, with errors handled per part

## Extracting Dates from Mixed Content Using Regex
```java
String text = "Meeting notes 2030-02-21 discussed budget 2030-03-15 for review";
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

String[] words = text.split(" ");

for (String word : words) {
    if (word.matches("\\d{4}-\\d{2}-\\d{2}")) {
        LocalDate date = LocalDate.parse(word, formatter);
        System.out.println("Found Date: " + date);
    }
}
```
- The string is split into individual words
- Each word is checked with a regex pattern to see if it matches the date shape
- Matching words are parsed into LocalDate

---

## 🧠 Extra — What matters most
- Parsing is the reverse of formatting: **formatting** turns a date object into a string, **parsing** turns a string into a date object
- Always match the DateTimeFormatter pattern exactly to the shape of the input string, or parsing will throw an error
- For messy or unpredictable text, use `substring()` for known keywords, `split()` for delimited lists, and regex for scattered or mixed content
- Wrapping parse calls in try-catch is a recurring theme, since real-world text often does not match the expected format
