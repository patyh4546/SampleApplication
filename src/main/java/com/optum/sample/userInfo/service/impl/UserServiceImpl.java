package com.optum.sample.userInfo.service.impl;


import com.optum.sample.userInfo.dto.responses.UserResponseDTO;
import com.optum.sample.userInfo.entities.User;
import com.optum.sample.userInfo.exceptions.UserNotFoundException;
import com.optum.sample.userInfo.repository.UserRepository;
import com.optum.sample.userInfo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    public UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<UserResponseDTO> findAll() {
        List<User> list = repository.findAll();
        return list.stream().map(UserResponseDTO::new).collect(Collectors.toList());
    }

    @Override
    public UserResponseDTO findByPhoneNumber(String phoneNumber) throws UserNotFoundException {
        return new UserResponseDTO(repository.findByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new UserNotFoundException(phoneNumber)));
    }

}
