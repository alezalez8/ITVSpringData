package itvdn.todolist.Sand.springTest;


import org.springframework.stereotype.Component;


public class QuotersImpl implements Quoters {

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;

    @AmountMy(min = 2, max = 7)
    private int ammount;

    @Override
    public void say() {
        System.out.println(message);
    }


    public void messOut() {
        for (int i = 0; i < ammount; i++) {
            say();
        }
    }
}
