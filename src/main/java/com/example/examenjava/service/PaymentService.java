package com.example.examenjava.service;

import com.example.examenjava.exception.PaymentAlreadyCancelledException;
import com.example.examenjava.exception.PaymentNotFoundException;
import com.example.examenjava.model.Payment;
import com.example.examenjava.model.Status;
import com.example.examenjava.model.User;
import com.example.examenjava.repository.PaymentRepository;
import com.example.examenjava.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepo;
    private final UserRepository userRepo;

    public PaymentService(PaymentRepository paymentRepo, UserRepository userRepo) {
        this.paymentRepo = paymentRepo;
        this.userRepo = userRepo;
    }

    public Payment addPayment(Payment payment){
        //wanted to add invalid type and status exceptions but ran out of time, only got to write them :sadFace

        return paymentRepo.save(payment);
    }

    public Payment cancelPayment(Long id){
        Payment existingPayment = paymentRepo.findById(id)
                .orElseThrow(PaymentNotFoundException::new);

        if(existingPayment.getStatus().toString().equals("CANCELLED")){
            throw new PaymentAlreadyCancelledException();
        }

        existingPayment.setStatus(Status.CANCELLED);
        return paymentRepo.save(existingPayment);
    }

    public List<Payment> get(String type, String status){
        if(type != null){
            if(status != null){
                return paymentRepo.findByTypeAndStatus(type, status); // we have both type and status
            }
            return paymentRepo.findByType(type); // we only have type, status is null from the request
        }

        if(status != null){
            return paymentRepo.findByStatus(status); //type is null
        }

        return paymentRepo.findAll();// both filtering options are null
    }

    public Payment updatePayment(Payment requestPayment, User requestUser, Long id){
        Payment existingPayment = paymentRepo.getById(id);
        User existingUser = userRepo.getById(existingPayment.getUser().getUserId());

        existingPayment.setStatus(requestPayment.getStatus());
        existingPayment.setType(requestPayment.getType());
        existingPayment.setAmount(requestPayment.getAmount());


        existingUser.setFirstName(requestUser.getFirstName());
        existingUser.setLastName(requestUser.getLastName());
        existingUser.setAge(requestUser.getAge());

        existingPayment.setUser(existingUser);

        paymentRepo.save(existingPayment);
        return existingPayment;
    }

    public void deletePayment(Long id){
        paymentRepo.deleteById(id);
    }

}
