package school.sorokin.javacore.oop.contactApp.service;

import school.sorokin.javacore.oop.contactApp.exception.DuplicateContactException;
import school.sorokin.javacore.oop.contactApp.model.Contact;

import java.util.*;

public class ContactBook {
    private final Scanner scanner;
    private final List<Contact> contactList;
    private final Set<Contact> contactSet;
    private final Map<String, List<Contact>> groupMap;

    public ContactBook() {
        scanner = new Scanner(System.in);
        contactList = new ArrayList<>();
        contactSet = new HashSet<>();
        groupMap = new HashMap<>();
    }

    public void writeNewContact() {
        System.out.print("Введите имя и фамилию: ");
        String name = scanner.nextLine().trim();
        System.out.print("Введите телефон: ");
        String phone = scanner.nextLine().trim();
        System.out.print("Введите эл.почту: ");
        String email = scanner.nextLine().trim();
        System.out.print("Введите группу (Работа, Друзья, Семья): ");
        String group = scanner.nextLine().trim();
        addContact(new Contact(name, phone, email, group));
    }

    private void addContact(Contact contact) {
        try {
            if (contactSet.contains(contact)) {
                throw new DuplicateContactException("Контакт уже существует!");
            }
        } catch (DuplicateContactException e) {
            System.out.println(e.getMessage());
            return;
        }

        contactList.add(contact);
        contactSet.add(contact);
        String group = contact.getGroup();
        groupMap.computeIfAbsent(group, k -> new ArrayList<>()).add(contact);
        System.out.println("Контакт добавлен.");
    }

    public void deleteContact() {
        if (contactList.isEmpty()) {
            System.out.println("Список контактов пуст!");
            return;
        }
        System.out.print("Введите имя контакта для удаления: ");
        String nameToDelete = scanner.nextLine().trim();

        boolean isRemoved = false;

        Iterator<Contact> iterator = contactList.iterator();
        while (iterator.hasNext()) {
            Contact contact = iterator.next();
            if (contact.getName().equals(nameToDelete)) {
                iterator.remove();
                isRemoved = true;
                break;
            }
        }

        if (isRemoved) {
            Iterator<Contact> setIterator = contactSet.iterator();
            while (setIterator.hasNext()) {
                Contact contact = setIterator.next();
                if (contact.getName().equals(nameToDelete)) {
                    setIterator.remove();
                    break;
                }
            }

            for (List<Contact> groupContact : groupMap.values()) {
                Iterator<Contact> groupIterator = groupContact.iterator();
                while (groupIterator.hasNext()) {
                    Contact contact = groupIterator.next();
                    if (contact.getName().equals(nameToDelete)) {
                        groupIterator.remove();
                        break;
                    }
                }
            }
            System.out.println("Контакт '" + nameToDelete + "' успешно удален!");
        } else {
            System.out.println("Контакт с именем '" + nameToDelete + "' не найден.");
        }
    }

    public void viewAllContact() {
        if (contactList.isEmpty()) {
            System.out.println("Контактов нет.");
            return;
        }
        for (Contact contact : contactList) {
            System.out.println(contact);
        }
    }

    public void findContact() {
    }

    public void getContactsByGroup() {
        if (groupMap.isEmpty()) {
            System.out.println("Список контактов пуст!");
            return;
        }
        System.out.print("Введите название группы: ");
        String group = scanner.nextLine().trim();
        System.out.println("Контакты в группе -> " + group);
        for (Contact contact : groupMap.get(group)) {
            System.out.println(contact);
        }
    }
}
