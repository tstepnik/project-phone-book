package com.project_phone_book.controller;

public enum Option {
    ADD_CONTACT(0,"dodaj kontakt"),
    FIND_BY_CHARS(1,"znajdź kontakt"),
    DELETE(2,"usuń kontakt"),
    PRINT_ALL_CONTACTS(3,"Wyświetl wszystkie dostępne kontakty"),
    END(4,"koniec programu");

    public String description;
    public final int shortcut;

    Option(int shortcut,String description) {
        this.description = description;
        this.shortcut=shortcut;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getShortcut() {
        return shortcut;
    }

    @Override
    public String toString() {
        return shortcut + " - " + description;
    }
}