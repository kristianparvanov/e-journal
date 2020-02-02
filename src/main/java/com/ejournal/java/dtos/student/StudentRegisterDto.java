package com.ejournal.java.dtos.student;

import javax.validation.constraints.NotNull;

import com.ejournal.java.dtos.auhtentication.RegisterRequestDto;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by kristiyan.parvanov on 26.12.19 г.
 */
@Getter
@Setter
public class StudentRegisterDto extends RegisterRequestDto {

    @NotNull
    private Long groupId;

    @NotNull
    private Long schoolId;

    private Long parentId;
}
