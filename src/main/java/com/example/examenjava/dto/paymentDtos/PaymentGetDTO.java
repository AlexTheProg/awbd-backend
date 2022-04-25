package com.example.examenjava.dto.paymentDtos;

import com.example.examenjava.dto.userDtos.UserGetDTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class PaymentGetDTO {

    private String id;

    @NotBlank
    private String type;

    @NotBlank
    @Size(min = 1) //interpreted double positive value as strictly higher than 0, therefore min is 1
    private String amount;

    @NotBlank
    private String status;

    private UserGetDTO user;

    public PaymentGetDTO(String id, String type, String amount, String status, UserGetDTO user) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.status = status;
        this.user = user;
    }

    public PaymentGetDTO() {
    }

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UserGetDTO getUser() {
        return user;
    }

    public void setUser(UserGetDTO user) {
        this.user = user;
    }
}
