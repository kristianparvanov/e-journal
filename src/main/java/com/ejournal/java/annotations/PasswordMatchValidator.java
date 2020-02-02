package com.ejournal.java.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanWrapperImpl;

/**
 * Created by kristiyan.parvanov on 27.12.19 г.
 */
public class PasswordMatchValidator implements ConstraintValidator<PasswordMatch, Object> {

    private String password;
    private String repeatedPassword;
    private String message;

    @Override
    public void initialize(PasswordMatch constraintAnnotation) {
        password = constraintAnnotation.first();
        repeatedPassword = constraintAnnotation.second();
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext context) {
        final String pass = (String) new BeanWrapperImpl(object).getPropertyValue(password);
        final String repeatedPass = (String) new BeanWrapperImpl(object).getPropertyValue(repeatedPassword);

        if (!StringUtils.isNotBlank(pass) || !pass.equals(repeatedPass)) {
            context.buildConstraintViolationWithTemplate(message)
                    .addPropertyNode(repeatedPassword)
                    .addConstraintViolation();

            return false;
        }

        return true;
//        return StringUtils.isNotBlank(pass) && pass.equals(repeatedPass);
    }
}
