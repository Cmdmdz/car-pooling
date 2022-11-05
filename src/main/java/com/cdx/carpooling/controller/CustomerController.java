package com.cdx.carpooling.controller;

import com.cdx.carpooling.model.request.CustomerRequest;
import com.cdx.carpooling.model.request.SignInRequest;
import com.cdx.carpooling.model.response.CustomerResponse;
import com.cdx.carpooling.services.SignInService;
import com.cdx.carpooling.services.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class CustomerController {

    private final SignInService signInService;
    private final SignUpService signUpService;

    @PostMapping("signUp")
    public Mono<CustomerResponse> signUp(@Valid @RequestBody CustomerRequest request){
        return signUpService.execute(request);
    }

    @PostMapping("signIn")
    public Mono<CustomerResponse> signIn(@Valid @RequestBody SignInRequest request){
        return signInService.execute(request);

    }

}
