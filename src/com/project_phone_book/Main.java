package com.project_phone_book;

import com.project_phone_book.controller.Option;
import com.project_phone_book.controller.TeleBookController;
import com.project_phone_book.model.Contact;
import com.project_phone_book.model.TeleBook;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        TeleBookController controller = new TeleBookController();

        controller.phoneBookApi();
    }
}
