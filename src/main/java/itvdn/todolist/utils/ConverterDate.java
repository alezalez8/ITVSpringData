package itvdn.todolist.utils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ConverterDate {

    public static void main(String[] args) {

       /* String inpData;
        Scanner scanner = new Scanner(System.in);
        inpData = scanner.nextLine();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd,MM.yy");
        LocalDate localDate = LocalDate.parse(inpData, dateTimeFormatter);
        System.out.println("You input  " + localDate.toString());*/
        LocalTime localDate1 = LocalTime.now();
        System.out.println("data now " + localDate1.toString());

    }
}
