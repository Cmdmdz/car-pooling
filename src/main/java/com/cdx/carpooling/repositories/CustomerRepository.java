package com.cdx.carpooling.repositories;

import com.cdx.carpooling.repositories.dao.Customer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface CustomerRepository extends ReactiveMongoRepository<Customer,String> {

    Mono<Boolean> existsByStudentId(String studentId);

    Mono<Boolean> existsByStudentIdAndPassword(String studentId, String password);

    Mono<Customer> findByStudentId(String studentId);


}
