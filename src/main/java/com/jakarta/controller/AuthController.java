package com.jakarta.controller;

import com.jakarta.dto.TokenRequest;
import com.jakarta.dto.TokenResponse;
import com.jakarta.dto.User;
import com.jakarta.service.AuthService;
import com.jakarta.utils.exception.ExceptionThrow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = "*",origins = "*")
public class AuthController {

    @Autowired
    private AuthService service;

    @PostMapping(value = "/auth")
    public ResponseEntity<User> createUser(@RequestBody User dto) throws ExceptionThrow {
        return new ResponseEntity<>(service.getAuthService().createuser(dto), HttpStatus.CREATED);
    }

    @PostMapping(value = "/auth/authenticate")
    public ResponseEntity<TokenResponse> authenticate(@RequestBody TokenRequest dto) throws ExceptionThrow{
        return new ResponseEntity<>(service.getAuthService().authenticate(dto),HttpStatus.OK);
    }
}
