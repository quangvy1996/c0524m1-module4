package com.example.security.service;

import com.example.security.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    public List<User> getAllUsers();
    public Optional<User> getUserById(Long id);
    public User getUserByUsername(String username);
    public User saveUser(User user);
    public void deleteUserById(Long id);
}
