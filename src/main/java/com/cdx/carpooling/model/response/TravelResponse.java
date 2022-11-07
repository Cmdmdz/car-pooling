package com.cdx.carpooling.model.response;

import lombok.*;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TravelResponse {

    private String id;
    private String name;
    private String origin;
    private String destination;
    private String datetime;
    private String detail;
}
