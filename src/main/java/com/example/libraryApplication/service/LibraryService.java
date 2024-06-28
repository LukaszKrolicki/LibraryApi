package com.example.libraryApplication.service;

import com.example.libraryApplication.Model.Book;
import com.example.libraryApplication.Model.Customer;
import com.example.libraryApplication.Model.Loan;
import com.example.libraryApplication.Repository.BookRepository;
import com.example.libraryApplication.Repository.CustomerRepository;
import com.example.libraryApplication.Repository.LoanRepository;
import com.example.libraryApplication.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private LoanRepository loanRepository;

    // Book methods
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(String id) {
        return Optional.ofNullable(bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found with id " + id)));
    }

    public void deleteBook(String id) {
        bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found with id " + id));
        bookRepository.deleteById(id);
    }

    public Book updateBook(String id, Book updatedBook) {
        Book existingBook = bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found with id " + id));
        existingBook.setTitle(updatedBook.getTitle());
        existingBook.setAuthor(updatedBook.getAuthor());
        existingBook.setBorrowed(updatedBook.isBorrowed());
        return bookRepository.save(existingBook);
    }

    // Customer methods
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(String id) {
        return Optional.ofNullable(customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer not found with id " + id)));
    }

    public void deleteCustomer(String id) {
        customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer not found with id " + id));
        customerRepository.deleteById(id);
    }

    public Customer updateCustomer(String id, Customer updatedCustomer) {
        Customer existingCustomer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer not found with id " + id));
        existingCustomer.setName(updatedCustomer.getName());
        existingCustomer.setEmail(updatedCustomer.getEmail());
        return customerRepository.save(existingCustomer);
    }

    // Loan methods
    public Loan borrowBook(String bookId, String customerId) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new ResourceNotFoundException("Book not found with id " + bookId));
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new ResourceNotFoundException("Customer not found with id " + customerId));
        Loan loan = new Loan();
        loan.setBookId(bookId);
        loan.setCustomerId(customerId);
        return loanRepository.save(loan);
    }

    public Loan returnBook(String loanId) {
        Loan loan = loanRepository.findById(loanId).orElseThrow(() -> new ResourceNotFoundException("Loan not found with id " + loanId));
        loanRepository.deleteById(loanId);
        return loan;
    }

    public BookRepository getBookRepository() {
        return bookRepository;
    }

    public CustomerRepository getCustomerRepository() {
        return customerRepository;
    }

    public LoanRepository getLoanRepository() {
        return loanRepository;
    }
}