package com.project_phone_book.controller;

import com.project_phone_book.model.Contact;

import java.io.*;
import java.util.List;

public class FileOperations {
    public static final String fileName = "phone-book.csv";
    File file = new File(fileName);

    public void createFile() {
        boolean fileExist = file.exists();

        if (!fileExist) {
            try {
                fileExist = file.createNewFile();
                System.out.println("File successfully created");
            } catch (IOException e) {
                System.out.println("Failed to create a file");
            }
        }
        else if (fileExist) {
            System.out.println("File " + fileName + " exist ");
        }
    }

    public void addToListFromFile(List<Contact> list) {
        try (
                var fileReader = new FileReader(fileName);
                var reader = new BufferedReader(fileReader);
        ) {
            String nextLine = null;
            while ((nextLine = reader.readLine()) != null) {
                String[] split = nextLine.split(",");
                if (split != null) {
                    list.add(new Contact(split[0], split[1]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void deleteFile() {
        if (file.exists()) {
            file.delete();
        } else {
            System.out.println("File doesn't exist.");
        }
    }

    public void addToFile(Contact contact) {
        try (
                var fileWriter = new FileWriter(fileName,true);
                var writer = new BufferedWriter(fileWriter)
        ) {
            writer.write(contact.toString());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Failed to save a file.");
        }
    }

    public void readFromFile() {
        try (
                var fileReader = new FileReader(fileName);
                var reader = new BufferedReader(fileReader);
        ) {
            String nextLine = null;
            int lines = 0;
            while ((nextLine = reader.readLine()) != null) {
                System.out.println(nextLine);
                lines++;
            }
            System.out.println("Baza zawiera " + lines + " kontaktów.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
