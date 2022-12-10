package com.in28minutes.mockito.business;

import java.util.ArrayList;
import java.util.List;

import com.in28minutes.mockito.data.api.TodoService;
// 특정 토픽에(Spring) 관련된 투두리스트만 필터링한다.
// 해당 서비스 임플은 SUT(Service Under Test) 이다.
// TodeService Dependency
public class TodoBusinessImpl {
	private TodoService todoService;

	TodoBusinessImpl(TodoService todoService) {
		this.todoService = todoService;
	}

	public List<String> retrieveTodosRelatedToSpring(String user) {
		List<String> filteredTodos = new ArrayList<String>();
		List<String> allTodos = todoService.retrieveTodos(user);
		for (String todo : allTodos) {
			if (todo.contains("Spring")) {
				filteredTodos.add(todo);
			}
		}
		return filteredTodos;
	}
	public List<String> deleteTodosNotRelatedToSpring(String user) {
		List<String> filteredTodos = new ArrayList<String>();
		List<String> allTodos = todoService.retrieveTodos(user);
		for (String todo : allTodos) {
			if (!todo.contains("Spring")) {
				todoService.deleteTodo(todo);
			}
		}
		return filteredTodos;
	}
}