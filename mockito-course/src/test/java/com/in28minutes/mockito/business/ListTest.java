package com.in28minutes.mockito.business;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyInt;

public class ListTest {

    @Test
    public void testMockListSizeMethod() {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2);
        assertEquals(2, listMock.size());
        assertEquals(2, listMock.size());
        assertEquals(2, listMock.size());
    }

    @Test
    public void testMockListSizeMethod_ReturnMultipleValues() {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2).thenReturn(3);
        assertEquals(2, listMock.size());
        assertEquals(3, listMock.size());
    }

    @Test
    public void testMockListGet() {
        List listMock = mock(List.class);
        // Argument Matcher
        //when(listMock.get(0)).thenReturn("in28Minutes");
        when(listMock.get(anyInt())).thenReturn("in28Minutes");
        assertEquals("in28Minutes", listMock.get(0));
        // Mockito mocks are nice! => 1번 인덱스에 어떤 값 리턴할지 정해주지 않았기 때문에
        // 디폴트 값을 리턴해준다.
        //assertEquals(null, listMock.get(1));
        assertEquals("in28Minutes", listMock.get(1));
    }

    @Test
    public void testMockListGet_throwAnException() {
        List listMock = mock(List.class);
        // Argument Matcher
        when(listMock.get(anyInt())).thenThrow(new RuntimeException("Something"));
        // 방법 1
        assertThrows(RuntimeException.class, () -> {
            listMock.get(0);
        });
        // 방법 2
        try {
            listMock.get(0);
        } catch (RuntimeException e) {
            assertEquals("Something", e.getMessage());
        }
        // 방법 3
        Throwable exception = assertThrows(RuntimeException.class, () -> {
            listMock.get(0);
        });
        assertEquals("Something", exception.getMessage());
    }
//    @Test
//    public void testMockList_mixingUp() {
//        List listMock = mock(List.class);
//        when(listMock.subList(anyInt(), 5)).thenThrow(new RuntimeException());
//        listMock.get(0);
//    } THIS iS NOT GONNA WORK...!

    @Test
    public void testMockListGet_usingBBD() {
        // Given
        List<String> listMock = mock(List.class);
        given(listMock.get(anyInt())).willReturn("in28Minutes");

        // When
        String firstElement = listMock.get(0);

        // Then  : hamcrest
        assertThat(firstElement, is("in28Minutes"));
    }
}
