package com.example.examenjava.controller;
import com.example.examenjava.model.Payment;
import com.example.examenjava.model.Status;
import com.example.examenjava.model.Type;
import com.example.examenjava.repository.PaymentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;



@SpringBootTest
@AutoConfigureMockMvc
class PaymentControllerTest {

    @Autowired
    private MockMvc mvcMock;

    @Autowired
    private PaymentRepository paymentRepository;

    private Payment payment;

    @BeforeEach
    void setUp() {
         payment = new Payment(1L, Type.ONLINE, 100d, Status.NEW, null);
    }

    @Test
    void addPayment() {
    }

    @Test
    void updatePayment() {
    }

    @Test
    void cancelPayment() {
    }

    @Test
    void deletePayment() {
    }

    @Test
    void getPayment() throws Exception {
        mvcMock.perform(get("/payments")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("[0].id").value(1L))
                .andReturn();
    }
}