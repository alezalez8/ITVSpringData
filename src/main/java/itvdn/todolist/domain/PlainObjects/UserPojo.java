package itvdn.todolist.domain.PlainObjects;

import itvdn.todolist.domain.Todo;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Component
public class UserPojo {

    private Long id;
    private String email;
    private String password;
    private Set<TodoPojo> todoList = new HashSet<>();
}
