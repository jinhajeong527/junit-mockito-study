package com.in28minutes.junit.helper;

import org.junit.jupiter.api.*;
import org.springframework.test.context.event.annotation.BeforeTestClass;

public class QuickBeforeAfterTest {
    @BeforeAll
    public static void beforeAll() {
        // 반드시 static으로 선언해야 하고, 모든 static method 관련 constraints 다 적용된다.
        // 인스탠스 변수를 레퍼런스 할 수 없고 클래스 레벨만 여기에 초기화 될 수 있다.
        System.out.println("Before Test Class");
    }
    // Test 전에 해야할 셋업이 있을 경우에 작성하여 사용할 수 있다.
    // 예를들어 테스트를 실행할 때 마다 새로운 인스탠스가 생성되어야 한다든지.
    // 퍼포먼스가 많이 걱정되는 것이 아니라면 @BeforeEach 사용을 추천한다고 하심
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

    @AfterAll
    public static void afterAll() {
        System.out.println("After Test Class");
    }
}
