package school.sorokin.javacore.basics;

public class OperatorsLesson {
    public static void main(String[] args) {
        // 1. Расчет среднего балла
        int grade = 1;
        int grade2 = 1;
        int grade3 = 10;

        double result = (grade + grade2 + grade3) / 3.0;
        System.out.println(result);

        //2. Проверка оценок
        if ((grade == 10) && (grade2 == 10) && (grade3 == 10)) {
            System.out.println("У студента все оценки максимальные!");
        }

        //3. Проверка
        if ((grade <= 2) || (grade2 <= 2) || (grade3 <= 2)) {
            System.out.println("Встречается очень низкая оценка!");
        }

        //4. Проверка
        if (result >= 5) {
            System.out.println("У студента удовлетворительная успеваемость");
        } else {
            System.out.println("У студента неудовлетворительная успеваемость");
        }
    }
}
