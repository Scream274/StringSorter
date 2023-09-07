package org.example;

import java.util.List;
import java.util.stream.Stream;

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

        Stream<String> descSortedStrings = unsortedStrings.stream()
                .filter(s -> s.startsWith(exceptionChar))
                .sorted((s1, s2) -> s2.compareToIgnoreCase(s1));

        Stream<String> ascSortedStrings = unsortedStrings.stream()
                .filter(s -> !s.startsWith(exceptionChar))
                .sorted();

        return Stream.concat(ascSortedStrings, descSortedStrings).toList();
    }
}
