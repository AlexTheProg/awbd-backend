package com.example.examenjava.dto;

import javax.validation.constraints.NotBlank;

public class UserGetDTO {
    private String id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    private String age;
}
