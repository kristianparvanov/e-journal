package com.ejournal.java.annotations;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotBlank;

/**
 * Created by kristiyan.parvanov on 27.12.19 г.
 */
@Target({ TYPE, FIELD, ANNOTATION_TYPE})
@Constraint(validatedBy = PasswordConstraintValidator.class)
@Retention(RUNTIME)
@NotBlank
public @interface ValidPassword {

    String PASSWORD_RULES_MESSAGE = "The password must be between 6 and 20 symbols and must contain: "
            + "at least 1 upper case letter, 1 lower case letter, 1 digit!";

    String message() default PASSWORD_RULES_MESSAGE;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
