package com.ejournal.java.annotations;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * Created by kristiyan.parvanov on 27.12.19 г.
 */
@Target({ ANNOTATION_TYPE, TYPE})
@Constraint(validatedBy = PasswordMatchValidator.class)
@Retention(RUNTIME)
public @interface PasswordMatch {

    String message() default "The passwords must match";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String first();
    String second();

    @Target({TYPE, ANNOTATION_TYPE})
    @Retention(RUNTIME)
    @interface List
    {
        PasswordMatch[] value();
    }
}
