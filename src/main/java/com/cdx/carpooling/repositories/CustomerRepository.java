package com.cdx.carpooling.repositories;

import com.cdx.carpooling.repositories.dao.Customer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface CustomerRepository extends ReactiveMongoRepository<Customer,String> {

    Mono<Boolean> existsByEmail(String email);

    Mono<Boolean> existsByEmailAndPassword(String email, String password);

    Mono<Customer> findByEmail(String email);
}
