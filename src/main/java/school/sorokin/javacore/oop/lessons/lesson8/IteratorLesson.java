package school.sorokin.javacore.oop.lessons.lesson8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class IteratorLesson {
    public static void main(String[] args) {
        // Создаём список чисел от 1 до 10
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            numbers.add(i);
        }

        // Используем Iterator для безопасного удаления нечётных чисел
        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            Integer number = iterator.next();
            // Если число нечётное, удаляем его
            if (number % 2 != 0) {
                iterator.remove();
            }
        }

        // Выводим оставшиеся элементы списка
        System.out.println("Список после удаления нечётных чисел:");
        for (Integer num : numbers) {
            System.out.print(num + " ");
        }

        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        ListIterator<String> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            String word = listIterator.previous();
            System.out.println(word + " -> ");
        }
    }
}
