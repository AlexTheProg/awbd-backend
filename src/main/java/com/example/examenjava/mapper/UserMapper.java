package com.example.examenjava.mapper;

import com.example.examenjava.dto.userDtos.UserGetDTO;
import com.example.examenjava.dto.UserPostDTO;
import com.example.examenjava.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserGetDTO fromDomain(User user);
    User toDomain(UserGetDTO userPostDTO);

    UserPostDTO toDtoPost(User user);
    User toDomainPost(UserPostDTO request);

    UserGetDTO map(User user);
}
