package school.sorokin.javacore.basics;

import java.util.Scanner;

public class StringLesson {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        System.out.println(text.length());
        System.out.println(text.toUpperCase());

        if (text.contains("Java")) {
            System.out.println(text.indexOf("Java"));
        } else {
            System.out.println("Not a Java");
        }

        String[] newText = text.split(" ");
        for (String s : newText) {
            System.out.println(s);
        }
    }
}
