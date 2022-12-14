package com.cdx.carpooling.model.request;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignInRequest {

    @NotBlank
    private String studentId;

    @NotBlank
    private String password;
}
