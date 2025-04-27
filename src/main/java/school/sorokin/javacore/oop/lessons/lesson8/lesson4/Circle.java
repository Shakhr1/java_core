package school.sorokin.javacore.oop.lessons.lesson8.lesson4;

public class Circle extends Shape {
    String shape = "Circle";
    @Override
    void draw() {
        super.draw();
        System.out.println("Drawing a " + shape);
    }
}
