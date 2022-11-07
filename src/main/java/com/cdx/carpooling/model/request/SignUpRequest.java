package com.cdx.carpooling.model.request;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignUpRequest {

    @NotBlank
    @Length(min = 2, max = 50)
    private String name;
    @NotBlank
    @Length(min = 10)
    private String mobileNumber;

    @NotBlank
    @Length(min = 10)
    private String studentId;

    @NotBlank
    @Length(min = 8, max = 20)
    private String password;
}
