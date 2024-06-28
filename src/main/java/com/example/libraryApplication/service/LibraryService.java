package com.example.libraryApplication.service;

import com.example.libraryApplication.Model.Book;
import com.example.libraryApplication.Model.Customer;
import com.example.libraryApplication.Model.Loan;
import com.example.libraryApplication.Repository.BookRepository;
import com.example.libraryApplication.Repository.CustomerRepository;
import com.example.libraryApplication.Repository.LoanRepository;
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
    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(String id) {
        return bookRepository.findById(id);
    }

    public Book updateBook(String id, Book updatedBook) {
        Optional<Book> existingBookOpt = bookRepository.findById(id);
        if (existingBookOpt.isPresent()) {
            Book existingBook = existingBookOpt.get();
            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setAuthor(updatedBook.getAuthor());
            return bookRepository.save(existingBook);
        } else {
            throw new RuntimeException("Book not found");
        }
    }

    public void deleteBook(String id) {
        bookRepository.deleteById(id);
    }

    // Customer methods
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(String id) {
        return customerRepository.findById(id);
    }

    public Customer updateCustomer(String id, Customer updatedCustomer) {
        Optional<Customer> existingCustomerOpt = customerRepository.findById(id);
        if (existingCustomerOpt.isPresent()) {
            Customer existingCustomer = existingCustomerOpt.get();
            existingCustomer.setName(updatedCustomer.getName());
            existingCustomer.setEmail(updatedCustomer.getEmail());
            return customerRepository.save(existingCustomer);
        } else {
            throw new RuntimeException("Customer not found");
        }
    }

    public void deleteCustomer(String id) {
        customerRepository.deleteById(id);
    }

    // Loan methods
    public Loan borrowBook(String bookId, String customerId) {
        Loan loan = new Loan();
        loan.setBookId(bookId);
        loan.setCustomerId(customerId);
        loan.setBorrowDate(new Date());
        return loanRepository.save(loan);
    }

    public Loan returnBook(String loanId) {
        Optional<Loan> loan = loanRepository.findById(loanId);
        if (loan.isPresent()) {
            Loan returnedLoan = loan.get();
            returnedLoan.setReturnDate(new Date());
            return loanRepository.save(returnedLoan);
        } else {
            throw new RuntimeException("Loan not found");
        }
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