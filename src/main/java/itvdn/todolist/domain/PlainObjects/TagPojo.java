package itvdn.todolist.domain.PlainObjects;

import itvdn.todolist.domain.Todo;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;


//@Component
@Getter
@Setter
public class TagPojo {

    private Long id;
    private String name;
    private Set<Long> todoListIds = new HashSet<>();
}
