package com.ejournal.java.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.ejournal.java.dtos.auhtentication.ChangePasswordDto;
import com.ejournal.java.dtos.auhtentication.RegisterRequestDto;
import com.ejournal.java.dtos.user.UpdateUserDto;
import com.ejournal.java.dtos.user.UserDto;
import com.ejournal.java.entities.User;
import com.ejournal.java.enums.RoleName;

/**
 * Created by kristiyan.parvanov on 7.03.20 г.
 */
public interface UserService {

    User createUser(RegisterRequestDto registerRequestDto);

    User changePassword(ChangePasswordDto changePasswordDto);

    Page<UserDto> getAdmins(RoleName roleName, Pageable pageable);

    UserDto updateUser(UpdateUserDto updateUserDto);
}
