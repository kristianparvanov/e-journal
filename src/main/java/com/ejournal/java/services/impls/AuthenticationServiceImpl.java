package com.ejournal.java.services.impls;

import java.util.Collections;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.ejournal.java.configurations.JwtTokenProvider;
import com.ejournal.java.dtos.ApiResponseDto;
import com.ejournal.java.dtos.auhtentication.ChangePasswordDto;
import com.ejournal.java.dtos.auhtentication.JWTAuthenticationResponseDto;
import com.ejournal.java.dtos.auhtentication.LoginRequestDto;
import com.ejournal.java.dtos.auhtentication.RegisterRequestDto;
import com.ejournal.java.entities.Role;
import com.ejournal.java.entities.User;
import com.ejournal.java.entities.UserPrincipal;
import com.ejournal.java.enums.RoleName;
import com.ejournal.java.exceptions.UserExistsException;
import com.ejournal.java.exceptions.UserRoleNotSetException;
import com.ejournal.java.mappers.UserMapper;
import com.ejournal.java.repositories.RoleRepository;
import com.ejournal.java.repositories.UserRepository;
import com.ejournal.java.services.AuthenticationService;
import lombok.RequiredArgsConstructor;

/**
 * Created by kristiyan.parvanov on 26.12.19 г.
 */
@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public JWTAuthenticationResponseDto login(final LoginRequestDto loginRequestDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(), loginRequestDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return new JWTAuthenticationResponseDto(jwtTokenProvider.generateToken(authentication));
    }

    @Override
    public ApiResponseDto register(final RegisterRequestDto registerRequestDto) {
        if (userRepository.existsByEmail(registerRequestDto.getEmail())) {
            throw new UserExistsException();
        }

        Role role = roleRepository.findByName(RoleName.ROLE_ADMIN)
                .orElseThrow(UserRoleNotSetException::new);

        User user = userMapper.registerRequestDtoToUser(registerRequestDto);
        user.setRoles(Collections.singleton(role));

        userRepository.save(user);

        return new ApiResponseDto(true, "User registered successfully");
    }

    @Override
    public ApiResponseDto changePassword(final ChangePasswordDto changePasswordDto) {
        final User user = userRepository.findByEmail(changePasswordDto.getEmail())
                .orElseThrow(UserExistsException::new);

        user.setPassword(passwordEncoder.encode(changePasswordDto.getPassword()));

        userRepository.save(user);

        return new ApiResponseDto(true, "Password is changed successfully");
    }

    @Override
    public UserPrincipal getUserPrincipal() {
        return (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    @Override
    public Long getCurrentUserId() {
        return getUserPrincipal().getId();
    }

    @Override
    public boolean hasRole(RoleName roleName) {
        return getUserPrincipal().getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .anyMatch(role -> RoleName.ROLE_STUDENT.toString().equals(role));
    }
}
