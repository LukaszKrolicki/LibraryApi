package com.example.libraryApplication.Repository;

import com.example.libraryApplication.Model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {
}