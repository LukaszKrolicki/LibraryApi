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

    // Book endpoints
    @PostMapping("/addBook")
    public void addBook(@RequestBody Book book) {
        libraryService.saveBook(book);
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return libraryService.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public Optional<Book> getBookById(@PathVariable String id) {
        return libraryService.getBookById(id);
    }

    @PutMapping("/UpdateBook/{id}")
    public Book updateBook(@PathVariable String id, @RequestBody Book book) {
        return libraryService.updateBook(id, book);
    }

    @DeleteMapping("/DeleteBook/{id}")
    public void deleteBook(@PathVariable String id) {
        libraryService.deleteBook(id);
    }

    // Customer endpoints
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

    @PutMapping("/UpdateCustomer/{id}")
    public Customer updateCustomer(@PathVariable String id, @RequestBody Customer customer) {
        return libraryService.updateCustomer(id, customer);
    }

    @DeleteMapping("/DeleteCustomer/{id}")
    public void deleteCustomer(@PathVariable String id) {
        libraryService.deleteCustomer(id);
    }

    // Loan endpoints
    @PostMapping("/loans")
    public Loan borrowBook(@RequestParam String bookId, @RequestParam String customerId) {
        return libraryService.borrowBook(bookId, customerId);
    }

    @PostMapping("/loans/{loanId}/return")
    public Loan returnBook(@PathVariable String loanId) {
        return libraryService.returnBook(loanId);
    }
}