package edu.samir.demo.microservices.databaseconnectionservice.repository;

import edu.samir.demo.microservices.databaseconnectionservice.model.Book;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends ReactiveMongoRepository<Book, String> {
}
