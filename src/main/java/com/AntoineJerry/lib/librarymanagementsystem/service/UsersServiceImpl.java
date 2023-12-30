package com.AntoineJerry.lib.librarymanagementsystem.service;

import com.AntoineJerry.lib.librarymanagementsystem.model.Users;
import com.AntoineJerry.lib.librarymanagementsystem.repository.UsersRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UsersServiceImpl implements UsersService{

    private UsersRepository usersRepository;

    @Override
    @CacheEvict(value = "allUsers", allEntries = true)
    public Users saveUser(Users users) {
        return usersRepository.save(users);
    }

    @Override
    @Cacheable("allUsers")
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public Users findUsersById(int id) {
        return usersRepository.findById(id).get();
    }

    @Override
    @CacheEvict(value ="allUsers", allEntries = true)
    public Users deleteUserById(int id) {
        Users users = findUsersById(id);
        usersRepository.deleteById(id);
        return users;
    }

    @Override
    @CacheEvict(value ="allUsers", allEntries = true)
    public String updateUser(int id, Users users) {
        Users toUpdateDetail = findUsersById(id);
        toUpdateDetail.setFullName(users.getFullName());
        toUpdateDetail.setAge(users.getAge());
        toUpdateDetail.setAddress(users.getAddress());
        toUpdateDetail.setEmail(users.getEmail());
        usersRepository.save(toUpdateDetail);
        return "users details updated successfully";

                        //or
//        Users toUpdateDetail = usersRepository.findById(id).get();
//        if(Objects.nonNull(users.getFullName()) && !"".equalsIgnoreCase(users.getFullName())){
//            toUpdateDetail.setFullName(users.getFullName());
//        }
        //return usersRepository.save(toUpdateDetail);


    }

    @Override
    public List<Users> findUserByFullName(String fullName) {
        return usersRepository.findByFullNameIgnoreCase(fullName);
    }

    @Override
    public List<Users> findUserByEmail(String email) {
        return usersRepository.findByEmail(email);
    }

}
