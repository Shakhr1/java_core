package school.sorokin.javacore.oop.lessons.lesson8.lesson2;

public class Main {
    public static void main(String[] args) {
        Book book = new Book();
        book.title = "Война и мир";
        book.author = "Лев Толстой";
        book.pages = 5;
        book.read();
    }
}
