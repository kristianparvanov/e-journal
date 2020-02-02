package com.ejournal.java.dtos.auhtentication;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by kristiyan.parvanov on 13.12.19 г.
 */
@Getter
@Setter
public class RegisterRequestDto {

    @NotBlank
    @Size(min = 3, max = 15)
    private String username;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = 4, max = 20)
    private String firstName;

    @NotBlank
    @Size(min = 4, max = 20)
    private String middleName;

    @NotBlank
    @Size(min = 4, max = 20)
    private String lastName;

    @NotBlank
    @Size(min = 10, max = 10, message = "Length must be exact 10")
    private String egn;
}
