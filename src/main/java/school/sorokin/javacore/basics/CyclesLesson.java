package school.sorokin.javacore.basics;

public class CyclesLesson {
    public static void main(String[] args) {
        // 1. Проверка
        for (int i = 0; i < 100; i++) {
            if (i % 3 == 0){
                System.out.println(i);
            }
        }
        // 2. Проверка
        int number = 10;
        while (number > 0){
            System.out.println(number);
            number--;
        }
        // 3. Проверка
        int result = 0;
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                result = i * j;
                System.out.println(i + "*" + j + "=" + result);
            }
        }
        // 4. Проверка
        int anotherResult = 0;
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                if (anotherResult > 30) {
                    break;
                }
                anotherResult = i * j;
                System.out.println(i + "*" + j + "=" + anotherResult);
            }
        }
    }
}
