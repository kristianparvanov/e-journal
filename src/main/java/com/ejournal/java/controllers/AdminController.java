package com.ejournal.java.controllers;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.ejournal.java.dtos.user.UpdateUserDto;
import com.ejournal.java.dtos.user.UserDto;
import com.ejournal.java.enums.RoleName;
import com.ejournal.java.services.UserService;
import lombok.RequiredArgsConstructor;

/**
 * Created by kristiyan.parvanov on 7.03.20 г.
 */
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class AdminController {

    private final UserService userService;

    @GetMapping("admins")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ADMIN')")
    public Page<UserDto> getAdmins(@RequestParam RoleName roleName, Pageable pageable) {
        return userService.getAdmins(roleName, pageable);
    }

    @PostMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ADMIN')")
    public UserDto updateUser(@Valid @RequestBody UpdateUserDto updateUserDto) {
        return userService.updateUser(updateUserDto);
    }
}
