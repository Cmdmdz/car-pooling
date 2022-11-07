package com.cdx.carpooling.model.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignInResponse {

    private String studentId;
    private Boolean isDiver;
    private String auth;
}
