package ru.mvc_hiber.dao;


import ru.mvc_hiber.model.User;

import java.util.List;

public interface UserDao {

    void add(User user);

    List<User> listUsers();

    User findById(Long id);

    User update(User user);

    void deleteUser(User user);

}
