package com.app.Service;

import com.app.model.User;
import com.app.notes.PasswordMatches;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator
        implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context){
        User user = (User) obj;
        return user.getPassword().equals(user.getPasswordConfirmation());
    }
}
