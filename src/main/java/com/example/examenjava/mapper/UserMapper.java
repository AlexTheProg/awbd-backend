package com.example.examenjava.mapper;

import com.example.examenjava.dto.UserDTO;
import com.example.examenjava.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO fromDomain(User user);
    User toDomain(UserDTO userDTO);
}
