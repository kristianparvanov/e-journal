package com.ejournal.java.exceptions.handler;

import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.ejournal.java.dtos.ApiResponseDto;
import com.ejournal.java.exceptions.EntityExistsException;
import com.ejournal.java.exceptions.EntityNotFoundException;
import com.ejournal.java.exceptions.MissingPropertiesException;
import com.ejournal.java.exceptions.UserRoleNotSetException;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by kristiyan.parvanov on 13.12.19 г.
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ UserRoleNotSetException.class, EntityNotFoundException.class,
            MissingPropertiesException.class, EntityExistsException.class })
    public ApiResponseDto userAlreadyExists(Exception exception) {
        log.info(exception.getMessage(), exception);

        return new ApiResponseDto(false, exception.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ApiResponseDto handleArgumentNotValid(MethodArgumentNotValidException exception) {
        final Map<String, String> errorList = exception
                .getBindingResult()
                .getFieldErrors().stream()
                .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));

        log.info(exception.getMessage(), exception);

        return new ApiResponseDto(false, errorList.toString());
    }
}
