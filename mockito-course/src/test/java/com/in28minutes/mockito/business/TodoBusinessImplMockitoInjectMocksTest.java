package com.in28minutes.mockito.business;

import com.in28minutes.mockito.data.api.TodoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@ExtendWith({MockitoExtension.class, SpringExtension.class}) // @Mock 어노테이션 사용하기 위해 필요하다.
public class TodoBusinessImplMockitoInjectMocksTest {
    @Mock
    TodoService todoServiceMock;
    @InjectMocks
    TodoBusinessImpl todoBusinessImpl; // 여기 안에 디펜던시 확인해서 혹시 TodoService가 디펜던시로 존재하는지 확인한다.
    //  @Mock과 매치하는지 확인해서 의존성 주입해준다.
    //  What's hidden? TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
    @Captor
    ArgumentCaptor<String> stringArgumentCaptor;

    @Test
    public void testRetrieveTodosRelatedToSpring_usingAMock() {

        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring Data JPA", "Learn Spring Test",
                "Learn How to Use IntelliJ IDE", "Learn Junit", "Learn Java Script");
        // when() : 특정 메서드가, 해당 인자를 통해서 호출되면
        // thenReturn() : TodoServiceMock이 DummyUser value와 함께 호출되면 리턴할 value를 지정해줄 수 있다.
        // 현재는 하드코딩 방식으로 동적으로 목을 사용한 테스트 코드도 작성할 것이다.
        when(todoServiceMock.retrieveTodos("DummyUser")).thenReturn(todos);

        List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("DummyUser");

        assertEquals(3, filteredTodos.size());

        // 스트링 리스트를 스트링 배열로 바꾸기
        String[] finteredTodosArr = filteredTodos.stream().toArray(String[]::new);
        assertArrayEquals(new String[]{"Learn Spring MVC", "Learn Spring Data JPA", "Learn Spring Test"}, finteredTodosArr);
    }

    @Test
    public void testRetrieveTodosRelatedToSpring_withEmptyList() {

        List<String> todos = Arrays.asList();
        // TodoServiceMock이 DummyUser value와 함께 호출되면
        when(todoServiceMock.retrieveTodos("DummyUser")).thenReturn(todos);

        List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("DummyUser");

        assertEquals(0, filteredTodos.size());

        // 스트링 리스트를 스트링 배열로 바꾸기
        String[] finteredTodosArr = filteredTodos.stream().toArray(String[]::new);
        assertArrayEquals(new String[]{}, finteredTodosArr);
    }

    @Test
    public void testRetrieveTodosRelatedToSpring_usingBDD() {
        // Given : Set Up
        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring Data JPA", "Learn Spring Test",
                "Learn How to Use IntelliJ IDE", "Learn Junit", "Learn Java Script");
        // given(), willReturn()
        given(todoServiceMock.retrieveTodos("DummyUser")).willReturn(todos);

        // When
        List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("DummyUser");

        // Then
        assertEquals(3, filteredTodos.size());
    }

    @Test
    public void testDeleteTodosNotRelatedToSpring_usingBDD() {
        // Given : Set Up
        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring Data JPA", "Learn Spring Test",
                "Learn How to Use IntelliJ IDE", "Learn Junit", "Learn Java Script");
        // given(), willReturn()
        given(todoServiceMock.retrieveTodos("DummyUser")).willReturn(todos);

        // When
        todoBusinessImpl.deleteTodosNotRelatedToSpring("DummyUser");

        // Then
        verify(todoServiceMock, atMost(1)).deleteTodo("Learn How to Use IntelliJ IDE");
        // More Readable
        then(todoServiceMock).should().deleteTodo("Learn How to Use IntelliJ IDE");
        verify(todoServiceMock, times(1)).deleteTodo("Learn Junit"); // 한번만 호출되어야 한다.
        verify(todoServiceMock, atLeast(1)).deleteTodo("Learn Java Script");

        verify(todoServiceMock, never()).deleteTodo("Learn Spring MVC");
        // More Readable
        then(todoServiceMock).should(never()).deleteTodo("Learn Spring MVC");
    }
    @Test
    public void testDeleteTodosNotRelatedToSpring_usingBDD_argumentCapture() {
        // Given : Set Up
        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring Data JPA", "Learn Spring Test",
                "Learn How to Use IntelliJ IDE", "Learn Junit", "Learn Java Script");
        // given(), willReturn()
        given(todoServiceMock.retrieveTodos("DummyUser")).willReturn(todos);

        // When
        todoBusinessImpl.deleteTodosNotRelatedToSpring("DummyUser");

        // Then
        then(todoServiceMock).should(times(3)).deleteTodo(stringArgumentCaptor.capture());
        assertThat(stringArgumentCaptor.getAllValues().size(), is(3));
    }

}
