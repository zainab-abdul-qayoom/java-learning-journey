# Glossary: Date and Time Handling — Remember This
*(Condensed + grouped — matches notes 23-26)*

## Core Classes (java.time)
- **LocalDate** — date only, no time or time zone (year, month, day)
- **LocalTime** — time only, no date (hour, minute, second)
- **LocalDateTime** — date + time together, no time zone
- **ZonedDateTime** — date + time + time zone
- **Java 8 Time API** — the java.time package introduced in Java 8, the modern way to handle dates and times

## Formatting
- **formatting** — converting a date/time object into a readable string
- **DateTimeFormatter** — the class used to define patterns for both parsing and formatting
- **defining format** — creating a DateTimeFormatter with a chosen pattern
- **date format** — a pattern for representing dates as strings, e.g. dd/MM/yyyy or yyyy-MM-dd
- **Format Style** — predefined DateTimeFormatter styles: SHORT, MEDIUM, LONG, FULL
- **get current date** — using LocalDate.now() to fetch today's date
- **full weekday name** — the complete name of a day, e.g. Monday
- **ISO-8601** — an international standard format for representing dates and times

## Parsing
- **parsing** — converting a string into a date/time object (the reverse of formatting)
- **LocalDate.parse()** — converts a string into a LocalDate using a matching pattern
- **LocalDate.of()** — creates a LocalDate from a specific year, month, and day
- **extraction** — pulling specific information, like a date, out of a larger piece of text
- **delimiters** — characters used to split strings into parts, such as commas or spaces
- **date validation** — checking whether a date string is valid for a given format
- **DateTimeParseException** — thrown when a string cannot be parsed into a valid date/time object
- **error message** — shown when parsing or another operation fails

## Time Zones
- **UTC** — the coordinated universal time standard used globally as the time reference point
- **ZoneId** — an identifier for a time zone, e.g. Asia/Kolkata
- **ZoneOffset** — a fixed amount of time added or subtracted from UTC to get local time
- **OffsetDateTime** — date and time with a UTC offset, but no full time zone info, useful for database storage
- **daylight saving time (DST)** — clocks moved forward in warmer months to extend evening daylight

## Other Date/Time Classes
- **Instant** — a single moment on the timeline, always in UTC
- **Duration** — a time-based amount, such as hours or minutes
- **Year** — represents just a year, e.g. 2025
- **YearMonth** — represents a year and month combined, without a day
- **MonthDay** — represents a month and day combined, without a year
- **Epoch / epoch time** — the reference starting point of computing time, January 1 1970, measured in seconds or milliseconds since then

## Practical Use
- **database storage** — storing dates in the specific format a database requires
- **date manipulation** — adding or subtracting days, months, or years from a date

---

## 🧠 Extra — What matters most
- Two-track rule for this module: **no time zone needed** → LocalDate/LocalTime/LocalDateTime. **time zone matters** → ZonedDateTime/ZoneId/ZoneOffset/OffsetDateTime.
- Formatting and parsing are mirror operations, both driven by the same DateTimeFormatter pattern — format turns an object into a string, parse turns a string into an object.
- Always wrap parsing in a try-catch, since a DateTimeParseException is common with real-world, unpredictable input text.
- UTC is the anchor for everything time-zone related — ZoneId and ZoneOffset both exist to describe a position relative to UTC.
