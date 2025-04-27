package school.sorokin.javacore.oop.lesson8;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class IteratorLesson {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        ListIterator<String> iterator = list.listIterator(list.size());
        while (iterator.hasPrevious()) {
            String word = iterator.previous();
            System.out.println(word + " -> ");
        }
    }
}
