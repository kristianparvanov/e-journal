package com.ejournal.java.services.impls;

import java.time.LocalDate;
import java.util.Objects;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.ejournal.java.dtos.ApiResponseDto;
import com.ejournal.java.dtos.leave.CreateLeaveDto;
import com.ejournal.java.dtos.leave.LeaveDto;
import com.ejournal.java.dtos.leave.UpdateLeaveDto;
import com.ejournal.java.entities.Leave;
import com.ejournal.java.entities.Student;
import com.ejournal.java.entities.Subject;
import com.ejournal.java.entities.Teacher;
import com.ejournal.java.enums.RoleName;
import com.ejournal.java.exceptions.EntityNotFoundException;
import com.ejournal.java.exceptions.MissingPropertiesException;
import com.ejournal.java.mappers.LeaveMapper;
import com.ejournal.java.repositories.LeaveRepository;
import com.ejournal.java.services.AuthenticationService;
import com.ejournal.java.services.LeaveService;
import com.ejournal.java.services.StudentService;
import com.ejournal.java.services.SubjectService;
import com.ejournal.java.services.TeacherService;
import lombok.RequiredArgsConstructor;

/**
 * Created by kristiyan.parvanov on 5.01.20 г.
 */
@Service
@RequiredArgsConstructor
public class LeaveServiceImpl implements LeaveService {

    private final LeaveRepository leaveRepository;
    private final AuthenticationService authenticationService;
    private final StudentService studentService;
    private final TeacherService teacherService;
    private final SubjectService subjectService;
    private final LeaveMapper leaveMapper;

    @Override
    public LeaveDto createLeave(final CreateLeaveDto createLeaveDto) {
        final Student student = studentService.getById(createLeaveDto.getStudentId());
        final Teacher teacher = teacherService.getById(createLeaveDto.getTeacherId());
        final Subject subject = subjectService.getById(createLeaveDto.getSubjectId());

        final Leave leave = Leave.builder()
                .student(student)
                .teacher(teacher)
                .subject(subject)
                .modificationDate(LocalDate.now())
                .build();

        return leaveMapper.leaveToLeaveDto(leaveRepository.save(leave));
    }

    @Override
    public LeaveDto updateLeave(final UpdateLeaveDto updateLeaveDto) {
        final Leave leave = leaveRepository.findById(updateLeaveDto.getId())
                .orElseThrow(() -> new MissingPropertiesException("Missing leave properties for update"));

        final Subject subject = subjectService.getById(updateLeaveDto.getSubjectId());

        leave.setSubject(subject);

        return leaveMapper.leaveToLeaveDto(leaveRepository.save(leave));
    }

    @Override
    public Page<LeaveDto> getByStudent(String studentId, Pageable pageable) {
        if (Objects.isNull(studentId)) {
            if (!authenticationService.hasRole(RoleName.ROLE_STUDENT)) {
                throw new RuntimeException("NQMA PYK");
            }

            return getLeavesForStudent(authenticationService.getCurrentUserId(), pageable);
        }

        return getLeavesForStudent(studentId, pageable);
    }

    @Override
    public Page<LeaveDto> getByStudentAndSubject(Subject subject, Pageable pageable) {
        final Student student = studentService.getById(authenticationService.getCurrentUserId());

        return leaveRepository.getByStudentAndSubject(student, subject, pageable)
                .map(leaveMapper::leaveToLeaveDto);
    }

    @Override
    public ApiResponseDto deleteLeave(final String id) {
        final Leave leave = leaveRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Leave", id));

        leaveRepository.delete(leave);

        return new ApiResponseDto(true, "The leave is deleted successfully!");
    }

    private Page<LeaveDto> getLeavesForStudent(final String studentId, final Pageable pageable) {
        final Student student = studentService.getById(studentId);

        return leaveRepository.getByStudent(student, pageable)
                .map(leaveMapper::leaveToLeaveDto);
    }
}
