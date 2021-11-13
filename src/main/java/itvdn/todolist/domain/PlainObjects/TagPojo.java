package itvdn.todolist.domain.PlainObjects;

import itvdn.todolist.domain.Todo;
import java.util.HashSet;
import java.util.Set;

public class TagPojo {

    private Long id;
    private String name;
    private Set<TodoPojo> todoList = new HashSet<>();
}
