package school.sorokin.javacore.oop.lessons.lesson11;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<User> users = Arrays.asList(
                new User("Алиса", 30),
                new User("Бэн", 25),
                new User("Шарлот", 35),
                new User("Алиса", 30),
                new User("Давид", 26)
        );

        List<String> result = users.stream()
                .filter(user -> user.getAge() > 25)
                .map(User::getName)
                .sorted()
                .distinct()
                .toList();

        System.out.println("Отфильтрованные и отсортированные имена: " + result);
    }
}