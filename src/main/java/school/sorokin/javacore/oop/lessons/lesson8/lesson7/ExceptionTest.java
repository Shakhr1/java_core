package school.sorokin.javacore.oop.lessons.lesson8.lesson7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ExceptionTest {

    public static String readFirstLine(String filename) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            return br.readLine();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя файла: ");
        String filename = scanner.nextLine();

        try {
            String firstLine = readFirstLine(filename);
            System.out.println("Первая строка: " + (firstLine != null ? firstLine : "Файл пуст"));
        } catch (NotFoundDataException | IOException e) {
            System.err.println("Ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}