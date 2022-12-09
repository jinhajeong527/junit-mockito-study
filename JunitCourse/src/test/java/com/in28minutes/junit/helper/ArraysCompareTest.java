package com.in28minutes.junit.helper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

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

    @Test // Performance Test. Very Strict Performance Requirement가 있을 때 사용할 수
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    public void testSort_Performance() {
        int array[] = {12, 23, 4};
        for(int i = 1; i <= 1000000; i++) {
            array[0] = i;
            Arrays.sort(array);
        }
    }

}
