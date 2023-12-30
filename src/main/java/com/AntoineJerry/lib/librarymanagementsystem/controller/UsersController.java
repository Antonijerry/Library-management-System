package com.AntoineJerry.lib.librarymanagementsystem.controller;

import com.AntoineJerry.lib.librarymanagementsystem.model.Users;
import com.AntoineJerry.lib.librarymanagementsystem.service.UsersService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")

public class UsersController {

    private UsersService usersService;

    //add a user /end point
    @PostMapping("")
    public ResponseEntity<Users> addUser(@RequestBody @Valid Users users){
        return new ResponseEntity<>(usersService.saveUser(users), HttpStatus.CREATED);
    }

    //to delete a user by id /end point
    @DeleteMapping("/{id}")
    public ResponseEntity<Users>  deleteUserById(@PathVariable("id") int id){
        return ResponseEntity.ok(usersService.deleteUserById(id));
    }

    //to edit or update a user detail /end point
    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable("id") int id,
                             @Valid @RequestBody Users users){
        return ResponseEntity.ok(usersService.updateUser(id, users));
    }

    //get all users /end point
    @GetMapping("")
    public ResponseEntity<List<Users>> getAllUsers(){
        return new ResponseEntity<>(usersService.getAllUsers(), HttpStatus.OK);
    }

    //find a user by id /end point
    @GetMapping("/{id}")
    public Users findUsersById(@PathVariable("id") Integer id){
        return usersService.findUsersById(id);
    }

    //find a user by full name /end point
    @GetMapping("/fullName/{fullName}")
    public List<Users> findUserByFullName(@PathVariable("fullName") String fullName){
        return usersService.findUserByFullName(fullName);
    }

    //find a user by email /end point
    @GetMapping("/email/{email}")
    public List<Users> findUserByEmail(@PathVariable("email") String email){
        return usersService.findUserByEmail(email);
    }
}
