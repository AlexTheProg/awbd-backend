package com.example.examenjava.mapper;

import com.example.examenjava.dto.PutPostPaymentRequestDTO;
import com.example.examenjava.dto.PaymentGetDTO;
import com.example.examenjava.model.Payment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
//mvn clean install necessary to generate the mapper implementation in target -> generated sources -> annotations
    //may need to reload project so that the spring context can see the @Component mapper implementation that was auto generated
    Payment fromPaymentRequestDTO(PutPostPaymentRequestDTO request);

    PaymentGetDTO paymentToPaymentGetDto(Payment payment);

}
