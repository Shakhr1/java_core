package school.sorokin.javacore.basics;

import java.util.Scanner;

public class ifElseLesson {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number from 1 to 5: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> System.out.println("The first genre");
            case 2 -> System.out.println("The second genre");
            case 3 -> System.out.println("The third genre");
            case 4 -> System.out.println("The fourth genre");
            case 5 -> System.out.println("The fifth genre");
            default -> System.out.println("No such genre");
        }
    }
}
