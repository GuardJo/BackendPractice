package org.example.mvc.repository;

import org.example.mvc.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserRepository {
    private final static Map<String, User> users = new HashMap<>();

    public static void saveUser(User user) {
        users.put(user.getUserId(), user);
    }

    public static User findUser(String userId) {
        return users.get(userId);
    }

    public static List<User> findAll() {
        return users.values().stream().collect(Collectors.toList());
    }
}