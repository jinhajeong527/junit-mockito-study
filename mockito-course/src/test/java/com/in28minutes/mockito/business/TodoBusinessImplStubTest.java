package com.in28minutes.mockito.business;

import com.in28minutes.mockito.data.api.TodoService;
import com.in28minutes.mockito.data.api.TodoServiceStub;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

public class TodoBusinessImplStubTest {
    // 해당 impl class는 TodoService에 의존적이지만 해당 TodoService는 아직 준비되지 않았다.
    // 따라서 TodoServiceStub을 만든다. => Dummy value 리턴해준다.
    @Test
    public void testRetrieveTodosRelatedToSpring_usingAStub() {
        TodoService todoServiceStub = new TodoServiceStub();
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);
        List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy User");
        assertEquals(3, filteredTodos.size());
        // toArray() method에 어떤 인자도 넣지 않으면 Object[]를 리턴한다.
        //String[] arr = filteredTodos.toArray(new String[0]);
        // 스트링 리스트를 스트링 배열로 바꾸기
        String[] finteredTodosArr = filteredTodos.stream().toArray(String[]::new);
        assertArrayEquals(new String[]{"Learn Spring MVC", "Learn Spring Data JPA", "Learn Spring Test"}, finteredTodosArr);
    }
}
