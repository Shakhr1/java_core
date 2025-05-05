package school.sorokin.javacore.basics;

public class VariablesLesson {
    public static void main(String[] args) {
        byte flash = 69;
        short year = 2077;
        int population = 8_000_000;
        long peekOnlineValve = 99_400_000L;
        float temperature = 36.6f;
        double pi = 3.1415926535;
        boolean isTrue = false;
        char button = 'F';

        System.out.println("flash: " + flash);
        System.out.println("year: " + year);
        System.out.println("population: " + population);
        System.out.println("peekOnlineValve: " + peekOnlineValve);
        System.out.println("temperature: " + temperature);
        System.out.println("pi: " + pi);
        System.out.println("is true or not: " + isTrue);
        System.out.println("button: " + button);

        int onlineValve = (int) peekOnlineValve;
        System.out.println("onlineValve: " + onlineValve);

        long online = peekOnlineValve - onlineValve;
        System.out.println("Потеря данных: " + online);

        for (int i = 0; i < 3; i++) {
            System.out.println(button + i);
        }
    }
}
