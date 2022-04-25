package com.example.examenjava.dto.userDtos;

import javax.validation.constraints.NotBlank;

public class UserGetDTO {

    private String id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    private String age;

    private String role;

    public UserGetDTO(String id, String firstName, String lastName, String age, String role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
