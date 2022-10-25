package com.project.questapp.controllers;

import com.project.questapp.entities.User;
import com.project.questapp.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")//main mapping for class
public class UserController {

    //Dependency Injection
    private UserService userService;// connection to Service

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping
    public User createUser(@RequestBody User newUser){
        if(newUser ==null){
            User fail=new User();
            fail.setUserName("user null geldi");
            return fail;
        }
        return userService.SaveOneUser(newUser);
    }

    @GetMapping("/{userId}")
    public User getOneUser(@PathVariable Long userId){
        //custom exception  //findById return optional
        return userService.getOneUserById(userId);
    }

    @PutMapping("/{userId}")
    public User updateOneUser(@PathVariable Long userId,@RequestBody User newUser){
        return userService.updateOneUser(userId,newUser);
    }
    @DeleteMapping("/{userId}")
    public void deleteOneUser (@PathVariable Long userId){
        userService.deleteOneUser(userId);
    }



}
