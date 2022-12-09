package com.in28minutes.junit.helper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

// @RunWith(Parameterized.class) Junit4
public class StringHelperParameterizedTest {

    StringHelper helper = new StringHelper();
    // input, output은 조금 다르지만 동일한 테스트 셋업은 비슷할 때 아래와 같이 파라미터라이즈드 테스트 코드를 작성할 수 있다.
    public static Stream<Arguments> testConditions() {
        return Stream.of(
                Arguments.of("AACD", "CD"),
                Arguments.of("ACD", "CD")
        );
    }
    @DisplayName("Test with @MethodSource")
    @ParameterizedTest(name = "{index} : ({0} , {1})")
    @MethodSource("testConditions")
    public void testTruncateAInFirst2Positions_AInFirst2Positions(String inputValue, String outputExpected) {
        assertEquals(outputExpected, helper.truncateAInFirst2Positions(inputValue));
    }
}
