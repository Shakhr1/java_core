package school.sorokin.javacore.oop.finalproject;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

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
                    library.addPublication();
                    break;
                case 2:
                    library.listPublications();
                    break;
                case 3:
                    library.searchByAuthor();
                    break;
                case 4:
                    System.out.println("Общее количество публикаций: " + library.getPublicationCount());
                    break;
                case 5:
                    System.out.println("Выход...");
                    System.exit(0);
                default:
                    System.out.println("Извините, такой команды пока нет.");
            }
        }
    }

    public static void printMenu () {
        System.out.println("1. Добавить новую публикацию.");
        System.out.println("2. Вывести список всех публикаций.");
        System.out.println("3. Поиск публикации по автору.");
        System.out.println("4. Вывести общее количество публикаций.");
        System.out.println("5. Выйти");
    }
}
