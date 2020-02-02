package com.ejournal.java.mappers;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.ejournal.java.dtos.student.StudentRegisterDto;
import com.ejournal.java.entities.Student;

/**
 * Created by kristiyan.parvanov on 26.12.19 г.
 */
@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public abstract class StudentMapper {

    @Autowired
    protected PasswordEncoder passwordEncoder;

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "school", ignore = true)
    @Mapping(target = "group", ignore = true)
    @Mapping(target = "parents", ignore = true)
    @Mapping(target = "marks", ignore = true)
    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "password", expression = "java(passwordEncoder.encode(studentRegisterDto.getEgn()))")
    public abstract Student studentRegisterDtoToStudent(StudentRegisterDto studentRegisterDto);
}