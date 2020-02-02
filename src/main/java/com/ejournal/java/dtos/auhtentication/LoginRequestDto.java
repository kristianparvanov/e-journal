package com.ejournal.java.dtos.auhtentication;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by kristiyan.parvanov on 13.12.19 г.
 */
@Getter
@Setter
public class LoginRequestDto {

    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
