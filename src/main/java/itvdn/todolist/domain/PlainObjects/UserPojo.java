package itvdn.todolist.domain.PlainObjects;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

//@Component
@Getter
@Setter
public class UserPojo {

    private Long id;
    private String email;
    private String password;
    private Set<TodoPojo> todoList = new HashSet<>();
}
