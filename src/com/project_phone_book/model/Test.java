package com.project_phone_book.model;

public class Test {
    public static void main(String[] args) {

        TeleBook teleBook = new TeleBook();

        teleBook.addContact(new Contact("Jan Kowalski","123456789"));
        teleBook.addContact(new Contact("Marek Krawczyk","234567891"));

        teleBook.findAndPrint("Mar");


    }
}
