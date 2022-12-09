package com.in28minutes.junit.helper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringHelperTest {

    StringHelper helper;

    @BeforeEach()
    public void before() {
        helper = new StringHelper();
    }

    @Test
    public void testTruncateAInFirst2Positions_AInFirst2Positions() {
        // 인자 순서 : expected, actual
        // 대개 하나의 유닛테스트에 여러개의 컨디션을 두지 않는다.
        assertEquals("CD", helper.truncateAInFirst2Positions("AACD"));
    }

    @Test
    public void testTruncateAInFirst2Positions_AInFirst1Position() { // public이고, void여야 한다.
        assertEquals("CD", helper.truncateAInFirst2Positions("ACD"));
    }

    @Test
    public void testTruncateAInFirst2Positions_NoAInFirst2Positions() { // public이고, void여야 한다.
        assertEquals("CDEF", helper.truncateAInFirst2Positions("CDEF"));
        assertEquals("CDAA", helper.truncateAInFirst2Positions("CDAA"));
    }

    // ABCD => false, ABAB => true, AB => true, A => false
    @Test
    public void testAreFirstAndLastTwoCharactersTheSame_BasicNegativeScenario() {
        assertFalse(helper.areFirstAndLastTwoCharactersTheSame("ABCD"));
        // assertFalse(true, "The condition failed"); 아직 사용하는 프로젝트 있을 수 있으니 알고 있으면 좋을 수 있다.
    }

    @Test
    public void testAreFirstAndLastTwoCharactersTheSame_BasicPositiveScenario() {
        assertTrue(helper.areFirstAndLastTwoCharactersTheSame("ABAB"));
    }

}
