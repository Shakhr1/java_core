package school.sorokin.javacore.oop.libraryApp.model;

import school.sorokin.javacore.oop.libraryApp.exception.ItemNotFoundException;
import school.sorokin.javacore.oop.libraryApp.exception.NoAvailableCopiesException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
    private final String ENTER_TITLE;
    private final String CATALOG_IS_EMPTY;
    private final String BOOK_NOT_FOUND;
    private final String INVALID_DATA;
    private final List<Book> catalog;
    private final Scanner scanner;

    public Library() {
        ENTER_TITLE = "Введите название книги: ";
        BOOK_NOT_FOUND = "Книга не найдена: ";
        CATALOG_IS_EMPTY = "В библиотеке нет книг.";
        INVALID_DATA = "Данные введены некорректно";
        catalog = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addBook() {
        System.out.print(ENTER_TITLE);
        String title = scanner.nextLine().trim();
        if (title.isEmpty()) {
            System.out.println(INVALID_DATA);
            return;
        }

        System.out.print("Введите автора: ");
        String author = scanner.nextLine().trim();
        if (author.isEmpty()) {
            System.out.println(INVALID_DATA);
            return;
        }

        try {
            System.out.print("Введите количество экземпляров: ");
            int copies = Integer.parseInt(scanner.nextLine().trim());
            if (copies <= 0) {
                System.out.println(INVALID_DATA);
                return;
            }
            addBookToCatalog(new Book(title, author, copies));
        } catch (NumberFormatException e) {
            System.out.println("Количество должно быть числом.");
        }
    }

    public void addBookToCatalog(Book book) {
        catalog.add(book);
        book.setAvailableCopies(1);
        System.out.println("Успешно добавлена.");
    }

    public void takeBook() {
        if (catalog.isEmpty()) {
            System.out.println(CATALOG_IS_EMPTY);
            return;
        }

        try {
            System.out.println(ENTER_TITLE);
            String searchBook = scanner.nextLine();
            Book book = findBook(searchBook);

            if (book == null) {
                throw new ItemNotFoundException(BOOK_NOT_FOUND + searchBook);
            } else if (book.getAvailableCopies() < 1) {
                throw new NoAvailableCopiesException("Больше нет экземпляров книги: " + searchBook);
            }

            book.setAvailableCopies(book.getAvailableCopies() - 1);
            System.out.println("'" + searchBook + "'" + " выдано.");
        } catch (ItemNotFoundException | NoAvailableCopiesException e) {
            System.out.println(e.getMessage());
        }
    }

    public void returnBook() {
        try {
            System.out.println(ENTER_TITLE);
            String returnTheBook = scanner.nextLine();
            Book book = findBook(returnTheBook);

            if (book == null) {
                throw new ItemNotFoundException(BOOK_NOT_FOUND + returnTheBook);
            }

            book.setAvailableCopies(book.getAvailableCopies() + 1);
            System.out.println("'" + returnTheBook + "'" + " возвращено.");
        } catch (ItemNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public Book findBook(String title) {
        for (Book book : catalog) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
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
