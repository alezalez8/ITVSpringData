package itvdn.todolist.services.interfaces;

import itvdn.todolist.domain.PlainObjects.TodoPojo;
import itvdn.todolist.domain.Todo;

import java.util.List;

public interface ITodoService {
    TodoPojo createTodo(Todo todo, Long userId);
    TodoPojo getTodo(Long id, Long userId);
    TodoPojo updateTodo(Todo todo, Long todoId);
    String deleteTodo(Long id, Long userId);
    List<TodoPojo> getAllTodos(Long userId);
}
