package com.giantmachines.library.controller;

import com.giantmachines.library.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping ("/users")
public class UserController {

    private Map <Integer, User> userMap = new HashMap<>();
    private Integer counter = 0;

    @PostMapping
    public void addUser(@RequestBody User user){
        userMap.put(++counter, user);
    }

    @GetMapping
    public Set<Map.Entry<Integer, User>> getAllUser(){
        return userMap.entrySet();
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Integer userId){
        return userMap.get(userId);
    }

}
