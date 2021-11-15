package itvdn.todolist.services.interfaces;

import itvdn.todolist.domain.PlainObjects.TodoPojo;
import itvdn.todolist.domain.Todo;

import java.util.List;

public interface ITodoService {
    TodoPojo createTodo(Todo todo, Long userId);
    TodoPojo getTodo(Long id);
    TodoPojo updateTodo(Todo updatedTodo, Long todoId);
    TodoPojo deleteTodo(Long id);
    List<TodoPojo> getAllTodos(Long userId);
}
