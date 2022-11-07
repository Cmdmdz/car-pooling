package com.cdx.carpooling.services;

import com.cdx.carpooling.model.request.SignInRequest;
import com.cdx.carpooling.model.response.CustomerResponse;
import com.cdx.carpooling.model.response.SignInResponse;
import com.cdx.carpooling.repositories.CustomerRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import java.security.SecureRandom;
import java.util.Base64;

import static com.cdx.carpooling.constant.CustomerConstant.ERROR_CUSTOMER_VERIFY;

@Service
@RequiredArgsConstructor
public class SignInService {

    private final CustomerRepository customerRepository;

    private static final SecureRandom SECURE_RANDOM = new SecureRandom();
    private static final Base64.Encoder ENCODER = Base64.getUrlEncoder();

    public Mono<SignInResponse> execute(SignInRequest request){

        return customerRepository.existsByStudentIdAndPassword(request.getStudentId(),
                        request.getPassword())
                .flatMap(res -> {
                    byte[] TOKEN = new byte[24];
                    SECURE_RANDOM.nextBytes(TOKEN);

                    if (!Boolean.TRUE.equals(res)){
                        return Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, ERROR_CUSTOMER_VERIFY));
                    }

                    return customerRepository.findByStudentId(request.getStudentId())
                            .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ERROR_CUSTOMER_VERIFY)))
                            .flatMap(customer -> Mono.just(SignInResponse.builder()
                                            .studentId(customer.getStudentId())
                                            .isDiver(customer.getIsDiver())
                                            .auth(ENCODER.encodeToString(TOKEN))
                                    .build()));
                });
    }
}
