package com.in28minutes.mockito;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SpyTest {

    @Test
    public void test() {
        List arrayListMock = mock(ArrayList.class);
        // mocks return default value
        assertEquals(0, arrayListMock.size());
        // 이렇게 한다고 실제 ArrayList의 사이즈에 영향을 미치지 않는다.
        // Mock을 쓸 때는 ArrayList의 어떤 implementation에도 관심이 없다.
        arrayListMock.add("Test Dummy Data");
        // stub() 메서드 대신에 when()을 사용할 수 있다.
        when(arrayListMock.size()).thenReturn(5);
        assertEquals(5, arrayListMock.size());
    }
}
