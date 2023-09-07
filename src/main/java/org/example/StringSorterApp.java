package org.example;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class StringSorterApp {
    public static void main(String[] args) {
        List<String> unsortedStrings = List.of("apple", "banana", "grape", "avocado", "cherry");
        List<String> sortedStrings = sortStrings(unsortedStrings, "a");

        System.out.println("Unsorted: " + unsortedStrings);
        System.out.println("Sorted: " + sortedStrings);
    }

    public static List<String> sortStrings(List<String> unsortedStrings, String exceptionChar) {
        if (unsortedStrings == null) {
            throw new IllegalArgumentException("unsortedStrings cannot be null");
        }

        List<String> result = new LinkedList<>();
        unsortedStrings.stream().sorted(Comparator.reverseOrder()).forEach(it -> {
            if (it == null || it.startsWith(exceptionChar)) {
                result.add(it);
            } else {
                result.add(0, it);
            }
        });
        return result;
    }
}
