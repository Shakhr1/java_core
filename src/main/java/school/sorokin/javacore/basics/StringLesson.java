package school.sorokin.javacore.basics;

public class StringLesson {
    public static void main(String[] args) {
        String sentence = "Java is cool and very popular.";
        boolean containsCool = sentence.contains("cool");
        System.out.println("Содержит 'cool'? " + containsCool);
    }
}
