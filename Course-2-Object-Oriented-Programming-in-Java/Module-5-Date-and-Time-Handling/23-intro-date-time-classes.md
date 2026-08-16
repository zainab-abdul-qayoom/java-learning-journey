# Video: An Introduction to Java Date and Time Classes — Remember This

## The Package
- Java uses **java.time** — the modern package for date/time handling

## The 4 Core Classes
| Class | What it holds | Example use |
|---|---|---|
| **LocalDate** | year, month, day (no time) | birthday, calendar date |
| **LocalTime** | hours, minutes, seconds (no date) | alarm clock, timing a race |
| **LocalDateTime** | date + time (no timezone) | scheduling a local meeting |
| **ZonedDateTime** | date + time + timezone | flight schedules, meetings across timezones |

## Basic Usage Pattern (same for all 4)
```java
import java.time.LocalDate;

LocalDate today = LocalDate.now();
System.out.println("Today's Date: " + today);   // format: YYYY-MM-DD
```

```java
import java.time.LocalTime;

LocalTime now = LocalTime.now();
System.out.println("Current Time: " + now);
```

```java
import java.time.LocalDateTime;

LocalDateTime dateTime = LocalDateTime.now();
System.out.println("Current Date & Time: " + dateTime);
```

```java
import java.time.ZonedDateTime;

ZonedDateTime zonedDateTime = ZonedDateTime.now();
System.out.println("Date, Time & Zone: " + zonedDateTime);
// format: yyyy-MM-dd HH:mm:ss + timezone
```

---

## 🧠 Extra — What matters most
- **Simple rule to pick the right class:**
  - Just a date? → `LocalDate`
  - Just a time? → `LocalTime`
  - Both, no timezone? → `LocalDateTime`
  - Both + timezone matters? → `ZonedDateTime`
- All 4 classes follow the **same pattern**: `import` → `ClassName.now()` → `println`. Once you know one, you basically know all four.
- `java.time` replaced the old, clunky `Date`/`Calendar` classes from earlier Java versions — if you ever see old code using those, know that `java.time` is the modern, correct approach.
