package com.project_phone_book.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.jar.JarOutputStream;
import java.util.stream.Collectors;

public class TeleBook {

    private List<Contact> contacts = new ArrayList<>();

    public TeleBook() {
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public Contact createContact(String name, String number) {
        if (name == null || number == null) {
            throw new NullPointerException("Name and telephone cannot be null.");
        } else if (name.isEmpty() || number.isEmpty()) {
            throw new IllegalArgumentException("Name and telephone cannot be empty.");
        } else if (areContactsContain(number)&&!contacts.isEmpty()) {
            System.out.println("Podany numer telefonu już jest w bazie.");
        }
        Contact contact = new Contact(name, number);
        return contact;
    }

    public void addContact(Contact contact){
        contacts.add(contact);
    }




    public void removeContact(String contactName) {
        if (contacts.stream().anyMatch(contact -> contact.getName().equals(contactName))) {
            contacts.removeIf(str -> str.getName().equals(contactName));
            System.out.println("Kontakt usunięty pomyślnie");
        }else {
            System.out.println("There is no such contact.");
        }
    }

    public void findAndPrint(String name) {
        List<Contact> lookingContacts = contacts.stream().filter(contact -> contact.getName().toLowerCase()
                .contains(name.toLowerCase()) || contact.getNumber().contains(name)).collect(Collectors.toList());

        if (!lookingContacts.isEmpty()) {
            lookingContacts.forEach(System.out::println);
        }else {
            System.out.println("There is no such contact in the phone-book");
        }
    }

    private boolean areContactsContain(String number) {
        return contacts.stream().allMatch(contact -> contact.getNumber().equals(number));
    }
}
