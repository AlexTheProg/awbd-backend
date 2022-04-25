package com.example.examenjava.dto.paymentDtos;

import com.example.examenjava.dto.UserPostDTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class PaymentPostDTO {
    @NotBlank
    private String type;

    @NotBlank
    @Size(min = 1) //interpreted double positive value as strictly higher than 0, therefore min is 1
    private String amount;

    private UserPostDTO user;

    @NotBlank
    private String status;

    public PaymentPostDTO(String type, String amount, UserPostDTO user, String status) {
        this.type = type;
        this.amount = amount;
        this.user = user;
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public UserPostDTO getUser() {
        return user;
    }

    public void setUser(UserPostDTO user) {
        this.user = user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
