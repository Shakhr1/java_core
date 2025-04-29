package school.sorokin.javacore.basics.finalapp;

import java.util.Scanner;

public class UserBase {
    Scanner scanner;
    int[] phoneNumbers;
    String[] people;
    int currentContact;

    public UserBase() {
        scanner = new Scanner(System.in);
        phoneNumbers = new int[10];
        people = new String[10];
        currentContact = 0;
    }
    public void addContact() {
        String name;
        if (currentContact >= phoneNumbers.length) {
            System.out.println("Телефонная книга заполнена!");
            return;
        }

        while (true) {
            System.out.print("Введите имя: ");
            name = scanner.nextLine().trim();

            if (name.isEmpty()) {
                System.out.println("Ошибка: имя не может быть пустым!");
                continue;
            }

            boolean duplicateFound = false;
            for (int i = 0; i < currentContact; i++) {
                if (name.equalsIgnoreCase(people[i])) {
                    System.out.println("Ошибка: контакт с таким именем уже существует!");
                    duplicateFound = true;
                    break;
                }
            }

            if (!duplicateFound) {
                break;
            }
        }

        System.out.print("Введите номер телефона: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Ошибка! Введите целое число.");
            scanner.next();
        }

        phoneNumbers[currentContact] = scanner.nextInt();
        scanner.nextLine();
        people[currentContact] = name;

        System.out.println("Имя: " + people[currentContact]);
        System.out.println("Телефон: " + phoneNumbers[currentContact]);
        System.out.println("Контакт успешно добавлен!");
        currentContact++;
    }

    public void findContact() {
        if (people == null || currentContact == 0) {
            System.out.println("Список контактов отсутствует.");
            return;
        }
        System.out.print("Имя для поиска: ");
        String searchName = scanner.nextLine();

        boolean found = false;
        int contactIndex = 0;

        while (!found && contactIndex < currentContact) {
            if (people[contactIndex].equalsIgnoreCase(searchName)) {
                found = true;
            } else {
                contactIndex++;
            }
        }

        if (found) {
            System.out.println("Телефон " + people[contactIndex] + ": " + phoneNumbers[contactIndex]);
        } else {
            System.out.println("Контакт не найден.");
        }
    }

    public void deleteContact() {
        if (currentContact == 0) {
            System.out.println("Список контактов отсутствует.");
            return;
        }

        System.out.print("Имя контакта для удаления: ");
        String nameToDelete = scanner.nextLine().trim();

        boolean found = false;
        for (int i = 0; i < currentContact; i++) {
            if (people[i] != null && people[i].equalsIgnoreCase(nameToDelete)) {
                for (int j = i; j < currentContact - 1; j++) {
                    people[j] = people[j + 1];
                    phoneNumbers[j] = phoneNumbers[j + 1];
                }
                people[i] = null;
                phoneNumbers[i] = 0;
                currentContact--;
                System.out.println("Контакт удален.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Контакт не найден.");
        }
    }

    public void viewContacts() {
        for (int i = 0; i < phoneNumbers.length; i++) {
            if (people[i] != null) {
                System.out.println(people[i] + " - " + phoneNumbers[i]);
            }
        }
    }
}

