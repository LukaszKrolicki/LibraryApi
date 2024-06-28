package com.example.libraryApplication.Repository;

import com.example.libraryApplication.Model.Loan;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LoanRepository extends MongoRepository<Loan, String> {
}