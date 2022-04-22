package com.example.examenjava.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AddPaymentRequestDTO {
    @NotBlank
    private String type;

    @NotBlank
    @Size(min = 1) //interpreted double positive value as strictly higher than 0, therefore min is 1
    private String amount;

    private UserDTO user;

    @NotBlank
    private String status;

    public AddPaymentRequestDTO() {
    }

    public AddPaymentRequestDTO(String type, String amount, String status) {
        this.type = type;
        this.amount = amount;
        this.status = status;
    }

    public AddPaymentRequestDTO(String type, String amount, UserDTO user, String status) {
        this.type = type;
        this.amount = amount;
        this.user = user;
        this.status = status;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO userDTO) {
        this.user = userDTO;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
