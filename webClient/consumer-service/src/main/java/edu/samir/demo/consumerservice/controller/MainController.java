package edu.samir.demo.consumerservice.controller;

import edu.samir.demo.consumerservice.model.User;
import edu.samir.demo.consumerservice.service.ConsumeWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class MainController {

    private final ConsumeWebService webService;

    @Autowired
    public MainController(ConsumeWebService webService) {
        this.webService = webService;
    }

    public Mono<User> addUser(User user) {
        return webService.addUser(user);
    }

    public Mono<User> getUser(Long id) {
        return webService.get().uri("/user/{id}", id).retrieve().bodyToMono(User.class);
    }

    public Flux<User> getUsers() {
        return webService.get().uri("/users").retrieve().bodyToFlux(User.class);
    }

    public Mono<Void> deleteUser(Long id) {
        return webService.delete().uri("/delete/{id}", id)
                .retrieve().bodyToMono(Void.class);
    }

}
