package itvdn.todolist.Sand.springTest;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface AmountMy {
    int min();
    int max();
}
