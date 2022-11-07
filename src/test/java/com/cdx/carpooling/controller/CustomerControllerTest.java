package com.cdx.carpooling.controller;

import com.cdx.carpooling.config.GlobalExceptionHandler;
import com.cdx.carpooling.model.request.SignInRequest;
import com.cdx.carpooling.model.response.SignInResponse;
import com.cdx.carpooling.repositories.CustomerRepository;
import com.cdx.carpooling.repositories.dao.Customer;
import com.cdx.carpooling.services.CustomerService;
import com.cdx.carpooling.services.EdiCustomerService;
import com.cdx.carpooling.services.SignInService;
import com.cdx.carpooling.services.SignUpService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.invocation.InvocationOnMock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = CustomerController.class)
@Import(SignInService.class)

class CustomerControllerTest {

    @Autowired
    private WebTestClient webClient;

    @MockBean
    private GlobalExceptionHandler globalExceptionHandler;

    @MockBean
    private  SignUpService signUpService;

    @MockBean
    private  CustomerService customerService;

    @MockBean
    private  EdiCustomerService ediCustomerService;

    @MockBean
    private CustomerRepository customerRepository;


    @Test
    public void whenSignIn_shouldBeReturnSignInResponse() {

        given(customerRepository.existsByStudentIdAndPassword(anyString(),anyString()))
                .willReturn(Mono.just(true));

        given(customerRepository.findByStudentId(anyString()))
                .willReturn(Mono.just(Customer.builder()
                                .studentId("sId")
                                .isDiver(false)
                        .build()));

        webClient
                .post().uri("/login")
                .bodyValue(requestBody())
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(SignInResponse.class);
    }

    @Test
    public void whenSignIn_givenStudentIdAndPasswordInCurrent_shouldBeReturnBadRequest() {

        given(customerRepository.existsByStudentIdAndPassword(anyString(),anyString()))
                .willReturn(Mono.just(false));

        given(customerRepository.findByStudentId(anyString()))
                .willReturn(Mono.just(Customer.builder()
                        .studentId("sId")
                        .isDiver(false)
                        .build()));

        webClient
                .post().uri("/login")
                .bodyValue(requestBody())
                .exchange()
                .expectStatus()
                .is5xxServerError();
    }

    @Test
    public void whenSignIn_bodyIsBlank_shouldReturnFail() {

//
//        given(signInService.execute(any()))
//                .willReturn(Mono.just(SignInResponse.builder().build()));

        webClient
                .post().uri("/login")
                .bodyValue("")
                .exchange()
                .expectStatus()
                .is5xxServerError();
    }

    private SignInRequest requestBody(){
        return SignInRequest.builder()
                .studentId("1111111111")
                .password("12345678")
                .build();
    }

}
