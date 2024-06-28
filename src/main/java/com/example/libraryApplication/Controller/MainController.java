package com.example.libraryApplication.Controller;

import com.example.libraryApplication.Model.Book;
import com.example.libraryApplication.Model.Customer;
import com.example.libraryApplication.Model.Loan;
import com.example.libraryApplication.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    private LibraryService libraryService;

    @PostMapping("/addBook")
    public Book addBook(@RequestBody Book book) {
        return libraryService.saveBook(book);
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return libraryService.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public Optional<Book> getBookById(@PathVariable String id) {
        return libraryService.getBookById(id);
    }

    @DeleteMapping("/DeleteBook/{id}")
    public void deleteBook(@PathVariable String id) {
        libraryService.deleteBook(id);
    }

    @PutMapping("/books/{id}")
    public Book updateBook(@PathVariable String id, @RequestBody Book updatedBook) {
        return libraryService.updateBook(id, updatedBook);
    }

    @PostMapping("/AddCustomer")
    public Customer addCustomer(@RequestBody Customer customer) {
        return libraryService.saveCustomer(customer);
    }

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return libraryService.getAllCustomers();
    }

    @GetMapping("/customers/{id}")
    public Optional<Customer> getCustomerById(@PathVariable String id) {
        return libraryService.getCustomerById(id);
    }

    @DeleteMapping("/DeleteCustomer/{id}")
    public void deleteCustomer(@PathVariable String id) {
        libraryService.deleteCustomer(id);
    }

    @PutMapping("/customers/{id}")
    public Customer updateCustomer(@PathVariable String id, @RequestBody Customer updatedCustomer) {
        return libraryService.updateCustomer(id, updatedCustomer);
    }

    @PostMapping("/loans")
    public Loan borrowBook(@RequestParam String bookId, @RequestParam String customerId) {
        return libraryService.borrowBook(bookId, customerId);
    }

    @PostMapping("/loans/{loanId}/return")
    public Loan returnBook(@PathVariable String loanId) {
        return libraryService.returnBook(loanId);
    }
}