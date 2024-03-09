import java.util.Scanner;

public class assignment03 {
    public static void main(String[] args) {
        // Input
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the radius of the circle (in cm): ");
        double radius = scanner.nextDouble();

        scanner.close(); // Closing the scanner

        // Calculation
        double area = Math.PI * radius * radius;

        // Output
        System.out.println("Area of the circle: " + area + " cm^2");
    }
}
