package com.ejournal.java.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by kristiyan.parvanov on 13.12.19 г.
 */
@AllArgsConstructor
@Getter
@Setter
public class ApiResponseDto {

    private Boolean success;
    private String message;
}
