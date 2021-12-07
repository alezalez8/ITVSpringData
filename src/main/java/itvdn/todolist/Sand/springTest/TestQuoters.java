package itvdn.todolist.Sand.springTest;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestQuoters {
    public static void main(String[] args) {
        QuotersImpl quoters = new QuotersImpl();

        quoters.say();

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("myXml.xml");
       // context.getBean("ttt");
    }
}
