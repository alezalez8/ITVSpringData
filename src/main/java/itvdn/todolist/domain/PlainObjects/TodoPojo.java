package itvdn.todolist.domain.PlainObjects;

import itvdn.todolist.domain.Priority;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

//@Component
@Getter
@Setter
public class TodoPojo {

    private long id;
    private String name;
    private String comment;
    private Date startDate;
    private Date endDate;
    private Boolean important;
    private Priority priority;
    private TagPojo user;
    private Set<TagPojo> tagList = new HashSet<>();
    private Long userId;
}
