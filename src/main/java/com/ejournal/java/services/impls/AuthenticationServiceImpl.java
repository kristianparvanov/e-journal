package com.ejournal.java.services.impls;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import com.ejournal.java.configurations.JwtTokenProvider;
import com.ejournal.java.dtos.ApiResponseDto;
import com.ejournal.java.dtos.auhtentication.ChangePasswordDto;
import com.ejournal.java.dtos.auhtentication.JWTAuthenticationResponseDto;
import com.ejournal.java.dtos.auhtentication.LoginRequestDto;
import com.ejournal.java.dtos.auhtentication.RegisterRequestDto;
import com.ejournal.java.entities.UserPrincipal;
import com.ejournal.java.enums.RoleName;
import com.ejournal.java.services.AuthenticationService;
import com.ejournal.java.services.UserService;
import lombok.RequiredArgsConstructor;

/**
 * Created by kristiyan.parvanov on 26.12.19 г.
 */
@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public JWTAuthenticationResponseDto login(final LoginRequestDto loginRequestDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(), loginRequestDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return new JWTAuthenticationResponseDto(jwtTokenProvider.generateToken(authentication));
    }

    @Override
    public ApiResponseDto register(final RegisterRequestDto registerRequestDto) {
        userService.createUser(registerRequestDto);

        return new ApiResponseDto(true, "User registered successfully");
    }

    @Override
    public ApiResponseDto changePassword(final ChangePasswordDto changePasswordDto) {
        userService.changePassword(changePasswordDto);

        return new ApiResponseDto(true, "Password is changed successfully");
    }

    @Override
    public UserPrincipal getUserPrincipal() {
        return (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    @Override
    public String getCurrentUserId() {
        return getUserPrincipal().getId();
    }

    @Override
    public boolean hasRole(RoleName roleName) {
        return getUserPrincipal().getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .anyMatch(role -> RoleName.ROLE_STUDENT.toString().equals(role));
    }
}
