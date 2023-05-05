package ru.mvc_hiber.service;


import ru.mvc_hiber.model.User;

import java.util.List;

public interface UserService {

    void add(User user);

    List<User> listUsers();

    User findUserById(Long id);

    void deleteUserById(Long id);

    void updateUser(User user);

}
