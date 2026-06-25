package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        // Load the Spring application context from the XML configuration file
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Retrieve the dynamically wired BookService bean
        BookService bookService = (BookService) context.getBean("bookService");

        System.out.println("Library Management Application Started");

        // Execute service method to demonstrate DI and AOP Logging
        bookService.manageBook();
    }
}
