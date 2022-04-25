package com.example.examenjava.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class PutPostPaymentRequestDTO {
    private String id;
    @NotBlank
    private String type;

    @NotBlank
    @Size(min = 1) //interpreted double positive value as strictly higher than 0, therefore min is 1
    private String amount;

    private UserPostDTO user;

    @NotBlank
    private String status;



    public PutPostPaymentRequestDTO(String id, String type, String amount, UserPostDTO user, String status) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.user = user;
        this.status = status;
    }

    public UserPostDTO getUser() {
        return user;
    }

    public void setUser(UserPostDTO userPostDTO) {
        this.user = userPostDTO;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
