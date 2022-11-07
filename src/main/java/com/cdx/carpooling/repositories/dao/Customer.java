package com.cdx.carpooling.repositories.dao;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "CUSTOMER")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {


    @Id
    private String studentId;
    private String name;
    private String address;
    private String mobileNumber;
    private String email;
    private String password;
    private Boolean isDiver;
}
