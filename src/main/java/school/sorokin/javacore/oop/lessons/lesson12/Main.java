package school.sorokin.javacore.oop.lessons.lesson12;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> users = Arrays.asList("Java is fun","Stream API simplifies data processing");
        users.stream()
                .flatMap(user -> Stream.of(user.split("\\s+")))
                .filter(word -> word.length() > 3)
                .distinct()
                .sorted()
                .forEach(System.out::println);
    }

}
