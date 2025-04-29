package school.sorokin.javacore.basics.finalapp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        UserBase user = new UserBase();

        while (true) {
            printMenu();
            if (!scanner.hasNextInt()) {
                System.out.println("Ошибка! Введите целое число.");
                scanner.next();
            }

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    user.addContact();
                    break;
                case 2:
                    user.viewContacts();
                    break;
                case 3:
                    user.findContact();
                    break;
                case 4:
                    user.deleteContact();
                    break;
                case 5:
                    System.out.println("Выход...");
                    System.exit(0);
                default:
                    System.out.println("Извините, такой команды пока нет.");
            }
        }
    }

    private static void printMenu() {
        System.out.print("""
                1. Добавить контакт"
                2. Просмотреть контакты
                3. Найти контакт
                4. Удалить контакт
                5. Выйти
                """);
    }
}
