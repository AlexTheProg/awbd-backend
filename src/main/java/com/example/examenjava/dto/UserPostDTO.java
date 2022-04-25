package com.example.examenjava.dto;

import javax.validation.constraints.NotBlank;

public class UserPostDTO {
    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    private String age;

    public UserPostDTO(String id, String firstName, String lastName, String age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public UserPostDTO() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
