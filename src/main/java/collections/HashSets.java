package collections;

import java.util.HashSet;
import java.util.Set;

public class HashSets {
    public static void main(String[] args) {
        // Creating a HashSet
        Set<String> names = new HashSet<>();

        // Adding elements to the HashSet
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        names.add("David");
        names.add("Alice"); // Adding a duplicate element

        // Displaying the HashSet
        System.out.println("HashSet: " + names);

        // Removing an element from the HashSet
        names.remove("Charlie");

        // Displaying the HashSet after removing an element
        System.out.println("HashSet after removing an element: " + names);

        // Checking if an element is present in the HashSet
        System.out.println("Is 'Alice' present in the HashSet? " + names.contains("Alice"));

        // Checking if the HashSet is empty
        System.out.println("Is the HashSet empty? " + names.isEmpty());

        // Finding the size of the HashSet
        System.out.println("Size of the HashSet: " + names.size());

        // Clearing the HashSet
        names.clear();

        // Displaying the HashSet after clearing
        System.out.println("HashSet after clearing: " + names);

        for (int i = 0; i < 10; i++) {
            names.add("Name" + i);
        }

        System.out.println("HashSet (Always unordered): " + names);
    }
}
