package com.in28minutes.junit.helper;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class ArraysCompareTest {
    // Arrays.sort

    @Test
    public void testArraySort_RandomArray() {
        int[] numbers = {12, 3, 4, 1};
        int[] expected = {1, 3, 4, 12};
        Arrays.sort(numbers);
        assertArrayEquals(numbers, expected);
    }

    @Test
    // @Test(expected = NullPointerException.class) syntax. => Junit4
    public void testArraySort_NullArray() {
        // int[] numbers = {};
        int[] numbers = null;
        assertThrows(NullPointerException.class, () -> {
            Arrays.sort(numbers);
        });
    }

}