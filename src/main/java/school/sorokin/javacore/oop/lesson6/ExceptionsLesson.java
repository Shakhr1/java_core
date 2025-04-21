package school.sorokin.javacore.oop.lesson6;

import java.util.Scanner;

public class ExceptionsLesson {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первое число: ");
        int a = scanner.nextInt();
        System.out.print("Введите второе число: ");
        int b = scanner.nextInt();

        try {
            int result = a / b;
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль");
        } finally {
            System.out.println("Спасибо за использование программы");
        }

    }
}
