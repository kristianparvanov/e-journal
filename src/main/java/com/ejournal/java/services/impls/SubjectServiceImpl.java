package com.ejournal.java.services.impls;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.ejournal.java.dtos.subjcet.CreateSubjectDto;
import com.ejournal.java.dtos.subjcet.SubjectDto;
import com.ejournal.java.entities.Subject;
import com.ejournal.java.exceptions.MissingSubjectUpdateProperties;
import com.ejournal.java.exceptions.SubjectDoesNotExistException;
import com.ejournal.java.mappers.SubjectMapper;
import com.ejournal.java.repositories.SubjectRepository;
import com.ejournal.java.services.SubjectService;
import lombok.RequiredArgsConstructor;

/**
 * Created by kristiyan.parvanov on 30.12.19 г.
 */
@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;
    private final SubjectMapper subjectMapper;

    @Override
    public SubjectDto createSubject(final CreateSubjectDto createSubjectDto) {
        return subjectMapper.subjectToSubjectDto(subjectRepository.save(subjectMapper.createSubjectDtoToSubject(createSubjectDto)));
    }

    @Override
    public SubjectDto updateSubject(final SubjectDto subjectDto) {
        if (StringUtils.isBlank(subjectDto.getName()) && StringUtils.isBlank(subjectDto.getDescription())) {
            throw new MissingSubjectUpdateProperties();
        }

        final Subject subject = getById(subjectDto.getId());

        return subjectMapper.subjectToSubjectDto(subjectRepository.save(subjectMapper.updateSubject(subjectDto, subject)));
    }

    @Override
    public Subject getById(final String id) {
        return subjectRepository.findById(id)
                .orElseThrow(SubjectDoesNotExistException::new);
    }

    @Override
    public SubjectDto getSubject(final String id) {
        return subjectRepository.findById(id)
                .map(subjectMapper::subjectToSubjectDto)
                .orElseThrow(SubjectDoesNotExistException::new);
    }

    @Override
    public Page<SubjectDto> getAllSubjects(final String name, final Pageable pageable) {
        if (StringUtils.isBlank(name)) {
            return subjectRepository.findAll(pageable)
                    .map(subjectMapper::subjectToSubjectDto);
        }

        return subjectRepository.findByNameContaining(name, pageable)
                .map(subjectMapper::subjectToSubjectDto);
    }

    @Override
    public void deleteSubject(final String id) {
        subjectRepository.deleteById(id);
    }
}
