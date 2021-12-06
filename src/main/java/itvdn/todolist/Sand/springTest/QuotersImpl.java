package itvdn.todolist.Sand.springTest;

public class QuotersImpl implements Quoters {

    private String message;


    @AmountMy(min = 2, max = 7)
    private int ammount;

    @Override
    public void say() {
        System.out.println(message);
    }


    public void messOut() {
        say();
    }
}
