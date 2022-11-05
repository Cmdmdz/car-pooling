package com.cdx.carpooling.repositories.dao;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "CUSTOMER")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {


    @Id
    private String customerId;
    private String fistName;
    private String lastName;
    private String address;
    private String mobileNumber;
    private String email;
    private String password;
    private String studentId;
}
