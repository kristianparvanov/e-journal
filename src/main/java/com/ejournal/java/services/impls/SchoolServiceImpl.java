package com.ejournal.java.services.impls;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.ejournal.java.dtos.school.CreateSchoolDto;
import com.ejournal.java.dtos.school.SchoolDto;
import com.ejournal.java.entities.School;
import com.ejournal.java.exceptions.EntityExistsException;
import com.ejournal.java.exceptions.EntityNotFoundException;
import com.ejournal.java.exceptions.MissingPropertiesException;
import com.ejournal.java.mappers.SchoolMapper;
import com.ejournal.java.repositories.SchoolRepository;
import com.ejournal.java.services.SchoolService;
import lombok.RequiredArgsConstructor;

/**
 * Created by kristiyan.parvanov on 27.12.19 г.
 */
@Service
@RequiredArgsConstructor
public class SchoolServiceImpl implements SchoolService {

    private static final String SCHOOL = "School";

    private final SchoolRepository schoolRepository;
    private final SchoolMapper schoolMapper;

    @Override
    public SchoolDto createSchool(final CreateSchoolDto createSchoolDto) {
        if (schoolRepository.existsByCityAndName(createSchoolDto.getCity(), createSchoolDto.getName())) {
            throw new EntityExistsException(SCHOOL);
        }

        return schoolMapper.schoolToSchoolDto(schoolRepository.save(schoolMapper.createSchoolDtoToSchool(createSchoolDto)));
    }

    @Override
    public Page<SchoolDto> getAllSchools(final Pageable pageable) {
        return schoolRepository.findAll(pageable)
                .map(schoolMapper::schoolToSchoolDto);
    }

    @Override
    public Page<SchoolDto> getSchools(final String name, final Pageable pageable) {
        if (StringUtils.isBlank(name)) {
            return schoolRepository.findAll(pageable)
                    .map(schoolMapper::schoolToSchoolDto);
        }

        return schoolRepository.findByNameContaining(name, pageable)
                .map(schoolMapper::schoolToSchoolDto);
    }

    @Override
    public SchoolDto getSchool(final String id) {
        return schoolMapper.schoolToSchoolDto(getById(id));
    }

    @Override
    public School getById(final String id) {
        return schoolRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(SCHOOL, id));
    }

    @Override
    public SchoolDto updateSchool(final SchoolDto schoolDto) {
        if (StringUtils.isBlank(schoolDto.getName()) && StringUtils.isBlank(schoolDto.getCity())) {
            throw new MissingPropertiesException(SCHOOL);
        }

        final School school = getById(schoolDto.getId());

        return schoolMapper.schoolToSchoolDto(schoolRepository.save(schoolMapper.updateSchool(schoolDto, school)));
    }

    @Override
    public void deleteSchool(String id) {
        schoolRepository.deleteById(id);
    }
}
