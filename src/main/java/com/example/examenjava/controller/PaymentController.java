package com.example.examenjava.controller;

import com.example.examenjava.dto.PutPostPaymentRequestDTO;
import com.example.examenjava.dto.PaymentGetDTO;
import com.example.examenjava.mapper.PaymentMapper;
import com.example.examenjava.mapper.UserMapper;
import com.example.examenjava.model.Payment;
import com.example.examenjava.service.PaymentService;
import com.example.examenjava.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private final PaymentService paymentService;
    private final UserService userService;
    private final PaymentMapper mapper;
    private final UserMapper userMapper;

    public PaymentController(PaymentService paymentService, UserService userService,
                             PaymentMapper mapper, UserMapper userMapper) {
        this.paymentService = paymentService;
        this.userService = userService;
        this.userMapper = userMapper;
        this.mapper = mapper;
    }

    @PostMapping()
    public ResponseEntity<Void> addPayment(@RequestBody @Valid PutPostPaymentRequestDTO request){
        userService.saveUser(userMapper.toDomain(request.getUser()));
        paymentService.addPayment(mapper.fromPaymentRequestDTO(request));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<PutPostPaymentRequestDTO> updatePayment(@RequestBody @Valid PutPostPaymentRequestDTO request){
        userService.saveUser(userMapper.toDomain(request.getUser()));
        paymentService.addPayment(mapper.fromPaymentRequestDTO(request));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/cancel/{id}")
    public ResponseEntity<Payment> cancelPayment(@PathVariable("id") Long id){
        return ResponseEntity.ok(paymentService.cancelPayment(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePayment(@PathVariable("id") Long id){
        paymentService.deletePayment(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping()
    @CrossOrigin(origins = "http://localhost:4200")
    public List<PaymentGetDTO> getPayment(@RequestParam(required = false) String status,
                                          @RequestParam(required = false) String type){
        return paymentService.get(status, type).stream().map(mapper::paymentToPaymentGetDto).collect(Collectors.toList());
    }


}
