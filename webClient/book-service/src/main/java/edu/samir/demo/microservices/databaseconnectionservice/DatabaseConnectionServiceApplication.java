package edu.samir.demo.microservices.databaseconnectionservice;

import edu.samir.demo.microservices.databaseconnectionservice.model.Book;
import edu.samir.demo.microservices.databaseconnectionservice.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class DatabaseConnectionServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatabaseConnectionServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(BookRepository repository) {
        return args -> {
            List<Book> books =  Arrays.asList(
                    new Book(1L, "978-0132350884", "Clean Code: A Handbook of Agile Software Craftsmanship", "Robert C. Martin"),
                    new Book(2L, "978-0201633610", "Design Patterns: Elements of Reusable Object-Oriented Software", "Erich Gamma"),
                    new Book(3L, "978-1484261309", "Learn Microservices with Spring Boot: A Practical Approach to RESTful Services Using an Event-Driven Architecture, Cloud-Native Patterns, and Containerization", "Moisés Macero García"),
                    new Book(4L, "978-1484250945", "Solving Identity Management in Modern Applications: Demystifying OAuth 2.0, OpenID Connect, and SAML", "Yvonne Wilson")
            );
            repository.saveAll(books);
        };
    }

}
