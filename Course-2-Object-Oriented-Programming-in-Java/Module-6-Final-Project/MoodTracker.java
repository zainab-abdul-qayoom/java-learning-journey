import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class MoodTracker {

    // One Scanner shared by every method that needs to read from the keyboard.
    // It's "static" so all the static methods below can use the same one.
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Mood> moodsList = new ArrayList<>();
        boolean running = true; // controls the loop; flips to false when user types "Exit"

        while (running) {
            System.out.println("Press 'a' to add mood\n" +
                    "'d' to delete mood(s)\n" +
                    "'e' to edit mood\n" +
                    "'s' to search for moods\n" +
                    "'M' to get all moods\n" +
                    "'w' to write the moods to a file\n" +
                    "Type 'Exit' to exit");
            String menuOption = scanner.nextLine();

            // Each case calls a separate method instead of dumping code
            // straight into the switch, which is what caused the original file
            // to not compile (code was floating outside any method at all).
            switch (menuOption) {
                case "a":
                    addMood(moodsList);
                    break;
                case "d":
                    deleteMoodMenu(moodsList);
                    break;
                case "e":
                    editMoodMenu(moodsList);
                    break;
                case "s":
                    searchMoodMenu(moodsList);
                    break;
                case "M":
                    printAllMoods(moodsList);
                    break;
                case "w":
                    writeMoodsToFile(moodsList);
                    break;
                case "Exit":
                    System.out.println("Thank you for using the MoodTracker. Goodbye!");
                    running = false; // this is what actually ends the while loop
                    break;
                default:
                    System.out.println("Not a valid input!");
            }
        }
        scanner.close();
    }

    // ---------------- ADD ----------------

    private static void addMood(ArrayList<Mood> moodsList) {
        System.out.println("Enter the mood name");
        String moodName = scanner.nextLine();
        System.out.println("Are you tracking the mood for the current day? y/n");
        String isForCurrentDate = scanner.nextLine();
        Mood moodToAdd = null;

        if (isForCurrentDate.equalsIgnoreCase("n")) {
            // User wants a custom date/time, so we parse it from text input.
            try {
                System.out.println("Input the date in MM/dd/yyyy format:");
                String moodDateStr = scanner.nextLine();
                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
                LocalDate moodDate = LocalDate.parse(moodDateStr, dateFormatter);

                System.out.println("Input the time in HH:mm:ss format:");
                String moodTimeStr = scanner.nextLine();
                DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                LocalTime moodTime = LocalTime.parse(moodTimeStr, timeFormatter);

                System.out.println("Add notes about this mood");
                String moodNotes = scanner.nextLine();

                moodToAdd = moodNotes.strip().isEmpty()
                        ? new Mood(moodName, moodDate, moodTime)
                        : new Mood(moodName, moodDate, moodTime, moodNotes);
            } catch (DateTimeParseException dfe) {
                // "return" (not "continue") exits just this method and drops back to the menu.
                System.out.println("Incorrect format of date or time. Cannot create mood.\n" + dfe);
                return;
            }
        } else {
            // Current date/time -> the simpler Mood constructors fill those in automatically.
            System.out.println("Add notes about this mood");
            String moodNotes = scanner.nextLine();
            moodToAdd = moodNotes.strip().isEmpty()
                    ? new Mood(moodName)
                    : new Mood(moodName, moodNotes);
        }

        try {
            if (isMoodValid(moodToAdd, moodsList)) {
                moodsList.add(moodToAdd);
                System.out.println("The mood has been added to the tracker");
            }
        } catch (InvalidMoodException ime) {
            System.out.println("The mood is not valid: " + ime.getMessage());
        }
    }

    // Checks the list for a duplicate; throws an exception instead of returning false,
    // matching how the exception is used in addMood() above.
    public static boolean isMoodValid(Mood mood, ArrayList<Mood> moodsList) throws InvalidMoodException {
        for (Mood tempMood : moodsList) {
            if (tempMood.equals(mood)) {
                throw new InvalidMoodException();
            }
        }
        return true;
    }

    // ---------------- DELETE ----------------

    private static void deleteMoodMenu(ArrayList<Mood> moodsList) {
        try {
            System.out.println("Input the date of the mood(s) to delete, in MM/dd/yyyy format:");
            String moodDateStr = scanner.nextLine();
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            LocalDate moodDate = LocalDate.parse(moodDateStr, dateFormatter);

            boolean removed = deleteMoods(moodDate, moodsList);
            System.out.println(removed ? "Mood(s) on that date were deleted."
                                        : "No moods found on that date.");
        } catch (DateTimeParseException dfe) {
            System.out.println("Incorrect date format. Cannot delete mood.");
        }
    }

    // Deletes every mood on the given date.
    // NOTE: the original used a for-each loop and called moodsList.remove() inside it —
    // that throws a ConcurrentModificationException in Java (you can't resize a list
    // while a for-each loop is walking through it). removeIf() is the safe way to do this.
    public static boolean deleteMoods(LocalDate moodDate, ArrayList<Mood> moodsList) {
        return moodsList.removeIf(mood -> mood.getDate().equals(moodDate));
    }

    // ---------------- EDIT ----------------

    private static void editMoodMenu(ArrayList<Mood> moodsList) {
        try {
            System.out.println("Enter the mood name");
            String moodName = scanner.nextLine();
            System.out.println("Input the date in MM/dd/yyyy format:");
            String moodDateStr = scanner.nextLine();
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            LocalDate moodDate = LocalDate.parse(moodDateStr, dateFormatter);

            System.out.println("Input the time in HH:mm:ss format:");
            String moodTimeStr = scanner.nextLine();
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            LocalTime moodTime = LocalTime.parse(moodTimeStr, timeFormatter);

            System.out.println("Add new notes about this mood");
            String moodNotes = scanner.nextLine();

            if (moodNotes.strip().isEmpty()) {
                System.out.println("No notes entered");
                return;
            }

            // This "search key" mood only needs name/date/time to match — its notes
            // are the new notes we want to apply to the real mood in the list.
            Mood moodToEdit = new Mood(moodName, moodDate, moodTime, moodNotes);
            boolean isMoodEdited = editMood(moodToEdit, moodsList);
            System.out.println(isMoodEdited ? "The mood has been successfully edited"
                                             : "No matching mood could be found");
        } catch (DateTimeParseException dfe) {
            System.out.println("Incorrect format of date or time. Cannot edit mood.");
        }
    }

    // Finds the matching mood already in the list and copies the new notes onto it.
    public static boolean editMood(Mood moodToEdit, ArrayList<Mood> moodsList) {
        for (Mood tempMood : moodsList) {
            if (tempMood.equals(moodToEdit)) {
                tempMood.setNotes(moodToEdit.getNotes());
                return true;
            }
        }
        return false;
    }

    // ---------------- SEARCH ----------------

    private static void searchMoodMenu(ArrayList<Mood> moodsList) {
        System.out.println("Enter '1' to search for all moods by date\n" +
                "Enter '2' to search for a specific mood");
        String searchVariant = scanner.nextLine();

        if (searchVariant.equals("1")) {
            try {
                System.out.println("Input the date in MM/dd/yyyy format:");
                String moodDateStr = scanner.nextLine();
                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
                LocalDate moodDate = LocalDate.parse(moodDateStr, dateFormatter);
                searchMoods(moodDate, moodsList);
            } catch (DateTimeParseException dfe) {
                System.out.println("Incorrect format of date. Cannot search mood.");
            }
        } else if (searchVariant.equals("2")) {
            try {
                System.out.println("Enter the mood name");
                String moodName = scanner.nextLine();
                System.out.println("Input the date in MM/dd/yyyy format:");
                String moodDateStr = scanner.nextLine();
                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
                LocalDate moodDate = LocalDate.parse(moodDateStr, dateFormatter);
                System.out.println("Input the time in HH:mm:ss format:");
                String moodTimeStr = scanner.nextLine();
                DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                LocalTime moodTime = LocalTime.parse(moodTimeStr, timeFormatter);

                Mood searchTarget = new Mood(moodName, moodDate, moodTime);
                searchMood(searchTarget, moodsList);
            } catch (DateTimeParseException dfe) {
                System.out.println("Incorrect format of date or time. Cannot search mood.");
            }
        } else {
            System.out.println("Not a valid option!");
        }
    }

    // Prints every mood that happened on a given date.
    public static void searchMoods(LocalDate moodDate, ArrayList<Mood> moodsList) {
        boolean found = false;
        for (Mood tempMood : moodsList) {
            if (tempMood.getDate().equals(moodDate)) {
                found = true;
                System.out.println(tempMood);
            }
        }
        if (!found) {
            System.out.println("No matching records could be found!");
        }
    }

    // Prints one specific mood (matched by name+date+time) if it exists.
    // The original file called this "searchMood" but never defined it — added here.
    public static void searchMood(Mood target, ArrayList<Mood> moodsList) {
        for (Mood tempMood : moodsList) {
            if (tempMood.equals(target)) {
                System.out.println(tempMood);
                return;
            }
        }
        System.out.println("No matching record could be found!");
    }

    // ---------------- PRINT ALL ----------------

    public static void printAllMoods(ArrayList<Mood> moodsList) {
        if (moodsList.isEmpty()) {
            System.out.println("No moods have been recorded yet.");
            return;
        }
        for (Mood moodObj : moodsList) {
            System.out.println(moodObj);
        }
    }

    // ---------------- WRITE TO FILE ----------------
    // The original menu had a 'w' option but no code behind it at all — added here.

    private static void writeMoodsToFile(ArrayList<Mood> moodsList) {
        System.out.println("Enter the file name to save to (e.g. moods.txt):");
        String fileName = scanner.nextLine();
        try (java.io.PrintWriter writer = new java.io.PrintWriter(new java.io.FileWriter(fileName))) {
            for (Mood mood : moodsList) {
                writer.println(mood);
            }
            System.out.println("Moods successfully written to " + fileName);
        } catch (java.io.IOException e) {
            System.out.println("Could not write to file: " + e.getMessage());
        }
    }
}
