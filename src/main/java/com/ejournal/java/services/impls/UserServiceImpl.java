package com.ejournal.java.services.impls;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.ejournal.java.dtos.auhtentication.ChangePasswordDto;
import com.ejournal.java.dtos.auhtentication.RegisterRequestDto;
import com.ejournal.java.dtos.user.UpdateUserDto;
import com.ejournal.java.dtos.user.UserDto;
import com.ejournal.java.entities.Role;
import com.ejournal.java.entities.User;
import com.ejournal.java.enums.RoleName;
import com.ejournal.java.exceptions.EntityExistsException;
import com.ejournal.java.exceptions.EntityNotFoundException;
import com.ejournal.java.mappers.UserMapper;
import com.ejournal.java.repositories.UserRepository;
import com.ejournal.java.services.RoleService;
import com.ejournal.java.services.UserService;
import lombok.RequiredArgsConstructor;

/**
 * Created by kristiyan.parvanov on 7.03.20 г.
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private static final String USER = "User";

    private final UserRepository userRepository;
    private final RoleService roleService;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User createUser(RegisterRequestDto registerRequestDto) {
        if (userRepository.existsByEmail(registerRequestDto.getEmail())) {
            throw new EntityExistsException(USER);
        }

        final Role role = roleService.findByName(RoleName.ROLE_ADMIN);

        final User user = userMapper.registerRequestDtoToUser(registerRequestDto);
        user.setRoles(Collections.singleton(role));

        return userRepository.save(user);
    }

    @Override
    public User changePassword(ChangePasswordDto changePasswordDto) {
        final User user = userRepository.findByEmail(changePasswordDto.getEmail())
                .orElseThrow(() -> new EntityExistsException(USER));

        user.setPassword(passwordEncoder.encode(changePasswordDto.getPassword()));

        return userRepository.save(user);
    }

    @Override
    public Page<UserDto> getAdmins(final RoleName roleName, final Pageable pageable) {
        return userRepository.findByRoles(roleService.findByName(roleName), pageable)
                .map(userMapper::userToUserDto);
    }

    @Override
    public UserDto updateUser(final UpdateUserDto updateUserDto) {
        final User user = userRepository.findById(updateUserDto.getId())
                .orElseThrow(() -> new EntityNotFoundException(USER, updateUserDto.getId()));

        if (!Objects.isNull(updateUserDto.getRoleName())) {
            final Role role = roleService.findByName(updateUserDto.getRoleName());

            final Set<Role> roles = user.getRoles();
            roles.clear();
            roles.add(role);
        }

        return userMapper.userToUserDto(userRepository.save(userMapper.updateUser(updateUserDto, user)));
    }
}
