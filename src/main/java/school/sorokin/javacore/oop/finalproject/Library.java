package school.sorokin.javacore.oop.finalproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
    private final Scanner scanner = new Scanner(System.in);
    private static int publicationCount = 0;
    private final List<Publication> publications = new ArrayList<>();
    private static final String ENTER_AUTHOR = "Введите автора: ";
    private static final String ENTER_TITLE = "Введите название: ";
    private static final String ENTER_YEAR = "Введите год: ";
    private static final String PUBLICATION_IS_EMPTY = "В библиотеке нет публикаций.";


    public void addPublication() {

        while (true) {
            System.out.println("Выберите тип публикации: 1 – Book, 2 – Magazine, 3 – Newspaper.");
            System.out.println("0 - Вернуться в меню..");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.print(ENTER_TITLE);
                    String title = scanner.nextLine().trim();
                    System.out.print(ENTER_AUTHOR);
                    String author = scanner.nextLine().trim();
                    System.out.print(ENTER_YEAR);
                    int year = readInt(scanner);
                    System.out.print("Введите ISBN: ");
                    String isbn = scanner.nextLine().trim();
                    addPublicationCount(new Book(title, author, year, isbn));
                    break;
                case "2":
                    System.out.print(ENTER_TITLE);
                    title = scanner.nextLine().trim();
                    System.out.print(ENTER_AUTHOR);
                    author = scanner.nextLine().trim();
                    System.out.print(ENTER_YEAR);
                    year = readInt(scanner);
                    System.out.print("Введите номер выпуска: ");
                    int issueNumber = readInt(scanner);
                    addPublicationCount(new Magazine(title, author, year, issueNumber));
                    break;
                case "3":
                    System.out.print(ENTER_TITLE);
                    title = scanner.nextLine().trim();
                    System.out.print(ENTER_AUTHOR);
                    author = scanner.nextLine().trim();
                    System.out.print(ENTER_YEAR);
                    year = readInt(scanner);
                    System.out.print("Введите дату публикации: ");
                    var publicationDay = scanner.nextLine();
                    addPublicationCount(new Newspaper(title, author, year, publicationDay));
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Ошибка: Введите 1, 2, 3 или 0");
                    break;
            }
        }
    }

    public void addPublicationCount(Publication pub) {
        publications.add(pub);
        setPublicationCount(1);
        System.out.println("Публикация успешно добавлена!");
    }

    public void listPublications() {
        if (publications.isEmpty()) {
            System.out.println(PUBLICATION_IS_EMPTY);
            return;
        }
        for (Publication publication : publications) {
            publication.printDetails();
        }
    }

    public void searchByAuthor() {
        if (publications.isEmpty()) {
            System.out.println(PUBLICATION_IS_EMPTY);
            return;
        }
        System.out.print("Введите имя автора для поиска: ");
        String author = scanner.nextLine().trim();

        boolean found = false;
        for (Publication publication : publications) {
            if (publication.getAuthor().equals(author)) {
                System.out.println(publication);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Публикации автора " + author + " не найдены.");
        }
    }
    private static int readInt(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine().trim();
            if (input.matches("\\d+")) {
                return Integer.parseInt(input);
            }
            System.out.print("Ошибка ввода. Введите число: ");
        }
    }

    public int getPublicationCount() {
        return publicationCount;
    }

    public static void setPublicationCount(int publicationCount) {
        Library.publicationCount = publicationCount;
    }
}
