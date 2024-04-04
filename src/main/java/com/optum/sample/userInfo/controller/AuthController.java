package com.optum.sample.userInfo.controller;

import com.optum.sample.userInfo.exceptions.UserNotFoundException;
import com.optum.sample.userInfo.models.AuthRequest;
import com.optum.sample.userInfo.utils.JwtUtil;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/auth", produces = "application/json")
@AllArgsConstructor
public class AuthController {
    private final JwtUtil jwtService;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/generateToken")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername());
        } else {
            throw new UserNotFoundException("invalid user request !");
        }
    }
}
