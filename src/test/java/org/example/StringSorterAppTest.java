package org.example;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StringSorterAppTest {

    @Test
    void testSortStrings() {
        List<String> unsortedStrings = List.of("apple", "banana", "berry", "grape", "avocado", "cherry");

        List<String> sortedStringsA = StringSorterApp.sortStrings(unsortedStrings, "a");
        List<String> expectedSortedStringsA = List.of("banana", "berry", "cherry", "grape", "avocado", "apple");
        assertArrayEquals(expectedSortedStringsA.toArray(), sortedStringsA.toArray());

        List<String> sortedStringsB = StringSorterApp.sortStrings(unsortedStrings, "b");
        List<String> expectedSortedStringsB = List.of("apple", "avocado", "cherry", "grape", "berry", "banana");
        assertArrayEquals(expectedSortedStringsB.toArray(), sortedStringsB.toArray());
    }

    @Test
    void testSortStringsWithEmptyList() {
        List<String> unsortedStrings = List.of();
        List<String> sortedStrings = StringSorterApp.sortStrings(unsortedStrings, "a");
        assertEquals(0, sortedStrings.size());
    }

    @Test
    void testSortStringsWithNullInput() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            StringSorterApp.sortStrings(null, "a");
        });

        String expectedMessage = "unsortedStrings cannot be null";

        assertEquals(expectedMessage, ex.getMessage());
    }

    @Test
    void testSortStringsWithExceptionCharNotFound() {
        List<String> unsortedStrings = List.of("banana", "berry", "grape", "cherry");
        List<String> sortedStrings = StringSorterApp.sortStrings(unsortedStrings, "a");
        List<String> expectedSortedStrings = List.of("banana", "berry", "cherry", "grape");
        assertArrayEquals(expectedSortedStrings.toArray(), sortedStrings.toArray());
    }
}
