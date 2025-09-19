package com.eazybytes.SimpleWebApp.Validation;

import com.eazybytes.SimpleWebApp.annotation.PasswordValidator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;

public class PasswordStrengthValidator implements ConstraintValidator<PasswordValidator, String> {
    List<String> weakPassword;

    @Override
    public void initialize(PasswordValidator constraintAnnotation) {
       weakPassword = Arrays.asList("12345", "password", "qwerty");
    }

    @Override
    public boolean isValid(String passwordField, ConstraintValidatorContext constraintValidatorContext) {
        return passwordField != null && (!weakPassword.contains(passwordField));
    }
}
