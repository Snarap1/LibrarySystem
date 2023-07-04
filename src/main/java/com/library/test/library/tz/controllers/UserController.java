package com.library.test.library.tz.controllers;

import com.library.test.library.tz.models.User;
import com.library.test.library.tz.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;

@RestController
@RequestMapping("/users")
public class UserController {

    private  final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody User user){
        userService.addUser(user);
        return  ResponseEntity.ok("User created");
    }

    @PatchMapping("/{userId}")
    public  ResponseEntity<?> updateUser(@PathVariable int userId,@RequestBody User user){
        userService.updateUser(userId,user);
        return ResponseEntity.ok("User updated");
    }

    @DeleteMapping("/{userId}")
    public  ResponseEntity<?> deleteUser(@PathVariable int userId){
        userService.deleteUser(userId);
        return  ResponseEntity.ok("user removed");
    }

    @PostMapping("/buySub/{userId}")
    public  ResponseEntity<?> buySubscription(@PathVariable int userId){
        userService.set_sub(userId);
        return ResponseEntity.ok("U got subscription");
    }

    @GetMapping("/users")
    public  ResponseEntity<?> getUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{userId}")
    public  ResponseEntity<?> getUser(@PathVariable int userId){
        return ResponseEntity.ok(userService.getUserById(userId));
    }



}
