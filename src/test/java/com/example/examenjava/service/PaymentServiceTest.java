package com.example.examenjava.service;

import com.example.examenjava.exception.PaymentAlreadyCancelledException;
import com.example.examenjava.exception.PaymentNotFoundException;
import com.example.examenjava.mapper.PaymentMapper;
import com.example.examenjava.model.Payment;
import com.example.examenjava.model.Status;
import com.example.examenjava.model.Type;
import com.example.examenjava.model.User;
import com.example.examenjava.repository.PaymentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PaymentServiceTest {

    @Mock
    PaymentRepository repo;

    @InjectMocks
    PaymentService sut;

    private Payment payment;

    @BeforeEach
    private void setUp(){payment = new Payment(1L, Type.POS, 200d, Status.NEW);}

    @Test
    void addPayment() {
        //arrange
        when(repo.save(payment)).thenReturn(payment);

        //act
        Payment savedPayment = sut.addPayment(payment);

        //assertions
        assertEquals(savedPayment, payment);
    }

    @Test
    void cancelPayment() {
        //arrange
        when(repo.findById(payment.getId())).thenReturn(java.util.Optional.ofNullable(payment));
        when(repo.save(payment)).thenReturn(payment);

        //act
        Payment cancelledPayment = sut.cancelPayment(payment.getId());

        //assertions
        assertEquals(cancelledPayment.getStatus(), Status.CANCELLED);

    }

    @Test
    void findByStatus(){
        //arrange
        when(repo.findByStatus(payment.getStatus().name())).thenReturn(List.of(payment));

        //act
        List<Payment> paymentList = sut.get(null, payment.getStatus().name());

        //assert
        assertNotNull(paymentList);
        assertEquals(1, paymentList.size());
        assertEquals(payment, paymentList.get(0));
    }

    @Test
    void findByType(){
        //arrange
        when(repo.findByType(payment.getType().name())).thenReturn(List.of(payment));

        //act
        List<Payment> paymentList = sut.get(payment.getType().name(), null);

        //assert
        assertNotNull(paymentList);
        assertEquals(1, paymentList.size());
        assertEquals(payment, paymentList.get(0));
    }

    @Test
    void getWhenTypeAndStatusNull() {
        //arrange
        when(repo.findAll()).thenReturn(List.of(payment));

        List<Payment> paymentList = sut.get(null, null);

        assertNotNull(paymentList);
        assertEquals(1, paymentList.size());
        assertEquals(payment, paymentList.get(0));
    }

    @Test
    void get(){
        when(repo.findByTypeAndStatus(payment.getType().name(), payment.getStatus().name())).thenReturn(List.of(payment));

        List<Payment> paymentList = sut.get(payment.getType().name(), payment.getStatus().name());
        assertNotNull(paymentList);
        assertEquals(1, paymentList.size());
        assertEquals(payment, paymentList.get(0));
    }

    @Test
    void shouldThrowPaymentNotFound(){
        when(repo.findById(payment.getId())).thenReturn(Optional.empty());

        assertThrows(PaymentNotFoundException.class,
                () -> sut.cancelPayment(payment.getId()));

    }

    @Test
    void shouldThrowPaymentAlreadyCancelled(){
        when(repo.findById(payment.getId())).thenReturn(Optional.of(payment));
        payment.setStatus(Status.CANCELLED);
        assertThrows(PaymentAlreadyCancelledException.class,
                () -> sut.cancelPayment(payment.getId()));
    }
}