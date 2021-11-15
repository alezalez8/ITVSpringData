package itvdn.todolist.services;

import itvdn.todolist.domain.PlainObjects.TodoPojo;
import itvdn.todolist.domain.Todo;
import itvdn.todolist.domain.User;
import itvdn.todolist.services.interfaces.ITodoService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Service
public class TodoService implements ITodoService {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public TodoPojo createTodo(Todo todo, Long userId) {

       User todoUser = entityManager
               .createQuery("SELECT user FROM User user WHERE user.id =: id", User.class)
               .setParameter("id", userId)
               .getSingleResult();

        return null;
    }

    @Override
    public TodoPojo getTodo(Long id) {
        return null;
    }

    @Override
    public TodoPojo updateTodo(Todo updatedTodo, Long todoId) {
        return null;
    }

    @Override
    public TodoPojo deleteTodo(Long id) {
        return null;
    }

    @Override
    public List<TodoPojo> getAllTodos(Long userId) {
        return null;
    }
}
