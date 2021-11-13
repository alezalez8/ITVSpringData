package itvdn.todolist.domain.PlainObjects;

import itvdn.todolist.domain.Priority;
import itvdn.todolist.domain.User;

import java.util.Date;
import java.util.HashSet;

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
}
