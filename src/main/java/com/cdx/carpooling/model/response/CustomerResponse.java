package com.cdx.carpooling.model.response;

import com.cdx.carpooling.repositories.dao.Travel;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerResponse {

    private String customerId;
    private String name;
    private String address;
    private String mobileNumber;
    private String email;
    private String password;
    private String studentId;
    private Boolean isDiver;
    private List<Travel> travelList;
}
