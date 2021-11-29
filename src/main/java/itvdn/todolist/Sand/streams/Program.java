package itvdn.todolist.Sand.streams;

import java.util.*;

public class Program {
    public static void main(String[] args) {

        List<Person> nums = new ArrayList<>();
        nums.add(new Person("Женя", 8));
        nums.add(new Person("Толя", 14));
        nums.add(new Person("Аня", 12));
        nums.add(new Person("Игорь", 22));
        nums.add(new Person("Лена", 18));
        nums.add(new Person("Юра", 11));

        Set<String> stringList = new TreeSet<>();

        stringList.add("aad");
        stringList.add("aab");
        stringList.add("aaa");
        stringList.add("aac");
        stringList.add("aae");
        stringList.add("aae");

        stringList.stream().forEach(System.out::println);

        System.out.println("========================================");



        nums.parallelStream().filter(l -> l.getName().endsWith("я"))
                        .forEach(System.out::println);


/*
        //nums.stream().forEach(System.out::println);
        nums.stream()
                .filter(person -> person.getAge() >= 12)
                .sorted((o1, o2) -> o1.getName().compareTo(o2.getName()))
                .sorted(Comparator.comparing(Person::getName))
                .map(p -> p.getAge())
                // .sorted((o1, o2) -> o1.getAge().compare(o2.getAge()))
                .forEach(System.out::println);


        System.out.println(nums.stream()
                .filter(person -> person.getAge() >= 12)
                .mapToInt(p -> p.getAge())
                .average()
                .getAsDouble());
*/

    }
}
