package com.cdx.carpooling.model.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerResponse {

    private String customerId;
    private String fistName;
    private String lastName;
    private String address;
    private String mobileNumber;
    private String email;
    private String password;
    private String studentId;
    private String auth;
}
