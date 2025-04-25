package school.sorokin.javacore.oop.libraryApp.model;

import school.sorokin.javacore.oop.libraryApp.exception.ItemNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
    private static final String CATALOG_IS_EMPTY = "В библиотеке нет книг.";
    private final List<Book> catalog = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public void addBook() {
        System.out.print("Введите название книги: ");
        String title = scanner.nextLine().trim();
        System.out.print("Введите автора: ");
        String author = scanner.nextLine().trim();
        System.out.println("Введите количество экземпляров: ");
        try {
            int copies = Integer.parseInt(scanner.nextLine().trim());
            addBookToCatalog(new Book(title, author, copies));
        } catch (NumberFormatException e) {
            System.out.println("Количество должно быть числом.");
            scanner.next();
        }
    }

    public void addBookToCatalog(Book book) {
        catalog.add(book);
        book.setAvailableCopies(1);
        System.out.println("added");
    }

    public void takeBook() {
        System.out.println("do you want to take?");
        String searchBook = scanner.nextLine();
        findBook(searchBook);
    }

    public void returnBook() {
    }

    public void findBook(String title) {
        boolean found = false;
        if (!found) {
            for (Book book : catalog) {
                if (book.getTitle().equals(title)) {
                    System.out.println(book);
                }
            }
        } else {
            throw new ItemNotFoundException("Нет такой книги");
        }
    }

    public void getAllBooks() {
        if (catalog.isEmpty()) {
            System.out.println(CATALOG_IS_EMPTY);
            return;
        }
        for (Book book : catalog) {
            System.out.println(book);
        }
    }
}
