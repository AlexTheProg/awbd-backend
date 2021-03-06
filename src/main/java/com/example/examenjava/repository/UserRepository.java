package com.example.examenjava.repository;

import com.example.examenjava.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByFirstName(String firstName);
    List<User> findByAge(Integer age);
}
