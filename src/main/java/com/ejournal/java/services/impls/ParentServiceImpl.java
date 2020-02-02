package com.ejournal.java.services.impls;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.ejournal.java.dtos.ApiResponseDto;
import com.ejournal.java.dtos.parent.ParentDto;
import com.ejournal.java.dtos.parent.ParentRegisterDto;
import com.ejournal.java.entities.Parent;
import com.ejournal.java.entities.Student;
import com.ejournal.java.enums.RoleName;
import com.ejournal.java.exceptions.EntityNotFoundException;
import com.ejournal.java.mappers.ParentMapper;
import com.ejournal.java.repositories.ParentRepository;
import com.ejournal.java.repositories.UserRepository;
import com.ejournal.java.services.ParentService;
import com.ejournal.java.services.RoleService;
import com.ejournal.java.services.StudentService;
import lombok.RequiredArgsConstructor;

/**
 * Created by kristiyan.parvanov on 27.12.19 г.
 */
@Service
@RequiredArgsConstructor
public class ParentServiceImpl implements ParentService {

    private final ParentRepository parentRepository;
    private final StudentService studentService;
    private final RoleService roleService;
    private final ParentMapper parentMapper;
    private final UserRepository userRepository;

    @Override
    public ParentDto register(final ParentRegisterDto parentRegisterDto) {
        final Parent parent = parentMapper.parentRegisterDtoToParent(parentRegisterDto);

        if (userRepository.existsByEmail(parentRegisterDto.getEmail())) {
            throw new RuntimeException();
        }

        final List<Student> students = studentService.getByIdIn(parentRegisterDto.getStudentId());
        parent.setStudents(students);
        parent.setRoles(Collections.singleton(roleService.findByName(RoleName.ROLE_PARENT)));

        students.forEach(student -> student.getParents().add(parent));

        return parentMapper.parentToParentDto(parentRepository.save(parent));
    }

    @Override
    public ApiResponseDto delete(final Long id) {
        final Parent parent = parentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Parent with id: %s doesn't exist", id)));

        final List<Student> students = parent.getStudents();
        students.forEach(student -> student.getParents().remove(parent));
        students.clear();

        parentRepository.delete(parent);

        return new ApiResponseDto(true, "Parent is deleted successfully");
    }
}
