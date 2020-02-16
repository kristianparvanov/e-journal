package com.ejournal.java.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.ejournal.java.dtos.ApiResponseDto;
import com.ejournal.java.dtos.leave.CreateLeaveDto;
import com.ejournal.java.dtos.leave.LeaveDto;
import com.ejournal.java.dtos.leave.UpdateLeaveDto;
import com.ejournal.java.entities.Subject;

/**
 * Created by kristiyan.parvanov on 5.01.20 г.
 */
public interface LeaveService {

    LeaveDto createLeave(CreateLeaveDto createLeaveDto);

    LeaveDto updateLeave(UpdateLeaveDto updateLeaveDto);

    Page<LeaveDto> getByStudent(String studentId, Pageable pageable);

    Page<LeaveDto> getByStudentAndSubject(Subject subject, Pageable pageable);

    ApiResponseDto deleteLeave(String id);
}
