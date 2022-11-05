package com.cdx.carpooling.services;

import com.cdx.carpooling.model.request.CustomerRequest;
import com.cdx.carpooling.model.response.CustomerResponse;
import com.cdx.carpooling.repositories.CustomerRepository;
import com.cdx.carpooling.repositories.dao.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import static com.cdx.carpooling.constant.CustomerConstant.ERROR_CUSTOMER_DUPLICATE;

@Service
@RequiredArgsConstructor
public class SignUpService {

    private final CustomerRepository customerRepository;

    public Mono<CustomerResponse> execute(CustomerRequest request){

        return customerRepository.existsByEmail(request.getEmail())
                .flatMap(res -> {

                    if (Boolean.TRUE.equals(res)){
                        return Mono.error(new ResponseStatusException(HttpStatus.CONFLICT, ERROR_CUSTOMER_DUPLICATE));
                    }

                    return customerRepository.save(Customer.builder()
                                    .fistName(request.getFistName())
                                    .lastName(request.getLastName())
                                    .email(request.getEmail())
                                    .address(request.getAddress())
                                    .studentId(request.getStudentId())
                                    .password(request.getPassword())
                                    .build())
                            .flatMap(customer -> Mono.just(CustomerResponse.builder()
                                            .customerId(customer.getCustomerId())
                                            .password(customer.getPassword())
                                    .build()));
                });
    }

}
