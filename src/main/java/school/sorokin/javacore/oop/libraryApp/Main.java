package school.sorokin.javacore.oop.libraryApp;

import school.sorokin.javacore.oop.libraryApp.model.Library;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        while(true) {
            printMenu();
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();
            switch (input) {
                case 1 -> {}
            }
        }

    }

    private static void printMenu() {
        System.out.println("""
                1. Вывести каталог.
                2. Добавить объект.
                3. Выдать объект.
                4. Вернуть объект.
                5. Выйти из приложения. 
                """);
    }
}
