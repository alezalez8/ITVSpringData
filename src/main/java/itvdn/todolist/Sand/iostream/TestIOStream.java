package itvdn.todolist.Sand.iostream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TestIOStream {
    private static int intNumber = 10;
    private static char charNumber = 'b';

    public static void main(String[] args) {

        String text = "Привет мир!"; // строка для записи
        try(FileOutputStream fos=new FileOutputStream("C://_SomeDir//notes3.txt");
            PrintStream printStream = new PrintStream(fos);
            PrintStream printStream2 = new PrintStream("C://_SomeDir//notes4.txt");
            PrintWriter printWriter = new PrintWriter("C://_SomeDir//notes4.txt"))

        {
            printStream.println(text);
            printStream2.println("\nновая строка");

            String message = "PrintStream";
            byte[] message_toBytes = message.getBytes();
            printStream2.write(message_toBytes);

            //printWriter.write("PrintWritter");
            printWriter.println("PrintWritter");
            List<String> list = new ArrayList<>();
           int i = 3;
           int b = i | 1;
            System.out.println(b);


            System.out.println("Запись в файл произведена");
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

    }
}
