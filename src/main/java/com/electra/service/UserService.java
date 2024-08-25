package com.electra.service;

import com.electra.model.User;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    private List<User> users = new ArrayList<>();

    // Add a new user
    public void addUser(User user) {
        users.add(user);
    }

    // Get a user by ID
    public User getUserById(int id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Get all users
    public List<User> getAllUsers() {
        return users;
    }

    // Update an existing user
    public void updateUser(User user) {
        User existingUser = getUserById(user.getId());
        if (existingUser != null) {
            existingUser.setName(user.getName());
            existingUser.setEmail(user.getEmail());
        }
    }

    // Delete a user by ID
    public void deleteUser(int id) {
        users.removeIf(user -> user.getId() == id);
    }
}
