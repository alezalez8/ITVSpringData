package itvdn.todolist.services;

import itvdn.todolist.domain.PlainObjects.TodoPojo;
import itvdn.todolist.domain.Tag;
import itvdn.todolist.domain.Todo;
import itvdn.todolist.domain.User;
import itvdn.todolist.repositories.TodoRepository;
import itvdn.todolist.repositories.UserRepository;
import itvdn.todolist.services.interfaces.ITagService;
import itvdn.todolist.services.interfaces.ITodoService;
import itvdn.todolist.utils.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class TodoService implements ITodoService {


    private final Converter converter;
    private final ITagService tagService;
    private final TodoRepository todoRepository;
    private final UserRepository userRepository;

    @Autowired
    public TodoService(Converter converter, ITagService tagService, TodoRepository todoRepository, UserRepository userRepository) {
        this.converter = converter;
        this.tagService = tagService;
        this.todoRepository = todoRepository;
        this.userRepository = userRepository;

    }

    @Override
    @Transactional
    public TodoPojo createTodo(Todo todo, Long userId) {

        Optional<User> todoUserOptional = userRepository.findById(userId);

        if (todoUserOptional.isPresent()) {

            Set<Tag> tags = new HashSet<>();
            tags.addAll(todo.getTagList());

            todo.getTagList().clear();

            todo.setUser(todoUserOptional.get());
            todoRepository.save(todo);

            tags.stream().map(tag -> tagService.findOrCreate(tag)).collect(Collectors.toSet()).forEach(todo::addTag);

            return converter.todoToPojo(todo);
        } else {
            return converter.todoToPojo(new Todo());

        }


    }

    @Override
    public TodoPojo getTodo(Long id) {
        Optional<Todo> getTodoById = todoRepository.findById(id);
        if (getTodoById.isPresent()) {
            return converter.todoToPojo(getTodoById.get());
        } else {
            return converter.todoToPojo(new Todo());
        }

    }

    @Override
    public List<TodoPojo> getAllTodos(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            return todoRepository.findAllByUser(userOptional.get()).stream()
                    .map(todo -> converter.todoToPojo(todo))
                    .collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }

    }

    @Override
    public String deleteTodo(long id) {
        Optional<Todo> deleteTodoOptional = todoRepository.findById(id);
        if (deleteTodoOptional.isPresent()) {
            todoRepository.delete(deleteTodoOptional.get());
            return "Todo with id = " + id + "successfully deleted";
        } else {
            return "Todo is not present";
        }
    }

    @Override
    public TodoPojo updateTodo(Todo source, long todoId) {
        Optional<Todo> targetOptional = todoRepository.findById(todoId);
        if (targetOptional.isPresent()) {
            Todo target = targetOptional.get();

            target.setName(source.getName());
            target.setComment(source.getComment());
            target.setStartDate(source.getStartDate());
            target.setEndDate(source.getEndDate());
            target.setImportant(source.getImportant());
            target.setPriority(source.getPriority());
            todoRepository.save(target);
            return converter.todoToPojo(target);
/*
            target.setUserId(source.getUser().getId());
            target.setTagList(source.getTagList().stream().map(tag -> tagToPojo(tag)).collect(Collectors.toSet()));
*/
        } else {
            return converter.todoToPojo(new Todo());

        }


    }
}
