package com.example.examenjava.mapper;

import com.example.examenjava.dto.UserPostDTO;
import com.example.examenjava.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserPostDTO fromDomain(User user);
    User toDomain(UserPostDTO userPostDTO);
}
