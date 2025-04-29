package school.sorokin.javacore.oop.contactApp;

import school.sorokin.javacore.oop.contactApp.service.ContactBook;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContactBook contactBook = new ContactBook();

        while (true) {
            printMenu();
            try {
                int input = scanner.nextInt();
                scanner.nextLine();

                switch (input) {
                    case 1 -> contactBook.writeNewContact();
                    case 2 -> contactBook.deleteContact();
                    case 3 -> contactBook.viewAllContact();
                    case 4 -> contactBook.findContact();
                    case 5 -> contactBook.getContactsByGroup();
                    case 0 -> {
                        System.out.println("Выход...");
                        System.exit(0);
                    }
                    default -> System.out.println("Извините, такой команды пока нет.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Введите целое число");
                scanner.next();
            }
        }

    }

    private static void printMenu() {
        System.out.print("""
                Выберите действие:
                1 - Добавить контакт
                2 - Удалить контакт
                3 - Посмотреть все контакты
                4 - Найти контакт по имени
                5 - Посмотреть контакты по группе
                0 - Выход
                """);
    }
}

