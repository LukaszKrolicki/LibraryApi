package com.example.libraryApplication.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "loans")
public class Loan {
    // Getters and Setters

    @Id
    private String id;
    private String bookId;
    private String customerId;
    private Date borrowDate;
    private Date returnDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getBookId() {
        return bookId;
    }
    public void setBookId(String bookId) {
        this.bookId = bookId;
    }
    public String getCustomerId() {
        return customerId;
    }
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
    public Date getBorrowDate() {
        return borrowDate;
    }
    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }
    public Date getReturnDate() {
        return returnDate;
    }
    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}