import java.util.Scanner;

public class Task_1 {
    public static class DayType {

        String day;
        private static final String[] DaysOfWeek = { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };

        public DayType() {
            this.day = DaysOfWeek[0];
        }

        public DayType(String day) {
            setDay(day);
        }

        public String getDay() {
            return this.day;
        }

        public void setDay(String day) {
            for (String D : DaysOfWeek) {
                if (D.equalsIgnoreCase(day)) {
                    this.day = D;
                    return;
                }
            }
            System.out.println("Invalid day entered: " + day + ". Defaulting to Sunday.");
            this.day = DaysOfWeek[0];
        }

        public void printDay() {
            System.out.println("Current Day: " + getDay());
        }

        public int indexDay() {
            for (int i = 0; i < DaysOfWeek.length; i++)
                if (DaysOfWeek[i].equals(this.day)) {
                    return i;
                }
            return -1;
        }

        public void nextDay() {
            int current = indexDay();
            if (current == -1)
                return;
            int nextIndex = (current + 1) % DaysOfWeek.length;
            this.day = DaysOfWeek[nextIndex];
        }

        public void previousDay() {
            int current = indexDay();
            if (current == -1)
                return;
            int previousIndex = (current - 1 + DaysOfWeek.length) % DaysOfWeek.length;
            this.day = DaysOfWeek[previousIndex];
        }

        public void newDay(int adding) {
            int current = indexDay();
            if (current == -1)
                return;
            int newIndex = (current + adding) % DaysOfWeek.length;

            if (newIndex < 0)
                newIndex += DaysOfWeek.length;

            this.day = DaysOfWeek[newIndex];
        }
    }

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final DayType Day = new DayType();

        // Ask user for initial day
        System.out.print("Enter the current day (Sun, Mon, Tue, ...): ");
        String inputDay = sc.nextLine();
        Day.setDay(inputDay);

        int choice;
        do {
            System.out.println("\n--- Welcome to the CALENDAR ---");
            System.out.println("1. Show Current Day");
            System.out.println("2. Set Day");
            System.out.println("3. Next Day");
            System.out.println("4. Previous Day");
            System.out.println("5. Move N Days");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    Day.printDay();
                    break;

                case 2:
                    System.out.print("Enter the day to set (Sun, Mon, Tue, ...): ");
                    String newDay = sc.nextLine();
                    Day.setDay(newDay);
                    Day.printDay();
                    break;

                case 3:
                    Day.nextDay();
                    System.out.println("Moved to next day.");
                    Day.printDay();
                    break;

                case 4:
                    Day.previousDay();
                    System.out.println("Moved to previous day.");
                    Day.printDay();
                    break;

                case 5:
                    System.out.print("Enter number of days to move (can be negative): ");
                    int n = sc.nextInt();
                    Day.newDay(n);
                    Day.printDay();
                    break;

                case 6:
                    System.out.println("Exiting program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 6);

    }
}
