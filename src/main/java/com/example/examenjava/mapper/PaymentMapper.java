package com.example.examenjava.mapper;

import com.example.examenjava.dto.PutPostPaymentRequestDTO;
import com.example.examenjava.dto.paymentDtos.PaymentGetDTO;
import com.example.examenjava.dto.paymentDtos.PaymentPostDTO;
import com.example.examenjava.dto.userDtos.UserGetDTO;
import com.example.examenjava.model.Payment;
import com.example.examenjava.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {})
public interface PaymentMapper {
//mvn clean install necessary to generate the mapper implementation in target -> generated sources -> annotations
    //may need to reload project so that the spring context can see the @Component mapper implementation that was auto generated

    PaymentMapper INSTANCE = Mappers.getMapper(PaymentMapper.class);

    @Mapping(source = "user.userId", target = "user.id")
    PaymentGetDTO mapToDto(Payment payment);

    Payment mapToDomain(PaymentGetDTO request);

    PutPostPaymentRequestDTO mapToDtoPutPost(Payment payment);

    Payment mapToDomainPutPost(PutPostPaymentRequestDTO request);

    PaymentPostDTO mapToPostDto(Payment payment);

    Payment mapToPayment(PaymentPostDTO request);


}
