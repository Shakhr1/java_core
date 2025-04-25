package school.sorokin.javacore.oop.libraryApp;

import school.sorokin.javacore.oop.libraryApp.model.Library;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            printMenu();
            try {
                int input = scanner.nextInt();
                scanner.nextLine();

                switch (input) {
                    case 1 -> library.getAllBooks();
                    case 2 -> library.addBook();
                    case 3 -> library.takeBook();
                    case 4 -> library.returnBook();
                    case 5 -> {
                        System.out.println("Выход...");
                        System.exit(0);
                    }
                    default -> System.out.println("Извините, такой команды пока нет.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Введите число 1 - 5");
                scanner.next();
            }
        }

    }

    private static void printMenu() {
        System.out.print("""
                1. Вывести каталог.
                2. Добавить объект.
                3. Выдать объект.
                4. Вернуть объект.
                5. Выйти из приложения.
                """);
    }
}
