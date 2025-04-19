package com.mtech.project.controller;

import com.mtech.project.entity.UserModel;
import com.mtech.project.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository repo;

    public UserController(UserRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<UserModel> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public UserModel addUser(@RequestBody UserModel userModel) {
        return repo.save(userModel);
    }
}
