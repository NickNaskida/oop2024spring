package workshop1;

import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;

        do {
            System.out.print("Enter command (add/subtract/multiply/divide) or 'exit' to quit: ");
            command = scanner.next().toLowerCase();

            if (command.equals("exit")) {
                break;
            }

            System.out.print("Enter first number: ");
            double num1 = scanner.nextDouble();
            System.out.print("Enter second number: ");
            double num2 = scanner.nextDouble();

            double result;
            switch (command) {
                case "add":
                    result = num1 + num2;
                    break;
                case "subtract":
                    result = num1 - num2;
                    break;
                case "multiply":
                    result = num1 * num2;
                    break;
                case "divide":
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        System.out.println("Error: Cannot divide by zero!");
                        continue;
                    }
                    break;
                default:
                    System.out.println("Invalid command!");
                    continue;
            }

            System.out.println("Result: " + result);
        } while (!command.equals("exit"));
    }
}
