package workshop1;

import java.util.Scanner;

public class TemperatureClassifier {
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter temperature in Celsius: ");
            String input = scanner.nextLine();

            if (input.equals("exit")) {
                break;
            }

            double temperature;
            try {
                temperature = Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
                continue;
            }

            String classification;
            if (temperature < 0) {
                classification = "Freezing";
            } else if (temperature >= 0 && temperature <= 15) {
                classification = "Cold";
            } else if (temperature >= 16 && temperature <= 25) {
                classification = "Mild";
            } else if (temperature >= 26 && temperature <= 35) {
                classification = "Warm";
            } else {
                classification = "Hot";
            }

            System.out.println("Classification: " + classification);
        }
    }
}

