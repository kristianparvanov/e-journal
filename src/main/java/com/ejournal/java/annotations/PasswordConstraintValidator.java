package com.ejournal.java.annotations;

import java.util.Arrays;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.LengthRule;
import org.passay.PasswordData;
import org.passay.PasswordValidator;
import org.passay.WhitespaceRule;

/**
 * Created by kristiyan.parvanov on 27.12.19 г.
 */
public class PasswordConstraintValidator implements ConstraintValidator<ValidPassword, String> {

    private static final int PASS_MIN_LENGTH = 6;
    private static final int PASS_MAX_LENGTH = 20;

    @Override
    public void initialize(ValidPassword constraintAnnotation) {
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        PasswordValidator validator = new PasswordValidator(Arrays.asList(
                new LengthRule(PASS_MIN_LENGTH, PASS_MAX_LENGTH),
                new CharacterRule(EnglishCharacterData.UpperCase),
                new CharacterRule(EnglishCharacterData.LowerCase),
                new CharacterRule(EnglishCharacterData.Digit),
                new WhitespaceRule()
        ));

        return validator.validate(new PasswordData(password)).isValid();
    }
}
