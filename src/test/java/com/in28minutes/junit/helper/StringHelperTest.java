package com.in28minutes.junit.helper;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringHelperTest {

    StringHelper helper = new StringHelper();

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

}
