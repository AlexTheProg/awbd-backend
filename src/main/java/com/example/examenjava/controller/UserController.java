package com.example.examenjava.controller;

import com.example.examenjava.dto.UserPostDTO;
import com.example.examenjava.mapper.UserMapper;
import com.example.examenjava.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {
    private final UserService userService;
    private final UserMapper mapper;

    public UserController(UserService userService, UserMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

//    @GetMapping()
//    public ResponseEntity<List<UserPostDTO>> getAllUsers(){
//        return ResponseEntity.ok(userService.getAllUsers()
//                .stream()
//                .map(mapper::fromDomain)
//                .collect(Collectors.toList()));
//    }
}
