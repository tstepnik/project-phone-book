package com.project_phone_book.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
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

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void removeContact(String contactName) {
        contacts.forEach(contact -> {
            if (contact.getName().equals(contactName)) {
                contacts.remove(contact);
            }
        });
    }

    public void findAndPrint(String name) {
        List<Contact> lookingContacts = contacts.stream().filter(contact -> contact.getName().toLowerCase()
                .contains(name.toLowerCase()) || contact.getNumber().contains(name)).collect(Collectors.toList());

        lookingContacts.forEach(System.out::println);
    }


}
