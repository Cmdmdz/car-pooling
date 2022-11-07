package com.cdx.carpooling.services;

import com.cdx.carpooling.model.request.TravelRequest;
import com.cdx.carpooling.model.response.TravelResponse;
import com.cdx.carpooling.repositories.CustomerRepository;
import com.cdx.carpooling.repositories.TravelRepository;
import com.cdx.carpooling.repositories.dao.Travel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class PostTravelService {
    private final TravelRepository travelRepository;
    private final CustomerRepository customerRepository;

    public Mono<TravelResponse> execute(TravelRequest request) {

        return customerRepository.findById(request.getStudentId())
                .flatMap(customer -> travelRepository.save(Travel.builder()
                                .origin(request.getOrigin())
                                .destination(request.getDestination())
                                .name(customer.getName())
                                .datetime(request.getDatetime())
                                .detail(request.getDetail())
                                .build())
                        .then(Mono.just(TravelResponse.builder().build())));

    }
}
