package com.cdx.carpooling.repositories;

import com.cdx.carpooling.repositories.dao.Customer;
import com.cdx.carpooling.repositories.dao.Travel;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelRepository  extends ReactiveMongoRepository<Travel,String> {
}
