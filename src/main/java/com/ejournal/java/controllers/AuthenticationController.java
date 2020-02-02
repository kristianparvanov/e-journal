package com.ejournal.java.controllers;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.ejournal.java.dtos.ApiResponseDto;
import com.ejournal.java.dtos.auhtentication.ChangePasswordDto;
import com.ejournal.java.dtos.auhtentication.JWTAuthenticationResponseDto;
import com.ejournal.java.dtos.auhtentication.LoginRequestDto;
import com.ejournal.java.dtos.auhtentication.RegisterRequestDto;
import com.ejournal.java.services.AuthenticationService;
import lombok.RequiredArgsConstructor;

/**
 * Created by kristiyan.parvanov on 13.12.19 г.
 */
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

   private final AuthenticationService authenticationService;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public JWTAuthenticationResponseDto login(@Valid @RequestBody LoginRequestDto loginRequestDto) {
        return authenticationService.login(loginRequestDto);
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponseDto register(@Valid @RequestBody RegisterRequestDto registerRequestDto) {
        return authenticationService.register(registerRequestDto);
    }

    @PostMapping("/change-password")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponseDto changePassword(@Valid @RequestBody ChangePasswordDto changePasswordDto) {
        return authenticationService.changePassword(changePasswordDto);
    }
}
