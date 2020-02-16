package com.ejournal.java.services.impls;

import static com.ejournal.java.utils.Util.formatName;

import java.util.Collections;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.ejournal.java.dtos.teacher.TeacherInfoDto;
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
    public TeacherInfoDto register(final TeacherRegisterDto teacherRegisterDto) {
        if (teacherRepository.existsByEmail(teacherRegisterDto.getEmail())) {
            throw new UserExistsException();
        }

        final Teacher teacher = teacherMapper.teacherRegisterDtoToTeacher(teacherRegisterDto);
        teacher.setRoles(Collections.singleton(roleService.findByName(RoleName.ROLE_TEACHER)));

        final School school = schoolService.getById(teacherRegisterDto.getSchoolId());
        teacher.setSchool(school);

        return teacherMapper.teacherToTeacherInfoDto(teacherRepository.save(teacher));
    }

    @Override
    public Teacher getById(final String id) {
        return teacherRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Teacher with id: %s, does not exist", id)));
    }

    @Override
    public TeacherInfoDto getTeacher(final String id) {
        return teacherMapper.teacherToTeacherInfoDto(getById(id));
    }

    @Override
    public Page<TeacherInfoDto> getTeachers(final String name, final Pageable pageable) {
        if (StringUtils.isNotBlank(name)) {
            return teacherRepository.findTeachersByName(formatName(name), pageable)
                    .map(teacherMapper::teacherToTeacherInfoDto);
        }

        return teacherRepository.findAll(pageable)
                .map(teacherMapper::teacherToTeacherInfoDto);
    }
}
