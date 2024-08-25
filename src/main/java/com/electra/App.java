package com.electra;

import com.electra.model.User;
import com.electra.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        UserService userService = (UserService) context.getBean("UserService");

        // Adding users
        userService.addUser(new User(1, "Name1", "name1@example.com"));
        userService.addUser(new User(2, "Name2", "name2@example.com"));

        // Retrieving a user
        User user = userService.getUserById(1);
        System.out.println("Retrieved User: " + user);

        // Updating a user
        userService.updateUser(new User(1, "Name3", "name3@example.com"));
        System.out.println("Updated User: " + userService.getUserById(1));

        // Deleting a user
        userService.deleteUser(2);
        System.out.println("All Users: " + userService.getAllUsers());
    }
}
