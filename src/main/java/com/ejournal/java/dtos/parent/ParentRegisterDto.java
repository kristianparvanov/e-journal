package com.ejournal.java.dtos.parent;

import java.util.List;
import javax.validation.constraints.NotNull;

import com.ejournal.java.dtos.auhtentication.RegisterRequestDto;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by kristiyan.parvanov on 26.12.19 г.
 */
@Getter
@Setter
public class ParentRegisterDto extends RegisterRequestDto {

    @NotNull
    private List<Long> studentId;
}
