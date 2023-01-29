package com.jakarta.service.impl;


import com.jakarta.dto.TokenRequest;
import com.jakarta.dto.TokenResponse;
import com.jakarta.dto.User;
import com.jakarta.dto.UserRole;
import com.jakarta.repository.UserRepository;
import com.jakarta.security.TokenManager;
import com.jakarta.utils.exception.ExceptionThrow;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class AuthServiceImpl {
    private final PasswordEncoder encoder;
    private final TokenManager tokenManager;
    private final AuthenticationManager authManager;
    private final UserRepository repository;

    public User createuser(User dto) throws ExceptionThrow {
        User user=new User();
        user.setName(dto.getName());
        user.setSurname(dto.getSurname());
        user.setUsername(dto.getUsername());
        user.setPassword(encoder.encode(dto.getPassword()));
        user.setRole(UserRole.USER);
        var newUser=repository.save(user);

        log.info("Create User: "+newUser.getId());
        return newUser;
    }

    public TokenResponse authenticate(TokenRequest dto) throws ExceptionThrow{
        var user=repository.findByUsername(dto.getUsername()).orElseThrow();
        var token=tokenManager.generateToken(user);
        authManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getUsername(),dto.getPassword()));

        log.info("Generate Token: "+dto.getUsername());
        return TokenResponse.builder().token(token).username(dto.getUsername()).name(user.getName()).surname(user.getSurname()).role(user.getRole()).build();
    }

}
