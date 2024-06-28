package com.example.libraryApplication;

import com.example.libraryApplication.Model.Book;
import com.example.libraryApplication.Model.Customer;
import com.example.libraryApplication.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private LibraryService libraryService;

    @Override
    public void run(String... args) throws Exception {
        // Check if the database is empty
        if (libraryService.getBookRepository().count() == 0) {
            List<Book> initialBooks = List.of(
                    new Book("Title1", "Author1", true),
                    new Book("Title2", "Author2", false),
                    new Book("Title3", "Author3", false)
            );

            libraryService.getBookRepository().saveAll(initialBooks);
            System.out.println("Initial books added to the database.");
        }
        if (libraryService.getCustomerRepository().count() == 0) {
            List<Customer> initialCustomers = List.of(
                    new Customer("c1", "c1@"),
                    new Customer("c2", "c2@"),
                    new Customer("c3", "c3@")
            );

            libraryService.getCustomerRepository().saveAll(initialCustomers);
            System.out.println("Initial customers added to the database.");
        }
        else {
            System.out.println("Database already initialized.");
        }
    }
}
