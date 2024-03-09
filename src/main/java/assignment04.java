import java.util.Scanner;

public class assignment04 {
    public static void main(String[] args) {
        //getting input
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the amount of mins: ");
        double mins = scanner.nextDouble();

        scanner.close(); //closing the reader

        double secs = mins * 60;


        System.out.println("Equivalent number of seconds: " + secs);
    }
}