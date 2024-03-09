public class assignment05 {
    public static void main(String[] args) {
        int levels = 4; // Number of levels in the triangle

        // Printing triangle pattern
        for (int i = 1; i <= levels; i++) {
            printStars(i); // Calling a separate method to print stars
            System.out.println(); // Moving to the next line after each level
        }
    }

    // Method to print stars for each level
    private static void printStars(int numStars) {
        for (int j = 1; j <= numStars; j++) {
            System.out.print("*");
        }
    }
}
