package com.optum.sample.userInfo.controller;

import com.optum.sample.userInfo.dto.responses.UserResponseDTO;
import com.optum.sample.userInfo.service.UserService;
import jakarta.annotation.security.RolesAllowed;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/userInfo", produces = "application/json")
@AllArgsConstructor
public class UserInfoController {

    private UserService service;

    @GetMapping("/all")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<List<UserResponseDTO>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(value = "/{phoneNumber}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public ResponseEntity<UserResponseDTO> getUserByPhoneNumber(@PathVariable Long phoneNumber) {
        return ResponseEntity.ok().body(service.findByPhoneNumber(String.valueOf(phoneNumber)));
    }
}
