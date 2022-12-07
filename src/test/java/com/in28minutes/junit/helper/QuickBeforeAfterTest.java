package com.in28minutes.junit.helper;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class QuickBeforeAfterTest {
    // Test 전에 해야할 셋업이 있을 경우에 작성하여 사용할 수 있다.
    // 예를들어 테스트를 실행할 때 마다 새로운 인스탠스가 생성되어야 한다든지.
    @BeforeEach
    public void setup() {
        System.out.println("Before Test");
    }

    @Test
    public void test1() {
        System.out.println("test1 executed");
    }

    @Test
    public void test2() {
        System.out.println("test2 executed");
    }

    @AfterEach
    public void teardown() {
        // when I want to close connection to something
        // Test 후에 정리 코드가 필요할 때
        System.out.println("After Test");
    }
}
