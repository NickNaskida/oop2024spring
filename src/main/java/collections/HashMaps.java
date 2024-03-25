package collections;

import java.util.HashMap;

public class HashMaps {
    public static void main(String[] args) {
        HashMap<String, Integer> groceries = new HashMap<>();

        groceries.put("Apples", 3);
        groceries.put("Bananas", 6);
        groceries.put("Oranges", 4);

        System.out.println("Groceries: " + groceries);

        groceries.put("Apples", 5);

        System.out.println("Groceries: " + groceries);

        groceries.remove("Bananas");

        System.out.println("Groceries: " + groceries);

        System.out.println("Number of items: " + groceries.size());

        System.out.println("Contains Apples: " + groceries.containsKey("Apples"));

        System.out.println("Contains 6: " + groceries.containsValue(6));

        groceries.clear();

        System.out.println("Groceries: " + groceries);

        System.out.println("Is empty: " + groceries.isEmpty());

        // Iterating over the HashMap
        groceries.put("Apples", 3);
        groceries.put("Bananas", 6);
        groceries.put("Oranges", 4);

        for (String key : groceries.keySet()) {
            System.out.println("Key: " + key + ", Value: " + groceries.get(key));
        }

        for (Integer value : groceries.values()) {
            System.out.println("Value: " + value);
        }

        for (HashMap.Entry<String, Integer> entry : groceries.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}
