package com.cdx.carpooling.controller;

import com.cdx.carpooling.model.request.TravelRequest;
import com.cdx.carpooling.model.response.CustomerResponse;
import com.cdx.carpooling.model.response.TravelResponse;
import com.cdx.carpooling.services.PostTravelService;
import com.cdx.carpooling.services.TravelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class TravelController {

    private final TravelService travelService;
    private final PostTravelService postTravelService;

    @GetMapping("travel")
    public Flux<TravelResponse> findTravelById(){
        return travelService.execute();

    }

    @PostMapping("travel")
    public Mono<TravelResponse> postTravel(@RequestBody TravelRequest request){
        return postTravelService.execute(request);

    }
}
