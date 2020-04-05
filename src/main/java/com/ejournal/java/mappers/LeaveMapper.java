package com.ejournal.java.mappers;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.ejournal.java.dtos.leave.LeaveDto;
import com.ejournal.java.dtos.leave.LeaveStudentDto;
import com.ejournal.java.entities.Leave;

/**
 * Created by kristiyan.parvanov on 28.01.20 г.
 */
@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = {TeacherMapper.class, SubjectMapper.class})
public interface LeaveMapper {

    @Mapping(target = "date", source = "leave.modificationDate")
    LeaveDto leaveToLeaveDto(Leave leave);

    @Mapping(target = "date", source = "leave.modificationDate")
    LeaveStudentDto leaveToLeaveStudentDto(Leave leave);
}
