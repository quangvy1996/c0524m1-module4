package com.example.validation.service;

import com.example.validation.model.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IUserService {
        List<User> findAll();
        void save(User user);
}
