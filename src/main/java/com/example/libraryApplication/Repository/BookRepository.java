package com.example.libraryApplication.Repository;

import com.example.libraryApplication.Model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String> {
}