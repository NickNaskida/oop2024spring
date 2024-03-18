package workshop1;

import java.time.DayOfWeek;
import java.util.Scanner;

public class MyDayOfWeek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a numeric day of the week (1-7): ");
        int day = scanner.nextInt();


        String dayName;
        try {
            DayOfWeek dayOfWeek = DayOfWeek.of(day);
            dayName = dayOfWeek.toString();
        } catch (Exception e) {
            dayName = "Invalid input";
        }

        System.out.println("Day of the week: " + dayName);
    }
}
