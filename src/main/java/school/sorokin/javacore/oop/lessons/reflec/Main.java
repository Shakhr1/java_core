package school.sorokin.javacore.oop.lessons.reflec;

import java.lang.reflect.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Class<?> clazz = Person.class;
        System.out.println("class name -> " + clazz.getName());
        System.out.println("class simple name -> " + clazz.getSimpleName());
        System.out.println("interface -> " + Arrays.toString(clazz.getInterfaces()));
        int modifiers = clazz.getModifiers();
        System.out.println("count modifiers -> " + modifiers);
        System.out.println("type modifiers" + Modifier.toString(modifiers));
        System.out.println("-----------------------");

        try {
            // Получаем конструктор, который принимает String and int
            Constructor<?> constructor = Person.class.getConstructor(String.class, int.class);

            // Создаём объект
            Person obj = (Person) constructor.newInstance("Shakh",21);
            System.out.println("Person -> " + obj.getName() + ", " + obj.getAge());

            // Достаём приватный конструктор
            Constructor<?> privateConstructor = Person.class.getDeclaredConstructor();
            privateConstructor.setAccessible(true);
            Person privatePerson = (Person) privateConstructor.newInstance();
            System.out.println("private Person -> " + privatePerson.getName() + ", " + privatePerson.getAge());
        } catch (InstantiationException | IllegalAccessException
                 | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        System.out.println("------------------");
        Field[] fields = Person.class.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("field name -> " + field.getName());
        }
        Field[] privateFields = Person.class.getDeclaredFields();
        for (Field field : privateFields) {
            System.out.println("private field name -> " + field.getName());
        }

        System.out.println("------------------");
        try {
            Person instance = new Person("Alice", 21);

            // Допустим, есть метод public void printMessage(String suffix)
            Method printMethod = Person.class.getMethod("sayHello", String.class);
            printMethod.invoke(instance, "Boom");

            // Если метод приватный, ищем через getDeclaredMethod:
            Method secretMethod = Person.class.getDeclaredMethod("sayHelloPrivate", String.class);
            secretMethod.setAccessible(true);
            secretMethod.invoke(instance, "BoomPrivate");

        } catch (NoSuchMethodException | IllegalAccessException
                 | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
