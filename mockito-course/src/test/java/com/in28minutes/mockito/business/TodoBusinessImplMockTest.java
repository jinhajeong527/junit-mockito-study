package com.in28minutes.mockito.business;

import com.in28minutes.mockito.data.api.TodoService;
import com.in28minutes.mockito.data.api.TodoServiceStub;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TodoBusinessImplMockTest {
    // What is mocking ? => mocking is creating objects that simulate the behavior of real objects.
    // Unlike stubs, mocks can be dynamically created from code - at runtime.
    // Mocks offer more functionality than stubbing
    // You can verify method calls and a lot of other things.
    @Test
    public void testRetrieveTodosRelatedToSpring_usingAMock() {
        // mock() method를 사용한다.
       TodoService todoServiceMock = mock(TodoService.class);

       List<String> todos =  Arrays.asList("Learn Spring MVC", "Learn Spring Data JPA", "Learn Spring Test",
                "Learn How to Use IntelliJ IDE", "Learn Junit", "Learn Java Script");
        // thenReturn() : TodoServiceMock이 DummyUser value와 함께 호출되면 리턴할 value를 지정해줄 수 있다.
        when(todoServiceMock.retrieveTodos("DummyUser")).thenReturn(todos);

        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
        List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("DummyUser");

        assertEquals(3, filteredTodos.size());

        // 스트링 리스트를 스트링 배열로 바꾸기
        String[] finteredTodosArr = filteredTodos.stream().toArray(String[]::new);
        assertArrayEquals(new String[]{"Learn Spring MVC", "Learn Spring Data JPA", "Learn Spring Test"}, finteredTodosArr);
    }

    @Test
    public void testRetrieveTodosRelatedToSpring_withEmptyList() {

        TodoService todoServiceMock = mock(TodoService.class);

        List<String> todos =  Arrays.asList();
        // TodoServiceMock이 DummyUser value와 함께 호출되면
        when(todoServiceMock.retrieveTodos("DummyUser")).thenReturn(todos);

        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
        List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("DummyUser");

        assertEquals(0, filteredTodos.size());

        // 스트링 리스트를 스트링 배열로 바꾸기
        String[] finteredTodosArr = filteredTodos.stream().toArray(String[]::new);
        assertArrayEquals(new String[]{}, finteredTodosArr);
    }
}
