package com.in28minutes.mockito;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class SpyTest {

    @Test
    public void test() {
        // Creating a real arrayList
        // 실제로 stubbing 할 수 있다.
        List arrayListSpy = spy(ArrayList.class);
        when(arrayListSpy.size()).thenReturn(5);
        // size() method만 오버라이드 하게 된다.
        assertEquals(5, arrayListSpy.size());
        arrayListSpy.add("Dummy"); // Has this really happen? yes
        verify(arrayListSpy).add("Dummy"); // clear() call never get called right? no
        verify(arrayListSpy, never()).clear();
        // 스파이는 바뀌길 원하는 부분을 제외하고는 실제 액션은 그대로 발생하게 두고,
        // 그것을 트랙킹 할 수 있게 해준다.
        // 잘 구성되었다면 스파이를 꼭 쓸 필요 없고 목을 쓰는 것이 더 좋다
        // 레거시 프로젝트라면 spy가 필요할 수가 있다.
    }
}
