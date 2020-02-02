package com.ejournal.java.services;

import com.ejournal.java.dtos.ApiResponseDto;
import com.ejournal.java.dtos.auhtentication.ChangePasswordDto;
import com.ejournal.java.dtos.auhtentication.JWTAuthenticationResponseDto;
import com.ejournal.java.dtos.auhtentication.LoginRequestDto;
import com.ejournal.java.dtos.auhtentication.RegisterRequestDto;
import com.ejournal.java.entities.UserPrincipal;
import com.ejournal.java.enums.RoleName;

/**
 * Created by kristiyan.parvanov on 26.12.19 г.
 */
public interface AuthenticationService {

    JWTAuthenticationResponseDto login(LoginRequestDto loginRequestDto);

    ApiResponseDto register(RegisterRequestDto registerRequestDto);

    ApiResponseDto changePassword(ChangePasswordDto changePasswordDto);

    UserPrincipal getUserPrincipal();

    Long getCurrentUserId();

    boolean hasRole(RoleName roleName);
}
