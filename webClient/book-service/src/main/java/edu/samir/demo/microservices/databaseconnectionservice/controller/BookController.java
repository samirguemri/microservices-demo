package edu.samir.demo.microservices.databaseconnectionservice.controller;

import edu.samir.demo.microservices.databaseconnectionservice.model.Book;
import edu.samir.demo.microservices.databaseconnectionservice.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/book")
public class BookController {

    private final BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping(path = "/{isbn}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<Book> getBookById(@PathVariable String isbn) {
        return bookRepository.findById(isbn);
    }

    @GetMapping(path = "/all", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @PostMapping("/add")
    public Mono<Book> getBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @DeleteMapping("/deleteAll")
    public Mono<Void> deleteAllBooks() {
        return bookRepository.deleteAll();
    }

}
