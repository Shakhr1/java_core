package school.sorokin.javacore.oop.lessons.reflec;

import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Class<?> clazz = Person.class;
        System.out.println(clazz.getName() +  ", \n" + clazz.getSimpleName());
        System.out.println(Arrays.toString(clazz.getInterfaces()));
        int modifiers = clazz.getModifiers();
        System.out.println(modifiers);
        System.out.println(Modifier.toString(modifiers));
    }
}
