package assigment1;

import java.util.Scanner;

public class assignment02 {
    public static void main(String[] args) {
        // Input
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first operand: ");
        double operand1 = scanner.nextDouble();

        System.out.print("Enter the second operand: ");
        double operand2 = scanner.nextDouble();

        scanner.close(); // Closing the scanner

        // Operations
        double addition = operand1 + operand2;
        double subtraction = operand1 - operand2;
        double multiplication = operand1 * operand2;
        double division = operand1 / operand2;

        // Output
        System.out.println("Result of addition: " + addition);
        System.out.println("Result of subtraction: " + subtraction);
        System.out.println("Result of multiplication: " + multiplication);
        System.out.println("Result of division: " + division);
    }
}
