package school.sorokin.javacore.oop.contactApp.model;

import java.util.Objects;

public class Contact {
    private String name;
    private int number;
    private String email;
    private String group;

    public Contact(String name, int number, String email, String group) {
        this.name = name;
        this.number = number;
        this.email = email;
        this.group = group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact contact)) return false;
        return number == contact.number && Objects.equals(name, contact.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, number);
    }

    @Override
    public String toString() {
        return "Contact{" +
               "name='" + name + '\'' +
               ", number=" + number +
               ", email='" + email + '\'' +
               ", group='" + group + '\'' +
               '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

}
