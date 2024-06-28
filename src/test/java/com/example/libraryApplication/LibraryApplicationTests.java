package com.example.libraryApplication;

import com.example.libraryApplication.Model.Book;
import com.example.libraryApplication.Model.Customer;
import com.example.libraryApplication.Model.Loan;
import com.example.libraryApplication.Repository.BookRepository;
import com.example.libraryApplication.Repository.CustomerRepository;
import com.example.libraryApplication.Repository.LoanRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataMongoTest
@Import(TestMongoConfig.class)
@ActiveProfiles("test")
public class LibraryApplicationTests {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private LoanRepository loanRepository;

    @BeforeEach
    void setUp() {
        bookRepository.deleteAll();
        customerRepository.deleteAll();
        loanRepository.deleteAll();
    }

    @Test
    void testAddBook() {
        // Create a new book
        Book book = new Book("x1", "x2", true);
        book.setTitle("Test Book");
        book.setAuthor("Test Author");

        // Save the book to the repository
        bookRepository.save(book);

        // Retrieve all books
        List<Book> books = bookRepository.findAll();

        // Verify the book was added
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getTitle()).isEqualTo("Test Book");
    }

    @Test
    void testAddCustomer() {
        // Create a new customer
        Customer customer = new Customer("John Doe", "john.doe@example.com");

        // Save the customer to the repository
        customerRepository.save(customer);

        // Retrieve all customers
        List<Customer> customers = customerRepository.findAll();

        // Verify the customer was added
        assertThat(customers).hasSize(1);
        assertThat(customers.get(0).getName()).isEqualTo("John Doe");
    }

    @Test
    void testGetAllBooks() {
        // Create a new book
        Book book = new Book("x1", "x2", true);
        book.setTitle("Test Book");
        book.setAuthor("Test Author");

        // Save the book to the repository
        bookRepository.save(book);

        // Retrieve all books
        List<Book> books = bookRepository.findAll();

        // Verify the book list contains the saved book
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getTitle()).isEqualTo("Test Book");
    }

    @Test
    void testGetBookById() {
        // Create a new book
        Book book = new Book("x1", "x2", true);
        book.setTitle("Test Book");
        book.setAuthor("Test Author");

        // Save the book to the repository
        book = bookRepository.save(book);

        // Retrieve the book by ID
        Optional<Book> retrievedBook = bookRepository.findById(book.getId());

        // Verify the book was retrieved
        assertThat(retrievedBook).isPresent();
        assertThat(retrievedBook.get().getTitle()).isEqualTo("Test Book");
    }

    @Test
    void testDeleteBook() {
        // Create a new book
        Book book = new Book("x1", "x2", true);
        book.setTitle("Test Book");
        book.setAuthor("Test Author");

        // Save the book to the repository
        book = bookRepository.save(book);

        // Delete the book
        bookRepository.deleteById(book.getId());

        // Verify the book was deleted
        Optional<Book> retrievedBook = bookRepository.findById(book.getId());
        assertThat(retrievedBook).isNotPresent();
    }

    @Test
    void testGetAllCustomers() {
        // Create a new customer
        Customer customer = new Customer("John Doe", "john.doe@example.com");

        // Save the customer to the repository
        customerRepository.save(customer);

        // Retrieve all customers
        List<Customer> customers = customerRepository.findAll();

        // Verify the customer list contains the saved customer
        assertThat(customers).hasSize(1);
        assertThat(customers.get(0).getName()).isEqualTo("John Doe");
    }

    @Test
    void testGetCustomerById() {
        // Create a new customer
        Customer customer = new Customer("John Doe", "john.doe@example.com");

        // Save the customer to the repository
        customer = customerRepository.save(customer);

        // Retrieve the customer by ID
        Optional<Customer> retrievedCustomer = customerRepository.findById(customer.getId());

        // Verify the customer was retrieved
        assertThat(retrievedCustomer).isPresent();
        assertThat(retrievedCustomer.get().getName()).isEqualTo("John Doe");
    }

    @Test
    void testDeleteCustomer() {
        // Create a new customer
        Customer customer = new Customer("John Doe", "john.doe@example.com");

        // Save the customer to the repository
        customer = customerRepository.save(customer);

        // Delete the customer
        customerRepository.deleteById(customer.getId());

        // Verify the customer was deleted
        Optional<Customer> retrievedCustomer = customerRepository.findById(customer.getId());
        assertThat(retrievedCustomer).isNotPresent();
    }

    @Test
    void testBorrowBook() {
        // Create a new book and customer
        Book book = new Book("x1", "x2", true);
        book.setTitle("Test Book");
        book.setAuthor("Test Author");
        book = bookRepository.save(book);

        Customer customer = new Customer("John Doe", "john.doe@example.com");
        customer = customerRepository.save(customer);

        // Borrow the book
        Loan loan = new Loan();
        loan.setBookId(book.getId());
        loan.setCustomerId(customer.getId());
        loan = loanRepository.save(loan);

        // Verify the loan was created
        List<Loan> loans = loanRepository.findAll();
        assertThat(loans).hasSize(1);
        assertThat(loans.get(0).getBookId()).isEqualTo(book.getId());
        assertThat(loans.get(0).getCustomerId()).isEqualTo(customer.getId());
    }

    @Test
    void testReturnBook() {
        // Create a new book and customer
        Book book = new Book("x1", "x2", true);
        book.setTitle("Test Book");
        book.setAuthor("Test Author");
        book = bookRepository.save(book);

        Customer customer = new Customer("John Doe", "john.doe@example.com");
        customer = customerRepository.save(customer);

        // Borrow the book
        Loan loan = new Loan();
        loan.setBookId(book.getId());
        loan.setCustomerId(customer.getId());
        loan = loanRepository.save(loan);

        // Return the book (delete the loan)
        loanRepository.deleteById(loan.getId());

        // Verify the loan was deleted
        Optional<Loan> retrievedLoan = loanRepository.findById(loan.getId());
        assertThat(retrievedLoan).isNotPresent();
    }
}