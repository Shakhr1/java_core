package school.sorokin.javacore.oop.lessons.thread;

public class Main {
    private static final int N = 100_000_000;
    private static volatile int x = 0;
    public static void main(String[] args) throws InterruptedException {
        // "inc" - это сокращение от "increment"
        Thread incThread = new Thread(() -> {
            for (int i = 0; i < N; i++) {
                x++;
            }
        });

        // "dec" - это сокращение от "decrement"
        Thread decThread = new Thread(() -> {
            for (int i = 0; i < N; i++) {
                x--;
            }
        });

        incThread.start();
        decThread.start();

        incThread.join();
        decThread.join();

        System.out.println("x = " + x);
    }
}
