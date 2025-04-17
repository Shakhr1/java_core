package school.sorokin.javacore.basics;

import java.util.Scanner;

public class ArraysLesson {
    public static void main(String[] args) {
        // 1. Проверка
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
            System.out.println("Value: " + array[i]);
        }

        // 2. Проверка
        for (int value : array) {
            System.out.println(value);
        }

        // 3. Проверка
        int max = array[0];
        int min = array[0];

        for (int i = 0; i < array.length; i++) {
            if (array[i] < min){
                min = array[i];
            }
            if(array[i] > max) {
                max = array[i];
            }
        }
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
        scanner.close();
    }
}
