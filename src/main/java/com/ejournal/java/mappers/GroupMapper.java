package com.ejournal.java.mappers;

import org.mapstruct.BeanMapping;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import com.ejournal.java.dtos.group.CreateGroupDto;
import com.ejournal.java.dtos.group.GroupDto;
import com.ejournal.java.entities.Group;

/**
 * Created by kristiyan.parvanov on 27.12.19 г.
 */
@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface GroupMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "teachers", ignore = true)
    @Mapping(target = "students", ignore = true)
    @Mapping(target = "school", ignore = true)
    @Mapping(target = "schedules", ignore = true)
    Group createGroupToGroup(CreateGroupDto createGroupDto);

    GroupDto groupToGroupDto(Group group);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "school", ignore = true)
    @Mapping(target = "teachers", ignore = true)
    @Mapping(target = "students", ignore = true)
    @Mapping(target = "schedules", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    Group updateGroup(GroupDto groupDto, @MappingTarget Group group);
}
