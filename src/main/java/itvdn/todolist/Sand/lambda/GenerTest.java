package itvdn.todolist.Sand.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class GenerTest<T, K> implements Accnnl<T> {

    public static double sq(double num) {
        return Math.pow(num, 2);
    }

     void someFunction(String s)
    {
        System.out.println(s);
    }

    private K k;

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Geeks");
        list.add("For");
        list.add("GEEKS");

        // call the static method
        // using double colon operator
        list.forEach((new GenerTest())::someFunction);
        Function<Double, Double> sqrr = GenerTest::sq;
        System.out.println(sqrr.apply(12d));



        GenerTest<String, Double> ljlk = new GenerTest<>();
        GenerTest<Integer, Integer> test = new GenerTest<>();
        Printer printer = new Printer();
        printer.print("yuiy");
       // System.out.println("gfdg");
    }


    @Override
    public T getT() {
        System.out.println(Math.max(1, 3));
        return null;
    }

    private K getR() {
        return this.k;
    }
}



//Function sqrr = GenerTest::sq;



class Printer<T extends Tr> {

    public <T> void print(T ts) {
    }
}


interface Accnnl<T> {
    T getT();
}

class Tr {
}

class Rttt<T> {

}

class DA extends Rttt<String> {

}

