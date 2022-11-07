package com.cdx.carpooling.services;

import com.cdx.carpooling.model.request.SignInRequest;
import com.cdx.carpooling.model.response.CustomerResponse;
import com.cdx.carpooling.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import static com.cdx.carpooling.constant.CustomerConstant.ERROR_CUSTOMER_VERIFY;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Mono<CustomerResponse> execute(String studentId) {
        return customerRepository.findByStudentId(studentId)
                .flatMap(res -> Mono.just(CustomerResponse.builder()
                        .email(res.getEmail())
                        .address(res.getAddress())
                        .name(res.getName())
                        .isDiver(res.getIsDiver())
                        .studentId(res.getStudentId())
                        .mobileNumber(res.getMobileNumber())
                        .build()));
    }
}
