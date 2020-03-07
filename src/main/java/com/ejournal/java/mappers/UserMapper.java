package com.ejournal.java.mappers;

import org.mapstruct.BeanMapping;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.ejournal.java.dtos.auhtentication.RegisterRequestDto;
import com.ejournal.java.dtos.user.UpdateUserDto;
import com.ejournal.java.dtos.user.UserDto;
import com.ejournal.java.entities.User;
import com.ejournal.java.utils.Util;

/**
 * Created by kristiyan.parvanov on 26.12.19 г.
 */
@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = Util.class
)
public abstract class UserMapper {

    @Autowired
    protected PasswordEncoder passwordEncoder;

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "password", expression = "java(passwordEncoder.encode(registerRequestDto.getEgn()))")
    public abstract User registerRequestDtoToUser(RegisterRequestDto registerRequestDto);

    @Mapping(target = "roles", expression = "java(Util.convertSetOfRolesToRoleNames(user.getRoles()))")
    public abstract UserDto userToUserDto(User user);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "username", ignore = true)
    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "password", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    public abstract User updateUser(UpdateUserDto userDto, @MappingTarget User user);
}
