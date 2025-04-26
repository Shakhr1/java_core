package school.sorokin.javacore.oop.finalproject;

import java.util.Objects;

public class Magazine extends Publication implements Printable {
    private int issueNumber;

    public Magazine(String title, String author, int year, int issueNumber) {
        super(title, author, year);
        this.issueNumber = issueNumber;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Magazine magazine = (Magazine) o;
        return issueNumber == magazine.issueNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), issueNumber);
    }

    @Override
    public String toString() {
        return "Журнал: " + getTitle() +
                ", Автор: " + getAuthor() +
                ", Год: " + getYear() +
                ", Номер выпуска: " + getIssueNumber() +
                '.';
    }

    @Override
    public String getType() {
        return "Журнал";
    }

    @Override
    public void printDetails() {
        System.out.println(toString());
    }
}
