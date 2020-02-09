package com.ejournal.java.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.ejournal.java.dtos.group.CreateGroupDto;
import com.ejournal.java.dtos.group.GroupDto;
import com.ejournal.java.entities.Group;

/**
 * Created by kristiyan.parvanov on 27.12.19 г.
 */
public interface GroupService {

    GroupDto createGroup(CreateGroupDto createGroupDto);

    GroupDto updateGroup(GroupDto groupDto);

    GroupDto getGroup(String id);

    Page<GroupDto> getAllGroups(String schoolId, Pageable pageable);

    void deleteGroup(String id);

    Group getById(String id);
}
