package ru.mvc_hiber.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.mvc_hiber.model.User;
import ru.mvc_hiber.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = {"/", "/users"})
    public String printWelcome(ModelMap model, @ModelAttribute(name = "newUser") User newUser) {
        model.addAttribute("users", userService.listUsers());
        return "index";
    }

    @PostMapping(value = "users/delete/{id}")
    public String deleteUser(ModelMap model, @PathVariable("id") long id) {
        userService.deleteUserById(id);
        model.addAttribute("users", userService.listUsers());
        return "redirect:/users";
    }

    @GetMapping(value = "users/edit/{id}")
    public String getUser(ModelMap model, @PathVariable("id") long id) {
        model.addAttribute("user", userService.findUserById(id));
        return "user-edit";
    }

    @PostMapping(value = "users/edit/{id}")
    public String editUser(ModelMap model, @ModelAttribute("user") User user) {
        userService.updateUser(user);
        model.addAttribute("users", userService.listUsers());
        return "redirect:/users";
    }

    @PostMapping(value = "users/create")
    public String createUser(ModelMap model, @ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/users";
    }
}