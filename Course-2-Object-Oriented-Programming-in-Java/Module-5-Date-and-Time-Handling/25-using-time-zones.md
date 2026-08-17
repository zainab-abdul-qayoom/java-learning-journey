# Video: Using Time Zones in Java — Remember This

## Why Time Zones Matter
- A **time zone** is a region that follows the same standard time, defined by its offset from **UTC** (Coordinated Universal Time). Example: UTC-5 means local time is 5 hours behind UTC
- Needed for: global applications showing correct local time, scheduling meetings across regions, keeping timestamps consistent to avoid data errors

## The 4 Core Classes
| Class | What it holds | Example use |
|---|---|---|
| **ZoneId** | a time zone identifier (e.g. America/New_York) | naming a specific region's time zone |
| **ZonedDateTime** | date + time + time zone | representing an exact moment within a specific zone |
| **ZoneOffset** | a fixed offset from UTC | precise calculations without depending on time zone rules |
| **OffsetDateTime** | date + time + offset (no full zone) | database storage where only the UTC offset matters |

## Basic Usage Pattern
```java
import java.time.ZoneId;
ZoneId zone = ZoneId.of("America/New_York");
```
```java
import java.time.ZonedDateTime;
ZonedDateTime nyTime = ZonedDateTime.now(ZoneId.of("America/New_York"));
System.out.println("New York Time: " + nyTime);
```

## Real Example — Converting a Meeting Time Across Zones
```java
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

ZonedDateTime meetingTimeUTC = ZonedDateTime.parse("2026-08-17T15:00:00Z");

String[] zones = {"America/New_York", "Europe/London", "Asia/Kolkata", "Australia/Sydney"};

DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm z");

System.out.println("Meeting Time (UTC): " + meetingTimeUTC.format(formatter));

for (String zone : zones) {
    ZonedDateTime localTime = meetingTimeUTC.withZoneSameInstant(ZoneId.of(zone));
    System.out.println(zone + ": " + localTime.format(formatter));
}
```
- `ZonedDateTime.parse()` reads the meeting time in UTC
- `withZoneSameInstant()` converts that same instant into each participant's local time zone, without changing the actual moment in time
- The formatter displays date, time, and time zone abbreviation for each participant

---

## 🧠 Extra — What matters most
- **Simple rule to pick the right class:**
  - Just need to name a zone? → `ZoneId`
  - Need a full moment in time within a zone? → `ZonedDateTime`
  - Need a fixed UTC offset, no zone rules? → `ZoneOffset`
  - Need date-time with an offset but no full zone info? → `OffsetDateTime`
- `withZoneSameInstant()` is the key method for time zone conversion — same instant, different local representation
- This builds directly on `LocalDate`/`LocalDateTime` from the previous video — `ZonedDateTime` is just `LocalDateTime` plus a time zone
- Consistent timestamp formatting across zones prevents confusion and keeps data accurate in systems used globally
