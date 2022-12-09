package com.in28minutes.junit.helper;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@SelectClasses({ArraysCompareTest.class, QuickBeforeAfterTest.class})
@Suite
public class AllTests {
    // memory intensive, performance intensive test가 있다면 그런 테스트들 묶어서 exclude 할 수도 있을 것이다.
}
