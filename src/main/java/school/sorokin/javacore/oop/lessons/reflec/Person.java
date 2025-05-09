package school.sorokin.javacore.oop.lessons.reflec;

public class Person {
    private final String name;
    private final int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private Person() {
        this.name = "private name";
        this.age = -0;
    }

    public void sayHello(String name) {
        System.out.println("public: Hello " + name);
    }

    private void sayHelloPrivate(String name) {
        System.out.println("private: Hello " + name);
    }
}
