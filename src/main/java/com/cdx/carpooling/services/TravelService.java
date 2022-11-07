package com.cdx.carpooling.services;

import com.cdx.carpooling.model.response.CustomerResponse;
import com.cdx.carpooling.model.response.TravelResponse;
import com.cdx.carpooling.repositories.TravelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class TravelService {

    private final TravelRepository travelRepository;

    public Flux<TravelResponse> execute() {
        return travelRepository.findAll()
                .flatMap(res -> Flux.just(TravelResponse.builder()
                                .id(res.getId())
                                .name(res.getName())
                                .origin(res.getOrigin())
                                .destination(res.getDestination())
                                .datetime(res.getDatetime())
                                .detail(res.getDetail())
                        .build()));
    }
}
