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

import static com.cdx.carpooling.constant.CustomerConstant.ERROR_NOT_FOUND_STUDENT_ID;

@RequiredArgsConstructor
@Service
public class EdiCustomerService {

    private final CustomerRepository customerRepository;

    public Mono<CustomerResponse> execute(CustomerRequest request) {

        return customerRepository.findById(request.getStudentId())
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, ERROR_NOT_FOUND_STUDENT_ID)))
                .flatMap(customer ->
                        customerRepository.save(Customer.builder()
                                        .studentId(request.getStudentId())
                                        .address(request.getAddress())
                                        .email(request.getEmail())
                                        .name(request.getName())
                                        .password(customer.getPassword())
                                        .mobileNumber(request.getMobileNumber())
                                        .isDiver(request.getIsDiver())

                                        .build())
                                .then(Mono.just(CustomerResponse.builder().build()))
                );
    }
}
