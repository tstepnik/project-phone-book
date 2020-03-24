package com.project_phone_book.controller;

import com.project_phone_book.model.Contact;
import com.project_phone_book.model.TeleBook;

import java.io.File;
import java.util.Scanner;

public class TeleBookController {

//    public static final int ADD_CONTACT = 0;
//    public static final int FIND_BY_CHARS = 1;
//    public static final int DELETE = 2;
//    public static final int END = 3;

    TeleBook teleBook = new TeleBook();
    Scanner sc = new Scanner(System.in);
    FileOperations file = new FileOperations();


    public void phoneBookApi() {
        createFileAndAddToList();
        Option option = null;
        while (option != Option.END) {
            intro();
            int choice = nextInt();
            try {
                option = Option.values()[choice];
                switch (option) {
                    case ADD_CONTACT:
                        addContact();
                        break;
                    case FIND_BY_CHARS:
                        findByChars();
                        break;
                    case DELETE:
                        delete();
                        break;
                    case PRINT_ALL_CONTACTS:
                        printAll();
                        break;
                    case END:
                        end();
                        break;
                    default:
                        System.out.println("You choose wrong option.");
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("You took incorrect option.");
            } catch (NullPointerException e) {
                System.out.println("THere is no option such this.");
            } catch (IllegalArgumentException e) {
                System.out.println("Name and telephone cannot be empty");
            }
        }
    }


    public void createFileAndAddToList() {
        file.createFile();
        file.addToListFromFile(teleBook.getContacts());
    }

    private void printAll() {
        teleBook.getContacts().forEach(System.out::println);
    }

    private int nextInt() {
        int number = sc.nextInt();
        sc.nextLine();
        return number;
    }

    private void intro() {
        System.out.println("Dostępne opcje:");
        for (Option value : Option.values()) {
            System.out.println(value.toString());
        }
        System.out.println("Wybierz opcję:");
    }

    private void delete() {
        System.out.println("Podaj nazwę kontaktu który chcesz usunąć:");
        String contact = sc.nextLine();
        teleBook.removeContact(contact);
    }

    private void findByChars() {
        System.out.println("Podaj dane które użytkownika(część numeru/nazwy:");
        String data = sc.nextLine();
        teleBook.findAndPrint(data);
    }


    private void addContact() {
        System.out.println("Podaj nazwę użytkownika(imię i nazwisko):");
        String name = sc.nextLine();
        System.out.println("Podaj numer telefonu:");
        String number = sc.nextLine();
        while (!number.matches(".*\\d.*")) {
            System.out.println("Możesz podać tylko liczby całkowite:");
            number = sc.nextLine();
        }
        Contact contact = teleBook.createContact(name, number);
        teleBook.addContact(contact);
        System.out.println("Contact successfully added");
    }

    private void end() {
        file.deleteFile();
        file.createFile();
        teleBook.getContacts().forEach(contact1 -> file.addToFile(contact1));
        System.out.println("Koniec programu");
        sc.close();
    }
}
