package edu.samir.demo.consumerservice.service;

import edu.samir.demo.consumerservice.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ConsumeWebService {

    private final WebClient webClient;
    @Value("${services.producer.baseUrl}")
    private String producerService;

    public ConsumeWebService(WebClient.Builder builder) {
        this.webClient = builder.baseUrl(producerService).build();
    }

    public Mono<User> addUser(User user) {
        return webClient.post().uri("/add", user).retrieve().bodyToMono(User.class);
    }

    public Mono<User> getUser(Long id) {
        return webClient.get().uri("/user/{id}", id).retrieve().bodyToMono(User.class);
    }

    public Flux<User> getUsers() {
        return webClient.get().uri("/users").retrieve().bodyToFlux(User.class);
    }

    public Mono<Void> deleteUser(Long id) {
        return webClient.delete().uri("/delete/{id}", id)
                .retrieve().bodyToMono(Void.class);
    }
}
