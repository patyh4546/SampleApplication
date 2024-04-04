package com.optum.sample.userInfo.dto.responses;


import com.optum.sample.userInfo.entities.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserResponseDTO {

    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String streetName;
    private String city;
    private String state;
    private String homeNumber;
    private String zipCode;

    public UserResponseDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.phoneNumber = user.getPhoneNumber();
        this.streetName = user.getStreetName();
        this.city = user.getCity();
        this.state = user.getState();
        this.homeNumber = user.getHomeNumber();
        this.zipCode = user.getZipCode();
    }
}
