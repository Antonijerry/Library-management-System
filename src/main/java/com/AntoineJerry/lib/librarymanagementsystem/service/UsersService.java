package com.AntoineJerry.lib.librarymanagementsystem.service;

import com.AntoineJerry.lib.librarymanagementsystem.model.Users;

import java.util.List;

public interface UsersService {
   public Users saveUser(Users users);

   public List<Users> getAllUsers();

   public Users findUsersById(int id);

   public Users deleteUserById(int id);

   public String updateUser(int id, Users users);

   public List<Users> findUserByFullName(String fullName);

   public List<Users> findUserByEmail(String email);
}
