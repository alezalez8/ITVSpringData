package itvdn.todolist.domain;


import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TODO")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "COMMENT")
    private String comment;

    @Column(name = "START_DATE")
    private Date startDate;

    @Column(name = "END_DATE")
    private Date endDate;

    @Column(name = "IMPORTANT")
    private Boolean important;

    @Column(name = "PRIORITY")
    @Enumerated(EnumType.STRING)
    private Priority priority;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    public User getUser() {
        return user;
    }

    // ------------------------------------------------------------------------
    public void setUser(User user) {
        setUser(user, false);
    }

    public void setUser(User user, boolean otherSideHasBeenSet) {
        this.user = user;
        if (otherSideHasBeenSet) {
            return;
        }
        user.addTodo(this, true); // перекрестная проверка
    }
//--------------------------------------------------------------------------
// ------------------------------------------------------------------------
public void removeUser(User user) {
    removeUser(user, false);
}

    public void removeUser(User user, boolean otherSideHasBeenSet) {
        this.user = null;
        if (otherSideHasBeenSet) {
            return;
        }
        user.removeTodo(this, true); // перекрестная проверка
    }
//--------------------------------------------------------------------------

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "TODO_TAG", joinColumns = @JoinColumn(name = "TODO_ID"), inverseJoinColumns = @JoinColumn(name = "TAG_ID"))
    private Set<Tag> tagList = new HashSet<>();

    public Set<Tag> getTagList() {
        return tagList;
    }

    //-------------------- add new_tag ---------------------------------
    public void addTag(Tag tag) {
        addTag(tag, false);
    }

    public void addTag(Tag tag, boolean otherSideHasBeenSet) {
        this.getTagList().add(tag);
        if (otherSideHasBeenSet) {
            return;
        }
        tag.addTodo(this, true);
    }
    //-------------------------------------------------

    //-------------------- delete any_todo ---------------------------------
    public void removeTag(Tag tag) {
        removeTag(tag, false);
    }

    public void removeTag(Tag tag, boolean otherSideHasBeenSet) {
        this.getTagList().remove(tag);
        if (otherSideHasBeenSet) {
            return;
        }
        tag.removeTodo(this, true);
    }
    //-------------------------------------------------








    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Boolean getImportant() {
        return important;
    }

    public void setImportant(Boolean important) {
        this.important = important;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Todo)) return false;

        Todo todo = (Todo) o;

        if (id != todo.id) return false;
        if (!name.equals(todo.name)) return false;
        if (!comment.equals(todo.comment)) return false;
        if (!startDate.equals(todo.startDate)) return false;
        if (!endDate.equals(todo.endDate)) return false;
        if (!important.equals(todo.important)) return false;
        return priority == todo.priority;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + name.hashCode();
        result = 31 * result + comment.hashCode();
        result = 31 * result + startDate.hashCode();
        result = 31 * result + endDate.hashCode();
        result = 31 * result + important.hashCode();
        result = 31 * result + priority.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", comment='" + comment + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", important=" + important +
                ", priority=" + priority +
                '}';
    }
}


