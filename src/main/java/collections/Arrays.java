package collections;

import java.util.ArrayList;

public class Arrays {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        ArrayList<String> strNumbers = new ArrayList<String>();

        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        System.out.println("Numbers: " + numbers);

        numbers.remove(1);
        numbers.set(1, 99);

        System.out.println("Numbers: " + numbers);

        for (int number : numbers) {
            String strNumber = Integer.toString(number);
            strNumbers.add(strNumber);
        }

        System.out.println("String Numbers: " + strNumbers);

        System.out.println("Size of numbers: " + numbers.size());
        System.out.println("Size of strNumbers: " + strNumbers.size());

        numbers.clear();
        strNumbers.clear();

        System.out.println("Numbers: " + numbers);
        System.out.println("String Numbers: " + strNumbers);

        System.out.println("Size of numbers: " + numbers.size());
        System.out.println("Size of strNumbers: " + strNumbers.size());

        System.out.println();
        System.out.println();

        int k = 0;
        int maxIterations = 1000;

        while (k < maxIterations) {
            for (int i = 1; i < 10; i++) {
                System.out.println("*".repeat(i).repeat(k / 100));
            }
            for (int i = 10; i > 1; i--) {

                System.out.println("*".repeat(i).repeat(k / 100));
            }

            k++;
        }

    }
}
