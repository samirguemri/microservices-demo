package edu.samir.demo.producerservice.repository;

import edu.samir.demo.producerservice.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    private final List<User> users = new ArrayList<User>() {
        {
            add(new User("Sam", "Guemri"));
            add(new User("Zen", "Guemri"));
        }
    };

    public List<User> getUsers() {
        return users;
    }
}
