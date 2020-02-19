package com.ejournal.java.services.impls;

import static com.ejournal.java.utils.Util.formatName;

import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.ejournal.java.dtos.student.StudentInfoDto;
import com.ejournal.java.dtos.student.StudentRegisterDto;
import com.ejournal.java.entities.Group;
import com.ejournal.java.entities.Student;
import com.ejournal.java.enums.RoleName;
import com.ejournal.java.exceptions.EntityExistsException;
import com.ejournal.java.exceptions.EntityNotFoundException;
import com.ejournal.java.mappers.StudentMapper;
import com.ejournal.java.repositories.StudentRepository;
import com.ejournal.java.services.GroupService;
import com.ejournal.java.services.RoleService;
import com.ejournal.java.services.StudentService;
import lombok.RequiredArgsConstructor;

/**
 * Created by kristiyan.parvanov on 26.12.19 г.
 */
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private static final String STUDENT = "Student";

    private final StudentRepository studentRepository;
    private final RoleService roleService;
    private final GroupService groupService;
    private final StudentMapper studentMapper;

    @Override
    public StudentInfoDto register(final StudentRegisterDto studentRegisterDto) {
        if (studentRepository.existsByEmail(studentRegisterDto.getEmail())) {
            throw new EntityExistsException(STUDENT);
        }

        final Student student = studentMapper.studentRegisterDtoToStudent(studentRegisterDto);
        student.setRoles(Collections.singleton(roleService.findByName(RoleName.ROLE_STUDENT)));

        final Group group = groupService.getById(studentRegisterDto.getGroupId());
        student.setGroup(group);
        student.setSchool(group.getSchool());

        return studentMapper.studentToStudentInfoDto(studentRepository.save(student));
    }

    @Override
    public Student getById(final String id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(STUDENT, id));
    }

    @Override
    public List<Student> getByIdIn(final List<String > ids) {
        return studentRepository.findByIdIn(ids);
    }

    @Override
    public StudentInfoDto getStudent(final String id) {
        return studentMapper.studentToStudentInfoDto(getById(id));
    }

    @Override
    public Page<StudentInfoDto> getStudents(final String name, final Pageable pageable) {
        if (StringUtils.isNotBlank(name)) {
            return studentRepository.findStudentsByName(formatName(name), pageable)
                    .map(studentMapper::studentToStudentInfoDto);
        }

        return studentRepository.findAll(pageable)
                .map(studentMapper::studentToStudentInfoDto);
    }

    @Override
    public Page<StudentInfoDto> getStudentsByGroup(final String id, Pageable pageable) {
        return studentRepository.findByGroup(groupService.getById(id), pageable)
                .map(studentMapper::studentToStudentInfoDto);
    }
}
