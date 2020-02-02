package com.ejournal.java.services;

import com.ejournal.java.dtos.ApiResponseDto;
import com.ejournal.java.dtos.parent.ParentDto;
import com.ejournal.java.dtos.parent.ParentRegisterDto;

/**
 * Created by kristiyan.parvanov on 27.12.19 г.
 */
public interface ParentService {

    ParentDto register(ParentRegisterDto parentRegisterDto);

    ApiResponseDto delete(Long id);
}
