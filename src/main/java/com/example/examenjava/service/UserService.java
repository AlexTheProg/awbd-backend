package com.example.examenjava.service;

import com.example.examenjava.model.User;
import com.example.examenjava.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {
    private final UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    public List<User> getByFirstName(String firstName){
        return userRepo.findByFirstName(firstName);
    }

    public List<User> getByAge(String age){
        return userRepo.findByAge(Integer.parseInt(age));
    }

    public User getById(Long id){
        return userRepo.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Transactional
    public void saveUser(User user){
        userRepo.save(user);
    }
}
