package com.optum.sample.userInfo.service;

import com.optum.sample.userInfo.dto.responses.UserResponseDTO;

import java.util.List;

public interface UserService {

    List<UserResponseDTO> findAll();

    UserResponseDTO findByPhoneNumber(String phoneNumber);

}




