# Coding Cheatsheet: Date and Time Handling — Remember This
*(Condensed code reference — matches notes 23-26)*

## Using the Core Classes
```java
import java.time.LocalDate;
LocalDate today = LocalDate.now();
System.out.println("Today's date: " + today);
```
```java
import java.time.LocalTime;
LocalTime currentTime = LocalTime.now();
System.out.println("Current time: " + currentTime);
```
```java
import java.time.LocalDateTime;
LocalDateTime now = LocalDateTime.now();
System.out.println("Current date and time: " + now);
```
```java
import java.time.ZonedDateTime;
ZonedDateTime zonedNow = ZonedDateTime.now();
System.out.println("Current date and time with zone: " + zonedNow);
```

## Formatting a Date
```java
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

LocalDate currentDate = LocalDate.now();
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
String formattedDate = currentDate.format(formatter);
System.out.println("Formatted Date: " + formattedDate);
```

## Formatting a Birthdate (Registration Example)
```java
LocalDate birthdate = LocalDate.parse(birthdateInput);
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMM dd, yyyy");
String formattedBirthdate = birthdate.format(formatter);
System.out.println("Hello " + name + "! Your birthdate is: " + formattedBirthdate);
```
- `EEEE` = full weekday name, `MMM` = abbreviated month, `dd` = two-digit day, `yyyy` = four-digit year

## Working with Time Zones
```java
import java.time.ZoneId;
ZoneId newYorkZone = ZoneId.of("America/New_York");
System.out.println("Time Zone ID: " + newYorkZone);
```
```java
import java.time.ZonedDateTime;
import java.time.ZoneId;

ZonedDateTime newYorkTime = ZonedDateTime.now(ZoneId.of("America/New_York"));
System.out.println("Current Date and Time in New York: " + newYorkTime);
```

## Converting a Meeting Time Across Zones
```java
ZonedDateTime meetingTimeUTC = ZonedDateTime.parse("2024-12-30T15:00:00Z");
String[] participantTimeZones = {
    "America/New_York", "Europe/London", "Asia/Kolkata", "Australia/Sydney"
};
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");

System.out.println("Meeting Time in UTC: " + meetingTimeUTC.format(formatter));
for (String timeZone : participantTimeZones) {
    ZonedDateTime localTime = meetingTimeUTC.withZoneSameInstant(ZoneId.of(timeZone));
    System.out.println("Meeting Time in " + timeZone + ": " + localTime.format(formatter));
}
```
- `withZoneSameInstant()` converts the same moment into a different zone's local time

## Parsing a Date from a String
```java
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

String dateString = "2025-01-23";
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
LocalDate date = LocalDate.parse(dateString, formatter);
System.out.println("Parsed date: " + date);
```

## Parsing with a Custom Format
```java
String dateString = "23/01/2025";
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
LocalDate date = LocalDate.parse(dateString, formatter);
System.out.println("Parsed date: " + date);
```

## Parsing Date and Time Together
```java
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

String dateTimeString = "2025-01-23 15:30";
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
LocalDateTime dateTime = LocalDateTime.parse(dateTimeString, formatter);
System.out.println("Parsed date and time: " + dateTime);
```

## Extracting a Date from a Sentence
```java
import java.time.format.DateTimeParseException;

String sentence = "The event will take place on 2025-01-23.";
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
String dateString = sentence.substring(sentence.indexOf("on") + 3, sentence.indexOf("."));

try {
    LocalDate date = LocalDate.parse(dateString, formatter);
    System.out.println("Extracted date: " + date);
} catch (DateTimeParseException e) {
    System.out.println("Error parsing date: " + e.getMessage());
}
```

## Extracting Multiple Dates from Text
```java
String text = "Important dates: 2025-01-23, 2025-02-14, and 2025-03-01.";
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
String[] parts = text.split(", | and ");

for (String part : parts) {
    try {
        LocalDate date = LocalDate.parse(part.trim(), formatter);
        System.out.println("Extracted date: " + date);
    } catch (DateTimeParseException e) {
        System.out.println("Error parsing date: " + part.trim());
    }
}
```

## Extracting Dates from Mixed Content (Regex)
```java
String mixedContent = "Please note that our deadlines are on 2025-01-23 and 2025-02-28.";
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
String[] words = mixedContent.split(" ");

for (String word : words) {
    if (word.matches("\\d{4}-\\d{2}-\\d{2}")) {
        try {
            LocalDate date = LocalDate.parse(word, formatter);
            System.out.println("Extracted date: " + date);
        } catch (DateTimeParseException e) {
            System.out.println("Error parsing date: " + word);
        }
    }
}
```

---

## 🧠 Extra — What matters most
- The whole module reduces to one loop: **get/create a date → define a DateTimeFormatter pattern → format() to a string OR parse() from a string**
- Time zone code always follows: **ZoneId names the zone → ZonedDateTime holds date+time+zone → withZoneSameInstant() converts between zones**
- For messy text, escalate the tool to match the mess: known keyword → `substring()`, delimited list → `split()`, scattered/unpredictable → regex `matches()`
- Always wrap `LocalDate.parse()` / `LocalDateTime.parse()` in try-catch for `DateTimeParseException` — this is the one recurring safety net across the whole module
