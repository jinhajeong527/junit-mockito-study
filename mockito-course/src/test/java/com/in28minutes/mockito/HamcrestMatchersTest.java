package com.in28minutes.mockito;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestMatchersTest {

    @Test
    public void test() {
        List<Integer> scores = Arrays.asList(99, 100, 101, 105);
        // scores has 4 items
        assertThat(scores, hasSize(4));
        assertThat(scores, hasItems(99, 100));

        // every item : > 90
        assertThat(scores, everyItem(greaterThan(90)));
        assertThat(scores, everyItem(lessThan(190)));

        // String
        //assertThat("", isEmptyString());
        assertThat("", emptyString());
        assertThat(null, emptyOrNullString());

        // Arrays
        Integer[] marks = { 1, 2, 3 };

        assertThat(marks, arrayWithSize(3));
        assertThat(marks, arrayContaining(1,2,3));
        // 순서 상관없이 포함하는지 체크하고 싶을 때
        assertThat(marks, arrayContainingInAnyOrder(2,3,1));

    }
}
