package school.sorokin.javacore.oop.lessons.lesson10;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
//        List<> names = Arrays.asList("Alice", "Bob", "Charlie");
//        Stream<String> streamFromList = names.stream();
//        System.out.println("Стрим из коллекции:");
//        streamFromList.forEach(System.out::println);


        List<Integer> numbers = new Random()
                .ints(100,0,100)
                .filter(i -> i % 2 == 0)
                .limit(10)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(numbers);

//        List<Integer> streamFromIntegers = numbers.stream()
//                .filter(n -> n % 2 == 0)
//                .limit(10)
//                .collect(Collectors.toList());
//        System.out.println(streamFromIntegers);
    }
}
