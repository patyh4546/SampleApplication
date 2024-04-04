package com.optum.sample.userInfo.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTO {
    private String name;
    private String email;
    private String phoneNumber;
    private String streetName;
    private String city;
    private String state;
    private String homeNumber;
    private String zipCode;
}
