package school.sorokin.javacore.oop.lessons.lesson9;

public class Main {
    public static void main(String[] args) {
        double a = 11.0;
        double b = 22.0;
        MyCalculator calc1 = new MyCalculator() {
            @Override
            public double calculate(double a, double b) {
                return a + b;
            }
        };
        MyCalculator calc2 = (a1, b2) -> a1 + b2;
        System.out.println(calc1.calculate(a, b));
        System.out.println(calc2.calculate(a, b));
    }
}
