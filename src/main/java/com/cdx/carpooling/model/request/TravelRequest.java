package com.cdx.carpooling.model.request;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TravelRequest {

    @NotBlank
    private String studentId;
    @NotBlank
    private String name;
    @NotBlank
    private String origin;
    @NotBlank
    private String destination;
    @NotBlank
    private String datetime;

    private String detail;
}
