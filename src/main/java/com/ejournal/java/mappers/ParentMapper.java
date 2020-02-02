package com.ejournal.java.mappers;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.ejournal.java.dtos.parent.ParentDto;
import com.ejournal.java.dtos.parent.ParentRegisterDto;
import com.ejournal.java.entities.Parent;

/**
 * Created by kristiyan.parvanov on 26.12.19 г.
 */
@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public abstract class ParentMapper {

    @Autowired
    protected PasswordEncoder passwordEncoder;

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "students", ignore = true)
    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "password", expression = "java(passwordEncoder.encode(parentRegisterDto.getEgn()))")
    public abstract Parent parentRegisterDtoToParent(ParentRegisterDto parentRegisterDto);

    public abstract ParentDto parentToParentDto(Parent parent);
}
