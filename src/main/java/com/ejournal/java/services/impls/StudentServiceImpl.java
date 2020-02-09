package com.ejournal.java.services.impls;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;
import com.ejournal.java.dtos.ApiResponseDto;
import com.ejournal.java.dtos.student.StudentRegisterDto;
import com.ejournal.java.entities.Group;
import com.ejournal.java.entities.Student;
import com.ejournal.java.enums.RoleName;
import com.ejournal.java.exceptions.StudentDoesNotExistException;
import com.ejournal.java.exceptions.UserExistsException;
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

    private final StudentRepository studentRepository;
    private final RoleService roleService;
    private final GroupService groupService;
    private final StudentMapper studentMapper;

    @Override
    public ApiResponseDto register(final StudentRegisterDto studentRegisterDto) {
        if (studentRepository.existsByEmail(studentRegisterDto.getEmail())) {
            throw new UserExistsException();
        }

        final Student student = studentMapper.studentRegisterDtoToStudent(studentRegisterDto);
        student.setRoles(Collections.singleton(roleService.findByName(RoleName.ROLE_STUDENT)));

        final Group group = groupService.getById(studentRegisterDto.getGroupId());
        student.setGroup(group);
        student.setSchool(group.getSchool());

        studentRepository.save(student);

        return new ApiResponseDto(true, "Student is registered successfully");
    }

    @Override
    public Student getById(final String id) {
        return studentRepository.findById(id)
                .orElseThrow(StudentDoesNotExistException::new);
    }

    @Override
    public List<Student> getByIdIn(final List<String > ids) {
        return studentRepository.findByIdIn(ids);
    }
}
