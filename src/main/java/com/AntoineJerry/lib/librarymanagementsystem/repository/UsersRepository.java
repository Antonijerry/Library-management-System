package com.AntoineJerry.lib.librarymanagementsystem.repository;

import com.AntoineJerry.lib.librarymanagementsystem.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer>{

    //created a repo fxn to handle findByFullName which is not found in jpa repo
    public List<Users> findByFullNameIgnoreCase(String fullName);

    //created a repo fxn to handle findByEmail which is not found in jpa repo
    public List<Users> findByEmail(String email);
}
