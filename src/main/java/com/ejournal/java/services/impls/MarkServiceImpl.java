package com.ejournal.java.services.impls;

import java.time.LocalDate;
import java.util.Objects;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.ejournal.java.dtos.ApiResponseDto;
import com.ejournal.java.dtos.mark.CreateMarkDto;
import com.ejournal.java.dtos.mark.MarkDto;
import com.ejournal.java.dtos.mark.UpdateMarkDto;
import com.ejournal.java.entities.Mark;
import com.ejournal.java.entities.Student;
import com.ejournal.java.entities.Subject;
import com.ejournal.java.entities.Teacher;
import com.ejournal.java.enums.RoleName;
import com.ejournal.java.exceptions.EntityNotFoundException;
import com.ejournal.java.exceptions.MissingPropertiesException;
import com.ejournal.java.mappers.MarkMapper;
import com.ejournal.java.repositories.MarkRepository;
import com.ejournal.java.services.AuthenticationService;
import com.ejournal.java.services.MarkService;
import com.ejournal.java.services.StudentService;
import com.ejournal.java.services.SubjectService;
import com.ejournal.java.services.TeacherService;
import lombok.RequiredArgsConstructor;

/**
 * Created by kristiyan.parvanov on 5.01.20 г.
 */
@Service
@RequiredArgsConstructor
public class MarkServiceImpl implements MarkService {

    private final MarkRepository markRepository;
    private final AuthenticationService authenticationService;
    private final StudentService studentService;
    private final TeacherService teacherService;
    private final SubjectService subjectService;
    private final MarkMapper markMapper;

    @Override
    public MarkDto createMark(final CreateMarkDto createMarkDto) {
        final Student student = studentService.getById(createMarkDto.getStudentId());
        final Teacher teacher = teacherService.getById(createMarkDto.getTeacherId());
        final Subject subject = subjectService.getById(createMarkDto.getSubjectId());

        final Mark mark = Mark.builder()
                .mark(createMarkDto.getMark())
                .student(student)
                .teacher(teacher)
                .subject(subject)
                .modificationDate(LocalDate.now())
                .build();

        return markMapper.markToMarkDto(markRepository.save(mark));
    }

    @Override
    public MarkDto updateMark(final UpdateMarkDto updateMarkDto) {
        final Mark mark = markRepository.findById(updateMarkDto.getId())
                .orElseThrow(() -> new MissingPropertiesException("Missing mark properties for update"));

        return markMapper.markToMarkDto(markRepository.save(markMapper.updateMark(updateMarkDto, mark)));
    }

    @Override
    public Page<MarkDto> getByStudent(String studentId, Pageable pageable) {
        if (Objects.isNull(studentId)) {
            if (!authenticationService.hasRole(RoleName.ROLE_STUDENT)) {
                throw new RuntimeException("NQMA PYK");
            }

            return getMarksForStudent(authenticationService.getCurrentUserId(), pageable);
        }

        return getMarksForStudent(studentId, pageable);
    }

    @Override
    public Page<MarkDto> getByStudentAndSubject(Subject subject, Pageable pageable) {
        final Student student = studentService.getById(authenticationService.getCurrentUserId());

        return markRepository.getByStudentAndSubject(student, subject, pageable)
                .map(markMapper::markToMarkDto);
    }

    @Override
    public ApiResponseDto deleteMark(final String id) {
        final Mark mark = markRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Mark", id));

        markRepository.delete(mark);

        return new ApiResponseDto(true, "The leave is deleted successfully!");
    }

    private Page<MarkDto> getMarksForStudent(final String studentId, final Pageable pageable) {
        final Student student = studentService.getById(studentId);

        return markRepository.getByStudent(student, pageable)
                .map(markMapper::markToMarkDto);
    }
}
