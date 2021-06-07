package edu.samir.demo.producerservice.service;

import edu.samir.demo.producerservice.entity.User;
import edu.samir.demo.producerservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class UserService {

    private final WebClient webClient;
    private final UserRepository userRepository;

    @Autowired
    public UserService(WebClient.Builder builder, UserRepository userRepository) {
        this.webClient = builder.baseUrl("").build();
        this.userRepository = userRepository;
    }

    public User addUser(User user) {
        userRepository.getUsers().add(user);
        return user;
    }

    public User getUser(Long id) {
        return userRepository.getUsers().get(id.intValue());
    }

    public List<User> getUsers() {
        return userRepository.getUsers();
    }

    public List<User> deleteUser(Long id) {
        userRepository.getUsers().remove(id.intValue());
        return userRepository.getUsers();
    }

}
