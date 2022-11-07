package com.cdx.carpooling.controller;

import com.cdx.carpooling.model.request.CustomerRequest;
import com.cdx.carpooling.model.request.SignInRequest;
import com.cdx.carpooling.model.request.SignUpRequest;
import com.cdx.carpooling.model.response.CustomerResponse;
import com.cdx.carpooling.model.response.SignInResponse;
import com.cdx.carpooling.services.CustomerService;
import com.cdx.carpooling.services.EdiCustomerService;
import com.cdx.carpooling.services.SignInService;
import com.cdx.carpooling.services.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class CustomerController {

    private final SignInService signInService;
    private final SignUpService signUpService;

    private final CustomerService customerService;

    private final EdiCustomerService ediCustomerService;

    @PostMapping("register")
    public Mono<CustomerResponse> signUp(@Valid @RequestBody SignUpRequest request){
        return signUpService.execute(request);
    }

    @PostMapping("login")
    public Mono<SignInResponse> signIn(@Valid @RequestBody SignInRequest request){
        return signInService.execute(request);

    }
    @GetMapping("get/{studentId}")
    public Mono<CustomerResponse> findCustomerById(@PathVariable String studentId){
        return customerService.execute(studentId);

    }
    @PutMapping("update")
    public Mono<CustomerResponse> updateCustomer(@Valid @RequestBody CustomerRequest request){
        return ediCustomerService.execute(request);
    }

}
