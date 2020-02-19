package com.ejournal.java.services.impls;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.ejournal.java.dtos.group.CreateGroupDto;
import com.ejournal.java.dtos.group.GroupDto;
import com.ejournal.java.entities.Group;
import com.ejournal.java.entities.School;
import com.ejournal.java.exceptions.EntityNotFoundException;
import com.ejournal.java.exceptions.MissingPropertiesException;
import com.ejournal.java.mappers.GroupMapper;
import com.ejournal.java.repositories.GroupRepository;
import com.ejournal.java.services.GroupService;
import com.ejournal.java.services.SchoolService;
import lombok.RequiredArgsConstructor;

/**
 * Created by kristiyan.parvanov on 27.12.19 г.
 */
@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private static final String GROUP = "Group";

    private final GroupRepository groupRepository;
    private final GroupMapper groupMapper;
    private final SchoolService schoolService;

    @Override
    public GroupDto createGroup(final CreateGroupDto createGroupDto) {
        final Group group = groupMapper.createGroupToGroup(createGroupDto);
        final School school = schoolService.getById(createGroupDto.getSchoolId());

        group.setSchool(school);

        return groupMapper.groupToGroupDto(groupRepository.save(group));
    }

    @Override
    public GroupDto updateGroup(final GroupDto groupDto) {
        if (!canUpdate(groupDto)) {
            throw new MissingPropertiesException(GROUP);
        }

        final Group group = getById(groupDto.getId());

        return groupMapper.groupToGroupDto(groupMapper.updateGroup(groupDto, group));
    }

    private boolean canUpdate(final GroupDto groupDto) {
        final Integer level = groupDto.getLevel();
        final String name = groupDto.getName();
        final Integer year = groupDto.getYear();

        return (Objects.isNull(level) && StringUtils.isBlank(name) && Objects.isNull(year))
                || ((level < 1 || level > 12) && StringUtils.isBlank(name) && year < 2000);
    }

    @Override
    public GroupDto getGroup(final String id) {
        return groupMapper.groupToGroupDto(getById(id));
    }

    @Override
    public Page<GroupDto> getAllGroups(final String schoolId, final Pageable pageable) {
        if (Objects.isNull(schoolId)) {
            return groupRepository.findAll(pageable)
                    .map(groupMapper::groupToGroupDto);
        }

        final School school = schoolService.getById(schoolId);

        return groupRepository.findBySchool(school, pageable)
                .map(groupMapper::groupToGroupDto);
    }

    @Override
    public void deleteGroup(final String id) {
        groupRepository.deleteById(id);
    }

    @Override
    public Group getById(final String id) {
        return groupRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(GROUP, id));
    }
}
