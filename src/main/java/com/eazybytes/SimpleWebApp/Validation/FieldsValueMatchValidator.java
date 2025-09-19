package com.eazybytes.SimpleWebApp.Validation;

import com.eazybytes.SimpleWebApp.annotation.FieldsValueMatch;
import com.eazybytes.SimpleWebApp.annotation.PasswordValidator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;

public class FieldsValueMatchValidator implements ConstraintValidator<FieldsValueMatch, Object>{

    private String field;
    private String fielddMatch;


    @Override
    public void initialize(FieldsValueMatch constraintAnnotation) {
       this.field = constraintAnnotation.field();
       this.fielddMatch = constraintAnnotation.fieldMatch();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        Object fieldValue = new BeanWrapperImpl(o).getPropertyValue(field);
        Object fieldMatchValue = new BeanWrapperImpl(o).getPropertyValue(fielddMatch);

        if(fieldValue != null){
            return fieldValue.equals(fieldMatchValue);
        }
        else{
            return fieldMatchValue == null;
        }
    }
}
