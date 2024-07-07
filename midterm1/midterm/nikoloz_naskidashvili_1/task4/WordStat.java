package midterm.nikoloz_naskidashvili_1.task4;

import java.util.List;
import java.util.HashSet;
import java.util.HashMap;

public class WordStat {
    public static void main(String[] args) {
        List<String> fantasyFormatData = DreamGenerator.fantasy;

        // HashSet to store unique words
        HashSet<String> uniqueWords = new HashSet<>();

        // Add all words to HashSet
        for (String word : fantasyFormatData) {
            uniqueWords.add(word);
        }

        // Print unique words
        for (String word : uniqueWords) {
            System.out.println(word);
        }


        // HashMap to store word frequency
        HashMap<Integer, Integer> wordFrequency = new HashMap<>();

        for (String word : fantasyFormatData) {
            int wordLength = word.length();
            if (wordFrequency.containsKey(wordLength)) {
                wordFrequency.put(wordLength, wordFrequency.get(wordLength) + 1);
            } else {
                wordFrequency.put(wordLength, 1);
            }
        }

        // Print word frequency
        for (int length : wordFrequency.keySet()) {
            System.out.println("Length: " + length + " Frequency: " + wordFrequency.get(length));
        }
    }
}
