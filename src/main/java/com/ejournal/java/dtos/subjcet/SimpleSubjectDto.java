package com.ejournal.java.dtos.subjcet;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by kristiyan.parvanov on 28.01.20 г.
 */
@Data
public class SimpleSubjectDto {

    @NotNull
    private Long id;
    private String name;
}
