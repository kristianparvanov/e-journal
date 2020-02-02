package com.ejournal.java.services.impls;

import java.util.Collections;

import org.springframework.stereotype.Service;
import com.ejournal.java.dtos.ApiResponseDto;
import com.ejournal.java.dtos.teacher.TeacherRegisterDto;
import com.ejournal.java.entities.School;
import com.ejournal.java.entities.Teacher;
import com.ejournal.java.enums.RoleName;
import com.ejournal.java.exceptions.EntityNotFoundException;
import com.ejournal.java.exceptions.UserExistsException;
import com.ejournal.java.mappers.TeacherMapper;
import com.ejournal.java.repositories.TeacherRepository;
import com.ejournal.java.services.RoleService;
import com.ejournal.java.services.SchoolService;
import com.ejournal.java.services.TeacherService;
import lombok.RequiredArgsConstructor;

/**
 * Created by kristiyan.parvanov on 30.12.19 г.
 */
@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final RoleService roleService;
    private final SchoolService schoolService;
    private final TeacherMapper teacherMapper;

    @Override
    public ApiResponseDto register(final TeacherRegisterDto teacherRegisterDto) {
        if (teacherRepository.existsByEmail(teacherRegisterDto.getEmail())) {
            throw new UserExistsException();
        }

        final Teacher teacher = teacherMapper.teacherRegisterDtoToTeacher(teacherRegisterDto);
        teacher.setRoles(Collections.singleton(roleService.findByName(RoleName.ROLE_TEACHER)));

        final School school = schoolService.getById(teacherRegisterDto.getSchoolId());
        teacher.setSchool(school);

        teacherRepository.save(teacher);

        return new ApiResponseDto(true, "Student is registered successfully");
    }

    @Override
    public Teacher getById(final Long id) {
        return teacherRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Teacher with id: %s, does not exist", id)));
    }
}
