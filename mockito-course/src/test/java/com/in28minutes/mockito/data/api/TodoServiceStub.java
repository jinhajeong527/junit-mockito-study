package com.in28minutes.mockito.data.api;

import java.util.Arrays;
import java.util.List;

public class TodoServiceStub implements TodoService {
    // Dynamic Condition
    // Service Definition
    // 간단한 테스트에 대해서는 좋을 수 있다. 그렇지만 동적인 테스트가 필요한 경우에 유지하기가 매우 힘들어진다.
    // Mock을 사용하는 이유가 된다.
    @Override
    public List<String> retrieveTodos(String user) {
        return Arrays.asList("Learn Spring MVC", "Learn Spring Data JPA", "Learn Spring Test", "Learn How to Use IntelliJ IDE", "Learn Junit", "Learn Java Script");
    }

    @Override
    public void deleteTodo(String todo) {

    }
}
