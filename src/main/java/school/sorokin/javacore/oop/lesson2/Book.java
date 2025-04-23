package school.sorokin.javacore.oop.lesson2;

public class Book {
    String title;
    String author;
    int pages;

    void read () {
        System.out.println("Вы читаете книгу '" + title + "' авторства " + author + ". Страница: " + pages);
    }
}
