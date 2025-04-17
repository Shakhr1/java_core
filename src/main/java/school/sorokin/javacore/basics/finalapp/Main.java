package school.sorokin.javacore.basics.finalapp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        UserBase user = new UserBase();

        while (true) {
            printMenu();
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

    public static void printMenu () {
        System.out.println("1. Добавить контакт");
        System.out.println("2. Просмотреть контакты");
        System.out.println("3. Найти контакт");
        System.out.println("4. Удалить контакт");
        System.out.println("5. Выйти");
    }
}
