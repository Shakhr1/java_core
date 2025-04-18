package school.sorokin.javacore.basics.finalapp;

import java.util.Scanner;

public class UserBase {
    Scanner scanner = new Scanner(System.in);

    int[] phoneNumbers = new int[10];
    String[] people = new String[10];
    int currentContact = 0;

    public void addContact() {
        if (currentContact >= phoneNumbers.length) {
            System.out.println("Телефонная книга заполнена!");
            return;
        }
        System.out.println("Введите имя:");
        people[currentContact] = scanner.nextLine();
        if (people[currentContact].trim().isEmpty()) {
            System.out.println("Ошибка: имя не может быть пустым!");
            return;
        }
        System.out.println("Введите номер телефона:");
        phoneNumbers[currentContact] = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Имя: " + people[currentContact]);
        System.out.println("Телефон: " + phoneNumbers[currentContact]);
        currentContact++;
        System.out.println("Контакт успешно добавлен!");
    }

    public void findContact() {
        if (people == null || currentContact == 0) {
            System.out.println("Список контактов отсутствует");
            return;
        }
        System.out.println("Имя для поиска: ");
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
            System.out.println("Контакт не найден");
        }
    }

    public void deleteContact() {
        if (currentContact == 0) {
            System.out.println("Список контактов отсутствует");
            return;
        }

        System.out.println("Имя контакта для удаления: ");
        String nameToDelete = scanner.nextLine();

        boolean found = false;
        for (int i = 0; i < currentContact; i++) {
            if (people[i].equalsIgnoreCase(nameToDelete)) {
                for (int j = i; j < currentContact - 1; j++) {
                    people[j] = people[j + 1];
                    phoneNumbers[j] = phoneNumbers[j + 1];
                }
                people[i] = null;
                phoneNumbers[i] = 0;
                currentContact--;
                found = true;
                System.out.println("Контакт удален");
                break;
            }
        }

        if (!found) {
            System.out.println("Контакт не найден");
        }
    }

    public void viewContacts() {
        for (int i = 0; i < phoneNumbers.length; i++) {
            System.out.println(people[i] + " - " + phoneNumbers[i]);
        }
    }
}

